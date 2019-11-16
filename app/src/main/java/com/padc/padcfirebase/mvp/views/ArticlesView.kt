package com.padc.padcfirebase.mvp.views

import com.padc.padcfirebase.data.vos.ArticleVO

interface ArticlesView: BaseView {

    fun navigateToDetail(id: String)
    fun showArticles(data: List<ArticleVO>)
}