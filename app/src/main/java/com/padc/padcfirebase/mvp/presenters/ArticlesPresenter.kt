package com.padc.padcfirebase.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padc.padcfirebase.data.models.FirebaseModel
import com.padc.padcfirebase.data.models.FirebaseModelImpl
import com.padc.padcfirebase.delegates.ArticleItemDelegate
import com.padc.padcfirebase.mvp.views.ArticlesView

class ArticlesPresenter: BasePresenter<ArticlesView>(), ArticleItemDelegate {

    private val model : FirebaseModel = FirebaseModelImpl

    fun onUIReady(owner: LifecycleOwner){
        model.getAllArticles().observe(owner, Observer {
            mView.showArticles(it)
        })
    }


    override fun onArticleItemClicked(data: Any) {
        mView.navigateToDetail("")
    }
}