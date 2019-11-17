package com.padc.padcfirebase.mvp.views

import com.padc.padcfirebase.data.vos.ArticleVO

interface ArticleDetailView : BaseGoogleSignInView{

    fun showArticle(data: ArticleVO)
    fun showCommentInputView()
}