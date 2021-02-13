package shevtsov.daniil.asciiart.learning.view

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import shevtsov.daniil.asciiart.R
import shevtsov.daniil.asciiart.core.AsciiArtApplication
import shevtsov.daniil.asciiart.core.util.viewLifecycleLazy
import shevtsov.daniil.asciiart.databinding.FragmentLearningBinding
import shevtsov.daniil.asciiart.databinding.FragmentLearningBinding.bind
import shevtsov.daniil.asciiart.learning.presentation.LearningScreenEvent
import shevtsov.daniil.asciiart.learning.presentation.LearningViewModel
import shevtsov.daniil.asciiart.learning.presentation.LearningViewState
import javax.inject.Inject

class LearningFragment : Fragment(R.layout.fragment_learning) {

    private val binding by viewLifecycleLazy { bind(requireView()) }

    private val args: LearningFragmentArgs by navArgs()

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: LearningViewModel by viewModels { viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (context.applicationContext as AsciiArtApplication)
            .getAppComponent()
            .inject(this)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.initViews()

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.state.collect { state -> renderState(state = state) }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.events.collect { event -> handleEvent(event = event) }
        }

        viewModel.onArguments(arguments = args.initArguments)
    }

    private fun renderState(state: LearningViewState) {
        with(binding) {
            learningItemNameTextView.text = state.itemName
            learningItemContentTextView.text = state.itemContent
        }
    }

    private fun handleEvent(event: LearningScreenEvent) {

    }

    private fun FragmentLearningBinding.initViews() {

    }

}