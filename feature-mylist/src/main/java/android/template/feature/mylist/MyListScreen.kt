package android.template.feature.mylist

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun MyListScreen(modifier: Modifier = Modifier, viewModel: MyListViewModel) {
    val items by viewModel.uiState.collectAsStateWithLifecycle()
    if (items is MyModelUiState.Success) {
        val data = (items as MyModelUiState.Success).data
        Column(modifier) {
            data.forEach {
                Text("Saved item: $it")
            }
        }
    }
}