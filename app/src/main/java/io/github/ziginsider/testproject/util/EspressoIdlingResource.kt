package io.github.ziginsider.testproject.util

import android.support.test.espresso.IdlingResource

/**
 * Contains a static reference to [IdlingResource], only available in the mock build type.
 *
 * @author Alex Kisel
 * @since 2018-09-18
 */
class EspressoIdlingResource {

    companion object {
        private const val RESOURCE = "GLOBAL"
        private val countingIdlingResource = SimpleCountingIdlingResourse(RESOURCE)

        @JvmStatic
        fun increment() {
            countingIdlingResource.increment()
        }

        @JvmStatic
        fun decrement() {
            countingIdlingResource.decrement()
        }

        @JvmStatic
        fun getIdlingResource(): IdlingResource {
            return countingIdlingResource
        }
    }
}