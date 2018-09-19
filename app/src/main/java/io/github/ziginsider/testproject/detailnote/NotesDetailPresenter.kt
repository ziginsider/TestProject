package io.github.ziginsider.testproject.detailnote

import io.github.ziginsider.testproject.data.Note
import io.github.ziginsider.testproject.data.NotesRepository

/**
 * Listen to user actions from the UI ([NoteDetailFragment]), retrieves the data
 * and updates the UI as required.
 *
 *
 */
class NotesDetailPresenter(
    private val notesRepository: NotesRepository,
    private val noteDetailView: NoteDetailContract.View
) : NoteDetailContract.UserActionsListener {

    override fun openNote(noteId: String?) {
        if (noteId == null || noteId.isEmpty()) {
            noteDetailView.showMissingNote()
            return
        }

        noteDetailView.setProgressIndicator(true)
        notesRepository.getNote(noteId, object : NotesRepository.GetNoteCallback {
            override fun onNoteLoaded(note: Note?) {
                noteDetailView.setProgressIndicator(false)
                if (note == null) {
                    noteDetailView.showMissingNote()
                } else {
                    showNote(note)
                }
            }
        })
    }

    private fun showNote(note: Note) {
        val title = note.title
        val description = note.description
        val imageUrl = note.imgUrl

        title?.let {
            if (it.isEmpty()) {
                noteDetailView.hideTitle()
            } else {
                noteDetailView.showTitle(it)
            }
        }

        description?.let {
            if (it.isEmpty()) {
                noteDetailView.hideDescription()
            } else {
                noteDetailView.showDescription(description)
            }
        }

        imageUrl?.let {
            noteDetailView.showImage(imageUrl)
        } ?: run {
            noteDetailView.hideImage()
        }
    }
}