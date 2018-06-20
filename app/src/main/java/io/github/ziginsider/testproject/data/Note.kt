package io.github.ziginsider.testproject.data

import java.util.*

data class Note(val title: String?, val description: String?, val imgUrl: String? = null) {

    var id = UUID.randomUUID().toString()
        private set

    fun isEmpty() = title.isNullOrEmpty() && description.isNullOrEmpty()
}
