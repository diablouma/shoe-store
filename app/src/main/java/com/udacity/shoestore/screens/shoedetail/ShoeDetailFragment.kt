package com.udacity.shoestore.screens.shoedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.content.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeDetailFragmentBinding
import com.udacity.shoestore.ShoeListViewModel

class ShoeDetailFragment : Fragment() {
    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: ShoeDetailFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.shoe_detail_fragment, container, false)

        binding.shoeListViewModel = viewModel

        binding.cancelButton.setOnClickListener {
            findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }

        viewModel.shoeSaved.observe(this, Observer { saved ->
            if (saved) {
                hideKeyboard()
                findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
                viewModel.addShoe(viewModel.newShoe.value!!)
                viewModel.onSaveShoeEventComplete()
            }
        })

        return binding.root
    }

    private fun hideKeyboard() {
        val keyboard = activity?.getSystemService<InputMethodManager>()
        view?.let { keyboard?.hideSoftInputFromWindow(view?.windowToken, 0) }
    }
}