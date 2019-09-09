package ilgulee.com.tictactoeapparchivvm.screen.score

import android.util.Log
import androidx.lifecycle.ViewModel

class ScoreViewModel(val result: String) : ViewModel() {
    init {
        Log.i("ScoreViewModel", "result is ${result}")
    }
}