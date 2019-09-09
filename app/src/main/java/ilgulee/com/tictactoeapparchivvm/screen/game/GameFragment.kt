package ilgulee.com.tictactoeapparchivvm.screen.game


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableRow
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment.findNavController
import ilgulee.com.tictactoeapparchivvm.R
import ilgulee.com.tictactoeapparchivvm.databinding.GameFragmentBinding

/**
 * A simple [Fragment] subclass.
 *
 */
class GameFragment : Fragment() {
    private lateinit var viewModel: GameViewModel
    private lateinit var binding: GameFragmentBinding
    private lateinit var boards: Array<CharArray>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<GameFragmentBinding>(
            inflater,
            R.layout.game_fragment, container, false
        )
        Log.i("GameFragment", "Called ViewModelProviders.of()")
        viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)
        boards = viewModel.gameBoard

//        binding.giveupGameButton.setOnClickListener {
//            findNavController().navigate(GameFragmentDirections.actionGameFragmentToScoreFragment())
//        }

        setGameBoardUI()
        return binding.root
    }

    private fun setGameBoardUI() {
        for (row in 0 until boards.size) {
            for (column in 0 until boards[row].size) {
                val textView = (binding.tableLayout.getChildAt(row) as TableRow)
                    .getChildAt(column) as TextView
                if (boards[row][column] == ' ') {
                    textView.setOnClickListener {
//                        Toast.makeText(this.context, "clicked cell of row${row} column${column}", Toast.LENGTH_SHORT).show()
                        onClicked(row, column)
                    }
                }
                textView.text = viewModel.gameBoard[row][column].toString()
            }
        }
    }

    private fun onClicked(row: Int, column: Int) {
        if(boards[row][column]==' '){
            ((binding.tableLayout.getChildAt(row) as TableRow)
                .getChildAt(column) as TextView).text=viewModel.turn.toString()
            viewModel.fillGameBoardCellData(row, column)
            if(viewModel.isWinner()){
                Log.i("checkGameStatus","Winner is ${viewModel.turn}")
                gameFinished("Winner is ${viewModel.turn}")
            }
            if(viewModel.isBoardFull()){
                Log.i("checkGameStatus","Draw!")
                gameFinished("Draw")
            }
            viewModel.changeTurn()
        }
    }

    private fun gameFinished(result:String){
        findNavController(this).navigate(GameFragmentDirections.actionGameFragmentToScoreFragment(result))
    }
}
