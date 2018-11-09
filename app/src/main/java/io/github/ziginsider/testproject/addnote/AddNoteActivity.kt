package io.github.ziginsider.testproject.addnote

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.VisibleForTesting
import android.support.test.espresso.IdlingResource
import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import io.github.ziginsider.testproject.R
import io.github.ziginsider.testproject.util.EspressoIdlingResource

class AddNoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addnote)

        // Set up toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar?.apply {
            setTitle(R.string.add_note)
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        if (null == savedInstanceState) {
            initFragment(AddNoteFragment.newIstance())
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    @SuppressLint("CommitTransaction")
    private fun initFragment(detailFragment: Fragment) {
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction().apply {
            add(R.id.contentFrame, detailFragment)
            commit()
        }
    }

    @VisibleForTesting
    fun getCountingIdlingResource(): IdlingResource {
        return EspressoIdlingResource.getIdlingResource()
    }
}
