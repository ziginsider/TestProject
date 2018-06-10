package io.github.ziginsider.testproject.data

class InMemoryNotesRepository : NotesRepository {
    override fun getNotes(callback: NotesRepository.LoadNotesCallback) {
        
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