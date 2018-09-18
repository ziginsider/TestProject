package io.github.ziginsider.testproject.util

import android.support.test.espresso.IdlingResource
import java.lang.IllegalArgumentException
import java.util.concurrent.atomic.AtomicInteger

/**
 * A simple counter implementation of [IdlingResource] that determines idleness by
 * maintaining an internal counter. When the counter is 0 - it is considered to be idle, when it is
 * non-zero it is not idle. This is very similar to the way a [Semaphore] behaves.
 *
 * This class can then be used to wrap up operations that while in progress should block tests from
 * accessing the UI.
 *
 * @author Alex Kisel
 * @since 2018-09-18
 */
class SimpleCountingIdlingResourse(val resourceName: String) : IdlingResource {

    @Volatile
    private var resourceCallback: IdlingResource.ResourceCallback? = null

    private val counter = AtomicInteger(0)

    override fun getName() = resourceName

    override fun isIdleNow() = counter.get() == 0

    override fun registerIdleTransitionCallback(callback: IdlingResource.ResourceCallback?) {
        resourceCallback = callback
    }

    /**
     * Increments the count of in-flight transactions to the resource being monitored.
     */
    fun increment() {
        counter.getAndIncrement()
    }

    /**
    * Decrements the count of in-flight transactions to the resource being monitored.
    *
    * If this operation results in the counter falling below 0 - an exception is raised.
    *
    * @throws IllegalStateException if the counter is below 0.
    */
    fun decrement() {
        val counterVal = counter.decrementAndGet()
        if (counterVal == 0) {
            // we've gone from non-zero to zero. That means we're idle now! Tell espresso.
            resourceCallback?.onTransitionToIdle()
        }
        if (counterVal < 0) {
            throw IllegalArgumentException("Counter has been corrupted!")
        }
    }
}