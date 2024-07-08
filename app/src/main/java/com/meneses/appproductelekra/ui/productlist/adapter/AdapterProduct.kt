package com.meneses.appproductelekra.ui.productlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.meneses.appelektra.data.response.Producto
import com.meneses.appproductelekra.R

class AdapterProduct(
    private var productList: List<Producto> = emptyList(),
    private val listener: OnClickProductListene
) :
    RecyclerView.Adapter<ProductViewHolder>() {
    override fun getItemCount(): Int = productList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_product, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.render(productList[position],listener)
    }

    fun updateListProducts(listProducts : List<Producto>){
        productList = listProducts
        notifyDataSetChanged()
    }


}