package com.padc.padcfirebase.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padc.padcfirebase.delegates.ArticleItemDelegate
import com.padc.padcfirebase.mvp.views.ArticlesView

class ArticlesPresenter: BasePresenter<ArticlesView>(), ArticleItemDelegate {

    fun onUIReady(owner: LifecycleOwner){

    }


    override fun onArticleItemClicked(data: Any) {
        mView.navigateToDetail("")
    }
}