package io.github.ziginsider.testproject.data

import android.support.v4.util.ArrayMap

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
