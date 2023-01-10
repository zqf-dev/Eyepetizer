/*
 * Copyright (c) 2020. vipyinzhiwei <vipyinzhiwei@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.eyepetizer.android.ui.home.daily

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.eyepetizer.android.logic.model.Daily
import com.eyepetizer.android.logic.network.api.MainPageService

class DailyPagingSource(private val mainPageService: MainPageService) : PagingSource<String, Daily.Item>() {

    override suspend fun load(params: LoadParams<String>): LoadResult<String, Daily.Item> {
        return try {
            val page = params.key ?: MainPageService.DAILY_URL
            val repoResponse = mainPageService.getDaily(page)
            val repoItems = repoResponse.itemList
            val prevKey = null
            val nextKey = if (repoItems.isNotEmpty() && !repoResponse.nextPageUrl.isNullOrEmpty()) repoResponse.nextPageUrl else null
            LoadResult.Page(repoItems, prevKey, nextKey)
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<String, Daily.Item>): String? = null
}