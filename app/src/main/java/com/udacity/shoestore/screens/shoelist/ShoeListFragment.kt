package com.udacity.shoestore.screens.shoelist

import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeItemWithinListBinding
import com.udacity.shoestore.databinding.ShoeListFragmentBinding

class ShoeListFragment : Fragment() {

    private lateinit var viewModel: ShoeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: ShoeListFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.shoe_list_fragment, container, false)

        setHasOptionsMenu(true)

        viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)
        val shoeListLayout = binding.shoeListLinearLayout

        viewModel.shoeList.value?.forEach { shoe ->
            val shoeItemWithinListBinding: ShoeItemWithinListBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.shoe_item_within_list,
                shoeListLayout,
                true
            )

            shoeItemWithinListBinding.shoeNameText.text = shoe.name
            shoeItemWithinListBinding.shoeDescriptionText.text = shoe.description
            shoeItemWithinListBinding.shoeSizeText.text = shoe.size.toString()
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}