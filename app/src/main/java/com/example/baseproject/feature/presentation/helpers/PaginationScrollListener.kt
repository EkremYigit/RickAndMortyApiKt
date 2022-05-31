package com.example.baseproject.feature.presentation.helpers

import android.widget.AbsListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class PaginationScrollListener(private val paginationOperation: PaginationOperation):RecyclerView.OnScrollListener() {
    private var isLoading = false
    var isLastPage = false
    private var isScrolling = false
    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val layoutManager = recyclerView.layoutManager as LinearLayoutManager
        val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
        val visibleItemCount = layoutManager.childCount
        val totalItemCount = layoutManager.itemCount

        val isNotLoadingAndNotLastPage = !isLoading && !isLastPage
        val isAtHalfItem = firstVisibleItemPosition + visibleItemCount >= totalItemCount / 2
        val isNotAtBeginning = firstVisibleItemPosition >= 0
        val isTotalMoreThanVisible = totalItemCount >= QUERY_PAGE_SIZE
        val shouldPaginate = isNotLoadingAndNotLastPage && isAtHalfItem && isNotAtBeginning &&
                isTotalMoreThanVisible && isScrolling
        if(shouldPaginate) {
            paginationOperation.getNewData()
            isScrolling = false
        }
    }

    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        super.onScrollStateChanged(recyclerView, newState)
        if(newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
            isScrolling = true
        }
    }
    companion object {
        var CURRENT_PAGE = 1
        const val QUERY_PAGE_SIZE = 20
        const val TOTAL_PAGE = 42
    }
}
interface PaginationOperation {
    fun getNewData()
}