package com.padc.padcfirebase.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.padc.padcfirebase.R
import com.padc.padcfirebase.data.vos.ArticleVO
import com.padc.padcfirebase.mvp.presenters.ArticleDetailPresenter
import com.padc.padcfirebase.mvp.views.ArticleDetailView
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_detail.*

class DetailActivity : AppCompatActivity(), ArticleDetailView {

    private lateinit var presenter: ArticleDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setupPresenter()

        val id = intent.getStringExtra(EXTRA_ID)!!
        presenter.onUIReady(this,id)
    }

    override fun showArticle(data: ArticleVO) {
        container.visibility = VISIBLE
        Glide.with(this)
            .load(data.img)
            .into(ivArticle)
        tvTitle.text = data.title

        if (data.claps > 0) {
            tvClaps.text = data.claps.toString()
        } else {
            tvClaps.text = ""
        }

        if (data.comments_count > 0) {
            tvComments.text = data.comments_count.toString()
        } else {
            tvComments.text = ""
        }

        tvDate.text = data.date
        tvBody.text = data.body
    }

    companion object {

        private const val EXTRA_ID = "article_id"

        fun newIntent(context: Context, id: String): Intent =
            Intent(context, DetailActivity::class.java).apply {
                putExtra(EXTRA_ID, id)
            }
    }

    private fun setupPresenter() {
        presenter = ViewModelProviders.of(this).get(ArticleDetailPresenter::class.java)
        presenter.initPresenter(this)
    }
}
