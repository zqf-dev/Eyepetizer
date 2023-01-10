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

package com.eyepetizer.android.logic.dao

/**
 * 应用程序所有Dao操作管理类。
 *
 * @author vipyinzhiwei
 * @since  2020/5/2
 */
object EyepetizerDatabase {

    private lateinit var mainPageDao: MainPageDao

    private lateinit var videoDao: VideoDao

    fun getMainPageDao() = if (this::mainPageDao.isInitialized) mainPageDao else MainPageDao()

    fun getVideoDao() = if (this::videoDao.isInitialized) videoDao else VideoDao()
}