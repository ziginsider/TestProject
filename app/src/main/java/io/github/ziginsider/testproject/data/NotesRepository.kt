package io.github.ziginsider.testproject.data

interface NotesRepository {

    interface LoadNotesCallback {

        fun onNotesLoaded(notes: List<Note>)
    }

    interface GetNotesCallback {

        fun onNoteLoaded(note: Note)
    }

    fun getNotes(callback: LoadNotesCallback)

    fun getNote(noteId: String, callback: GetNotesCallback)

    fun saveNote(note: Note)

    fun refreshData()
}
