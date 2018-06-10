package io.github.ziginsider.testproject.data

import android.support.annotation.VisibleForTesting
import com.google.common.collect.ImmutableList

class InMemoryNotesRepository(val notesServiceApi: NotesServiceApi) : NotesRepository {

    @VisibleForTesting
    var cashNotes: List<Note>? = null

    override fun getNotes(callback: NotesRepository.LoadNotesCallback) {
        if (cashNotes == null) {
            notesServiceApi.getAllNotes(object : NotesServiceApi.NotesServiceCallback<List<Note>> {
                override fun onLoaded(notes: List<Note>) {
                    cashNotes = ImmutableList.copyOf(notes)
                    callback.onNotesLoaded(cashNotes)
                }
            })
        } else {
            callback.onNotesLoaded(cashNotes)
        }
    }

    override fun getNote(noteId: String, callback: NotesRepository.GetNoteCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveNote(note: Note) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun refreshData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}