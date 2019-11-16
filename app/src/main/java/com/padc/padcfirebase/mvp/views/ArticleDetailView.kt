package com.padc.padcfirebase.mvp.views

import com.padc.padcfirebase.data.vos.ArticleVO

interface ArticleDetailView : BaseView{

    fun showArticle(data: ArticleVO)
}