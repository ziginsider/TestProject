package io.github.ziginsider.testproject.data

import android.support.annotation.VisibleForTesting
import com.google.common.collect.ImmutableList

/**
 * Concrete implementation to load notes from the a data source.
 *
 * @author Alex Kisel
 * @since 2018-06-20
 */
class InMemoryNotesRepository(private val notesServiceApi: NotesServiceApi) : NotesRepository {

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

    override fun saveNote(note: Note) {
        notesServiceApi.saveNote(note)
        refreshData()
    }

    override fun getNote(noteId: String, callback: NotesRepository.GetNoteCallback) {
        notesServiceApi.getNote(noteId, object : NotesServiceApi.NotesServiceCallback<Note> {
            override fun onLoaded(note: Note) {
                callback.onNoteLoaded(note)
            }
        })
    }

    override fun refreshData() {
        cashNotes = null
    }
}
