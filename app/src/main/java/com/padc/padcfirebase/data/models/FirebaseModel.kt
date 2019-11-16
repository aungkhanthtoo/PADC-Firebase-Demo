package com.padc.padcfirebase.data.models

import androidx.lifecycle.LiveData
import com.padc.padcfirebase.data.vos.ArticleVO
import java.util.*

interface FirebaseModel {

    fun getAllArticles(cleared: LiveData<Unit>): LiveData<List<ArticleVO>>

    fun getArticleById(id: String, cleared: LiveData<Unit>): LiveData<ArticleVO>
}