package io.github.ziginsider.testproject.data

interface NotesServiceApi {

    interface NotesServiceCallback<T> {

        fun onLoaded(notes: T)
    }

    fun getAllNotes(callback: NotesServiceCallback<List<Note>>)

    fun getNote(noteId: Note, callback: NotesServiceCallback<Note>)

    fun saveNote(note: Note)
}