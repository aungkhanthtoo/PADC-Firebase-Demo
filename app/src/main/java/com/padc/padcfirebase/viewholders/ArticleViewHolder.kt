package com.padc.padcfirebase.viewholders

import android.view.View
import com.padc.padcfirebase.delegates.ArticleItemDelegate

class ArticleViewHolder(itemView: View, delegate: ArticleItemDelegate): BaseViewHolder<Any>(itemView) {

    init {
        itemView.setOnClickListener {
            data?.let { delegate.onArticleItemClicked(it) }
                ?: delegate.onArticleItemClicked(Any())
        }
    }

    override fun bindData(data: Any) {

    }
}