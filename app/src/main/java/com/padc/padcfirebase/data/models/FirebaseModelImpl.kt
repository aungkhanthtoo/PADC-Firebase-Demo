package com.padc.padcfirebase.data.models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.padc.padcfirebase.data.vos.ArticleVO
import com.padc.padcfirebase.utils.REF_PATH_ARTICLES

object FirebaseModelImpl: FirebaseModel {

    const val TAG = "FirebaseModel"

    private val databaseRef = FirebaseDatabase.getInstance().reference

    override fun getAllArticles(): LiveData<List<ArticleVO>> {
        val liveData = MutableLiveData<List<ArticleVO>>()

        val articlesRef = databaseRef.child(REF_PATH_ARTICLES)
        // Read from the database
        articlesRef.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Log.d(TAG, "Key is: ${dataSnapshot.key}")

                val articles = ArrayList<ArticleVO>()

                for (articleData in dataSnapshot.children){
                    val article = articleData.getValue(ArticleVO::class.java)
                    article?.let{
                        articles.add(article)
                    }
                }

                Log.d(TAG, "Value is: $articles")

                liveData.value = articles
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })

        return liveData
    }

    override fun getArticleById(id: String): LiveData<ArticleVO> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}