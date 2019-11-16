package com.padc.padcfirebase.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.padc.padcfirebase.data.models.FirebaseModel
import com.padc.padcfirebase.data.models.FirebaseModelImpl
import com.padc.padcfirebase.data.vos.ArticleVO
import com.padc.padcfirebase.mvp.views.ArticleDetailView

class ArticleDetailPresenter: BasePresenter<ArticleDetailView>() {

    private val model: FirebaseModel = FirebaseModelImpl
    private val clearedLiveData = MutableLiveData<Unit>()

    private lateinit var article: ArticleVO

    fun onUIReady(owner: LifecycleOwner, id: String) {
        model.getArticleById(id, clearedLiveData).observe(owner, Observer {
            mView.showArticle(it)
            article = it
        })
    }

    override fun onCleared() {
        clearedLiveData.value = Unit
        super.onCleared()
    }

    fun onClapped(count: Int) {
        model.updateClapCount(1, article)
    }
}