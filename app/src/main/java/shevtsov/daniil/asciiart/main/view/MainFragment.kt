package shevtsov.daniil.asciiart.main.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import shevtsov.daniil.asciiart.R
import shevtsov.daniil.asciiart.core.util.viewLifecycleLazy
import shevtsov.daniil.asciiart.databinding.FragmentMainBinding
import shevtsov.daniil.asciiart.databinding.FragmentMainBinding.bind

class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding by viewLifecycleLazy { bind(requireView()) }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.initViews()
    }

    private fun FragmentMainBinding.initViews() {
    }


}
