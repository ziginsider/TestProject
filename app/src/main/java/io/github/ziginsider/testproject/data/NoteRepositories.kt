package io.github.ziginsider.testproject.data

class NoteRepositories {

    companion object {
        var repository: NotesRepository? = null

        @Synchronized
        fun getInMemoryRepoInstance(notesServiceApi: NotesServiceApi): NotesRepository {
            //checkNotNull(notesServiceApi)
            if (null == repository) {
                repository = InMemoryNotesRepository(notesServiceApi)
            }
            return repository as NotesRepository
        }
    }
}

