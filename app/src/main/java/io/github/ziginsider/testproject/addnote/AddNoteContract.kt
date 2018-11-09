package io.github.ziginsider.testproject.addnote

import java.io.IOException

interface AddNoteContract {

    interface View {

        fun showEmptyNoteError()

        fun showNotesList()

        fun openCamera(saveTo: String)

        fun showImagePreview(uri: String)

        fun showImageError()
    }

    interface UserActionsListener {

        fun saveNote(title: String, description: String)

        @Throws(IOException::class)
        fun takePicture()

        fun imageAvailable()

        fun imageCaptureFailed()
    }
}