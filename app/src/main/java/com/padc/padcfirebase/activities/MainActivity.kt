package com.padc.padcfirebase.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProviders
import com.padc.padcfirebase.R
import com.padc.padcfirebase.adapters.ArticlesAdapter
import com.padc.padcfirebase.mvp.presenters.ArticlesPresenter
import com.padc.padcfirebase.mvp.views.ArticlesView

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ArticlesView {

    private lateinit var adapter: ArticlesAdapter
    private lateinit var presenter: ArticlesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupPresenter()
        setSupportActionBar(toolbar)
        setupRecyclerView()
        presenter.onUIReady(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun navigateToDetail(id: String) {
        startActivity(DetailActivity.newIntent(this))
    }

    private fun setupRecyclerView(){
        recyclerArticles.setHasFixedSize(true)
        adapter = ArticlesAdapter(presenter)
        recyclerArticles.adapter = adapter
    }

    private fun setupPresenter(){
        presenter = ViewModelProviders.of(this).get(ArticlesPresenter::class.java).apply {
            initPresenter(this@MainActivity)
        }
    }
}
