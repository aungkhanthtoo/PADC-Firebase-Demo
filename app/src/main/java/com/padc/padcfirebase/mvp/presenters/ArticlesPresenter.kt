package com.padc.padcfirebase.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.padc.padcfirebase.data.models.FirebaseModel
import com.padc.padcfirebase.data.models.FirebaseModelImpl
import com.padc.padcfirebase.data.vos.ArticleVO
import com.padc.padcfirebase.delegates.ArticleItemDelegate
import com.padc.padcfirebase.mvp.views.ArticlesView
import java.util.*

class ArticlesPresenter: BasePresenter<ArticlesView>(), ArticleItemDelegate {

    private val model : FirebaseModel = FirebaseModelImpl
    private val clearedLiveData = MutableLiveData<Unit>()

    fun onUIReady(owner: LifecycleOwner){
        model.getAllArticles(clearedLiveData).observe(owner, Observer {
            mView.showArticles(it)
        })
    }

    override fun onArticleItemClicked(data: ArticleVO) {
        mView.navigateToDetail(data.id)
    }

    override fun onCleared() {
        clearedLiveData.value = Unit
        super.onCleared()
    }
}