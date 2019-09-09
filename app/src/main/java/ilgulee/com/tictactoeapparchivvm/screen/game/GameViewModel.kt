package ilgulee.com.tictactoeapparchivvm.screen.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    var turn: Char = ' '
    var gameBoard: Array<CharArray> = Array(3) { CharArray(3) { ' ' } }

    init {
        turn = 'X'
        Log.i("GameViewModel", "GameViewModel created!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destroyed!")
    }

    fun changeTurn() = if (turn == 'X') turn = 'O' else turn = 'X'

    fun fillGameBoardCellData(row: Int, column: Int) {
        if (gameBoard[row][column] == ' ') {
            gameBoard[row][column] = turn
        }
    }

    fun isBoardFull(): Boolean {
        for (row in 0 until gameBoard.size) {
            for (column in 0 until gameBoard[row].size) {
                if (gameBoard[row][column] == ' ') {
                    return false
                }
            }
        }
        return true
    }

    fun isWinner(): Boolean {
        for (i in 0 until gameBoard.size) {
            if (gameBoard[i][0] == turn && gameBoard[i][1] == turn && gameBoard[i][2] == turn) {
                return true
            }
            if (gameBoard[0][i] == turn && gameBoard[1][i] == turn && gameBoard[2][i] == turn) {
                return true
            }
        }
        if ((gameBoard[0][0] == turn && gameBoard[1][1] == turn && gameBoard[2][2] == turn) ||
            (gameBoard[0][2] == turn && gameBoard[1][1] == turn && gameBoard[2][0] == turn)
        ) {
            return true
        }
        return false
    }
}