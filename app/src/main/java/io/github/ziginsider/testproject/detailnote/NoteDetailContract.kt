package io.github.ziginsider.testproject.detailnote

/**
 * This specifies the contract between the view and the presenter.
 *
 * @author Alex Kisel
 * @since 2018-09-18
 */
interface NoteDetailContract {

    interface View {

        fun setProgressNote()

        fun showMissingNote()

        fun hideTitle()

        fun showTitle(title: String)

        fun showImage(imageUrl: String)

        fun hideImage()

        fun hideDescription()

        fun showDescription(description: String)
    }

    interface UserActionsListener {

        fun openNote(noteId: String?)
    }
}