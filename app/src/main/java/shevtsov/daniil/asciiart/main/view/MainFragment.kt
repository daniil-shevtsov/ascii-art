package shevtsov.daniil.asciiart.main.view

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import shevtsov.daniil.asciiart.R
import shevtsov.daniil.asciiart.core.AsciiArtApplication
import shevtsov.daniil.asciiart.core.util.viewLifecycleLazy
import shevtsov.daniil.asciiart.databinding.FragmentMainBinding
import shevtsov.daniil.asciiart.databinding.FragmentMainBinding.bind
import shevtsov.daniil.asciiart.learning.navigation.LearningInitArguments
import shevtsov.daniil.asciiart.main.presentation.MainScreenEvent
import shevtsov.daniil.asciiart.main.presentation.MainViewModel
import javax.inject.Inject

class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding by viewLifecycleLazy { bind(requireView()) }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: MainViewModel by viewModels { viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (context.applicationContext as AsciiArtApplication)
            .getAppComponent()
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.initViews()

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.events.collect { event -> handleEvent(event) }
        }

    }

    private fun FragmentMainBinding.initViews() {
        openCreationButton.setOnClickListener { viewModel.onOpenCreation() }
        openLearningButton.setOnClickListener { viewModel.onOpenLearning() }
        openStructureButton.setOnClickListener { viewModel.onOpenStructure() }
    }

    private fun handleEvent(event: MainScreenEvent) {
        when (event) {
            is MainScreenEvent.OpenCreation -> openCreation()
            is MainScreenEvent.OpenLearning -> openLearning()
            is MainScreenEvent.OpenStructure -> openStructure()
        }
    }

    private fun openCreation() {
        val direction = MainFragmentDirections.mainToCreation()
        findNavController().navigate(direction)
    }

    private fun openLearning() {
        val arguments = LearningInitArguments.Empty
        val direction = MainFragmentDirections.mainToLearning(initArguments = arguments)
        findNavController().navigate(direction)
    }

    private fun openStructure() {
        val direction = MainFragmentDirections.mainToStructure()
        findNavController().navigate(direction)
    }

}
