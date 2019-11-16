package com.padc.padcfirebase.data.models

import androidx.lifecycle.LiveData
import com.padc.padcfirebase.data.vos.ArticleVO

interface FirebaseModel {

    fun getAllArticles(): LiveData<List<ArticleVO>>

    fun getArticleById(id: String): LiveData<ArticleVO>
}