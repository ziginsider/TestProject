package io.github.ziginsider.testproject.detailnote

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import io.github.ziginsider.testproject.R
import io.github.ziginsider.testproject.util.bindView

class NoteDetailFragment : Fragment(), NoteDetailContract.View {

    private val detailTitle: TextView by bindView(R.id.note_detail_title)
    private val detailDescription: TextView by bindView(R.id.note_detail_description)
    private val detailImage: ImageView by bindView(R.id.note_detail_image)

    private var actionListener: NoteDetailContract.UserActionsListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        actionListener = NoteDetailPresenter(Injection.provideNotesRepository(), this)
    }

    override fun setProgressNote() {
    }

    override fun showMissingNote() {
    }

    override fun hideTitle() {
    }

    override fun showTitle(title: String) {
    }

    override fun showImage(imageUrl: String) {
    }

    override fun hideImage() {
    }

    override fun hideDescription() {
    }

    override fun showDescription(description: String) {
    }

    companion object {

        const val ARGUMENT_NOTE_ID = "NOTE_ID"

        @JvmStatic
        fun newInstance(noteId: String): NoteDetailFragment {
            return NoteDetailFragment().apply {
                arguments = bundleOf(ARGUMENT_NOTE_ID to noteId)
            }
        }
    }
}
