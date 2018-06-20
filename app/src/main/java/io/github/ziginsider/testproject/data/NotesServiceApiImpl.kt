package io.github.ziginsider.testproject.data

import android.os.Handler

/**
 * Implementation of the Notes Service API that adds a latency simulating network.
 *
 * @author Alex Kisel
 * @since 2018-06-20
 */
class NotesServiceApiImpl : NotesServiceApi {

    override fun getAllNotes(callback: NotesServiceApi.NotesServiceCallback<List<Note>>) {
        Handler().postDelayed({
            val notes = ArrayList(NOTES_SERVICE_DATA?.values)
            callback.onLoaded(notes)
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    override fun getNote(noteId: String, callback: NotesServiceApi.NotesServiceCallback<Note>) {
        //TODO: Add network latency here too.
        val note = NOTES_SERVICE_DATA?.get(noteId)
        note?.let {
            callback.onLoaded(it)
        }
    }

    override fun saveNote(note: Note) {
        NOTES_SERVICE_DATA?.put(note.id, note)
    }

    companion object {

        private const val SERVICE_LATENCY_IN_MILLIS = 2000L
        private val NOTES_SERVICE_DATA = NotesServiceApiEndpoint.loadPersistedNotes()
    }
}