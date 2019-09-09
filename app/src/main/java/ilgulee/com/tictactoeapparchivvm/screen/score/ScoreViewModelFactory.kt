package ilgulee.com.tictactoeapparchivvm.screen.score

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class ScoreViewModelFactory(private val result: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScoreViewModel::class.java)) {
            return ScoreViewModel(result) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}