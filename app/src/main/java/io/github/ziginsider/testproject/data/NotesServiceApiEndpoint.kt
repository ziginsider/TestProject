package io.github.ziginsider.testproject.data

import android.support.v4.util.ArrayMap

/**
 * This is the endpoint for your data source. Typically, it would be a SQLite db and/or a server
 * API. In this example, we fake this by creating the data on the fly.
 *
 * @author Alex Kisel
 * @since 2018-06-20
 */
class NotesServiceApiEndpoint {

    companion object {

        private var DATA: ArrayMap<String, Note>? = null

        init {
            DATA = ArrayMap(2)
            addNote("Oh yes!", "I demand trial by Unit testing", null)
            addNote("Espresso", "UI Testing for Android", null)
        }

        private fun addNote(title: String, description: String, imgUrl: String?) {
            val newNote = Note(title, description, imgUrl)
            DATA?.put(newNote.id, newNote)
        }

        fun loadPersistedNotes() = DATA
    }
}
