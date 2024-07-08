package com.meneses.appproductelekra.ui.productlist.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.meneses.appelektra.data.response.Producto
import com.meneses.appproductelekra.databinding.ItemProductBinding

class ProductViewHolder (view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemProductBinding.bind(view)

    fun render(product: Producto, listener: OnClickProductListene){
        binding.TextViewName.text = product.nombre
        binding.TextViewPrice.text = "$ ${product.precioRegular}"
        product.urlImagenes[0].let {
            Glide.with(binding.root)
                .load(it)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(binding.ImageViewProduct)
        }

        binding.root.setOnClickListener {
            listener.OnCLickProduct(product)
        }

    }
}