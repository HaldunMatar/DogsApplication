

package com.redline.android.myapplication.overview

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.redline.android.myapplication.overview.OverviewViewModel
import com.redline.android.myapplication.overview.DataAdapter
import com.redline.android.myapplication.R
import com.redline.android.myapplication.databinding.FragmentDetailBinding
import com.redline.android.myapplication.databinding.FragmentOverviewBinding
import com.redline.android.myapplication.detail.DetailFragmentArgs


class OverviewFragment : Fragment() {


    private val viewModel: OverviewViewModel by lazy {
        ViewModelProvider(this).get(OverviewViewModel::class.java)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = FragmentOverviewBinding.inflate(inflater)


        val application = requireNotNull(activity).application


        val subtype = OverviewFragmentArgs.fromBundle(arguments!!)


        binding.lifecycleOwner = this
        viewModel.subtype=subtype.subtype

      binding.viewModel = viewModel


        binding.photosGrid.adapter = DataAdapter(DataAdapter.OnClickListener {
            viewModel.displayPropertyDetails(it)
        })


        viewModel.navigateToSelectedProperty.observe(this, Observer {
            if ( null != it ) {

             this.findNavController().navigate(OverviewFragmentDirections.actionOverviewFragmentToDetailFragment(it))

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
