package com.meneses.appproductelekra.ui.home.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.meneses.appproductelekra.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val args: HomeFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getArgs()
        initUI()
    }

    private fun getArgs() {
        val nameProduct = args.nameproduct
        val imageProduct = args.imageproduct
        val priceProduct = args.priceproduct
        val categoryProduct = args.categoryproduct

        Log.e("arguments", "productName = $nameProduct")
        Log.e("arguments", "imageName = $imageProduct")
        Log.e("arguments", "PriceName = $priceProduct")
        Log.e("arguments", "Category = $categoryProduct")
        initViewProduct(nameProduct,imageProduct,priceProduct,categoryProduct)
    }

    private fun initViewProduct(nameProduct: String, imageProduct: String, priceProduct: Float, categoryProduct: String) {
        if(nameProduct != "sin_nombre"){
            binding.CardDetailProduct.visibility = View.VISIBLE
            binding.TextViewName.text = nameProduct
            binding.TextViewPrice.text = "$ ${priceProduct} "
            Glide.with(binding.root)
                .load(imageProduct)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(binding.ImageViewProduct)
        }else{
            binding.CardDetailProduct.visibility = View.GONE
        }

    }

    private fun initUI() {
        initObserver()
        initUIState()
    }

    private fun initUIState() {
        binding.BUttonListarProducts.setOnClickListener {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToProductListFragment(
                    prueba = "Segunda Vista"
                )
            )
        }
    }

    private fun initObserver() {

    }


}