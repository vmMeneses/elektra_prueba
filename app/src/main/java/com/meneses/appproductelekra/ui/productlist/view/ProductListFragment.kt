package com.meneses.appproductelekra.ui.productlist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.meneses.appelektra.data.response.Producto
import com.meneses.appproductelekra.databinding.FragmentProductListBinding
import com.meneses.appproductelekra.ui.productlist.adapter.AdapterProduct
import com.meneses.appproductelekra.ui.productlist.adapter.OnClickProductListene
import com.meneses.appproductelekra.ui.productlist.viewmodel.ListProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListFragment : Fragment(), OnClickProductListene {
    private var _binding: FragmentProductListBinding? = null
    private val binding get() = _binding!!
    private val productViewModel: ListProductViewModel by viewModels()
    private lateinit var productAdapter: AdapterProduct

    private val args: ProductListFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductListBinding.inflate(layoutInflater, container, false)
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
        productViewModel.getProducts()
        initRecyclerview()
    }

    private fun initObserver() {
        productViewModel.isLoading.observe(viewLifecycleOwner) { isVisible ->
            binding.progressbaProducts.visibility = if (isVisible) View.VISIBLE else View.GONE
        }
        productViewModel.listProduct.observe(viewLifecycleOwner) {
            productAdapter.updateListProducts(it)
        }
        productViewModel.msg.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
        }
    }

    private fun initRecyclerview() {
        productAdapter = AdapterProduct(listener = this)
        binding.RecyclerviewProducts.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = productAdapter
            setHasFixedSize(true)
        }
    }

    override fun OnCLickProduct(product: Producto) {
        Toast.makeText(
            requireContext(),
            "Producto seleccionado ${product.nombre}",
            Toast.LENGTH_LONG
        ).show()
        //binding.BUttonReturnHome.setOnClickListener {
        findNavController().navigate(
            ProductListFragmentDirections.actionProductListFragmentToHomeFragment(
                nameproduct = product.nombre,
                imageproduct = product.urlImagenes[0],
                categoryproduct = "",
                priceproduct = product.precioRegular.toFloat()
            )
        )
        //}
    }
}