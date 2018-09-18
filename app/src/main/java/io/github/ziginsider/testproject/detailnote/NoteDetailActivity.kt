package io.github.ziginsider.testproject.detailnote

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.VisibleForTesting
import android.support.test.espresso.IdlingResource
import android.support.v7.widget.Toolbar
import io.github.ziginsider.testproject.R

class NoteDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        val noteId = intent.getStringExtra(EXTRA_NOTE_ID)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.contentFrame, NoteDetailFragment.newInstance(noteId))
            .commit()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    @VisibleForTesting
    fun getCountingIdlingResource(): IdlingResource {
        return EspressoIdlingResource.getIdlingResource()
    }

    companion object {
        @JvmStatic
        val EXTRA_NOTE_ID = "NOTE_ID"
    }
}
