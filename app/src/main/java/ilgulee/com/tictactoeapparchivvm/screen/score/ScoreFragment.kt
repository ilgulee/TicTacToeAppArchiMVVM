package ilgulee.com.tictactoeapparchivvm.screen.score


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import ilgulee.com.tictactoeapparchivvm.R
import ilgulee.com.tictactoeapparchivvm.databinding.ScoreFragmentBinding

/**
 * A simple [Fragment] subclass.
 *
 */
class ScoreFragment : Fragment() {
    private lateinit var viewModel: ScoreViewModel
    private lateinit var viewModelFactory: ScoreViewModelFactory
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding=DataBindingUtil.inflate<ScoreFragmentBinding>(inflater,
            R.layout.score_fragment, container, false)
//        binding.playAgainButton.setOnClickListener {
//            findNavController().navigate(ScoreFragmentDirections.actionScoreFragmentToTitleFragment())
//        }
        viewModelFactory= ScoreViewModelFactory(ScoreFragmentArgs.fromBundle(arguments!!).result)
        viewModel=ViewModelProviders.of(this,viewModelFactory).get(ScoreViewModel::class.java)
        binding.youScoredText.text=viewModel.result
        return binding.root
    }
}
