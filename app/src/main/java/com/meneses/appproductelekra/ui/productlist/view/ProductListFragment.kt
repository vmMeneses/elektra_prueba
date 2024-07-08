package com.meneses.appproductelekra.ui.productlist.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.meneses.appproductelekra.ProductListFragmentArgs
import com.meneses.appproductelekra.ProductListFragmentDirections
import com.meneses.appproductelekra.databinding.FragmentProductListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListFragment : Fragment() {
    private  var _binding: FragmentProductListBinding? = null
    private val binding get() = _binding!!

    private val args: ProductListFragmentArgs by  navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentProductListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
    }

    private fun initUI() {
        Toast.makeText(requireContext(), "${args.prueba}", Toast.LENGTH_LONG).show()
        initObserver()
        initUIState()
    }

    private fun initUIState() {
       binding.BUttonReturnHome.setOnClickListener {
           findNavController().navigate(
               ProductListFragmentDirections.actionProductListFragmentToHomeFragment(
                   nameproduct = "Hola",
                   imageproduct = "agagagagagakakajs",
                   categoryproduct = "Todos",
                   priceproduct = 15.2F
               )
           )
       }


    }

    private fun initObserver() {

    }
}