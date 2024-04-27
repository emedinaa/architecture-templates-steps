package android.template.core.data.di

import android.template.core.data.MyModelRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeMyModelRepository : MyModelRepository{

    private  val fakeMyModels = listOf("One", "Two", "Three")
    override val myModels: Flow<List<String>> = flowOf(fakeMyModels)

    override suspend fun add(name: String) {
        throw NotImplementedError()
    }
}