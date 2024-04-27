/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.template.core.data.di

import android.content.Context
import android.template.core.data.MyModelRepository
import android.template.core.data.DefaultMyModelRepository
import android.template.core.database.AppDatabase
import android.template.core.database.di.DatabaseModule

object DataModule {

    private var myModelRepository: MyModelRepository? = null
    private val dataBaseModule = DatabaseModule()
    private lateinit var dataBase:AppDatabase

    fun setup(context:Context) {
        dataBase = dataBaseModule.provideAppDatabase(context)
    }

    private fun createMyModelRepository(): MyModelRepository {
        val repository = DefaultMyModelRepository(provideDao())
        myModelRepository = repository
        return repository
    }

    private fun provideDao() = dataBaseModule.provideMyModelDao(dataBase)

    fun providerRepository() = myModelRepository ?: createMyModelRepository()

    fun destroy() {
        myModelRepository = null
    }
}
