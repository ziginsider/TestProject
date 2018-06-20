package io.github.ziginsider.testproject.data

interface NotesServiceApi {

    interface NotesServiceCallback<T> {

        fun onLoaded(notes: T)
    }

    fun getAllNotes(callback: NotesServiceCallback<List<Note>>)

    fun getNote(noteId: String, callback: NotesServiceCallback<Note>)

    fun saveNote(note: Note)
}
