

package com.redline.android.myapplication.main

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.redline.android.myapplication.main.MainViewModel
import com.redline.android.myapplication.main.MainAdapter
import com.redline.android.myapplication.R
import com.redline.android.myapplication.databinding.FragmentMainBinding


class MainFragment : Fragment() {


    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = FragmentMainBinding.inflate(inflater)


        binding.lifecycleOwner = this


      binding.viewModel2 = viewModel


        binding.photosGrid2.adapter = MainAdapter(MainAdapter.OnClickListener {
            viewModel.displayPropertyDetails(it)
        })


        viewModel.navigateToSelectedProperty.observe(this, Observer {
            if ( null != it ) {

            this.findNavController().navigate(MainFragmentDirections.actionMainFragmentToOverviewFragment(it))

                viewModel.displayPropertyDetailsComplete()
            }
        })

        setHasOptionsMenu(true)
        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.overflow_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
}
