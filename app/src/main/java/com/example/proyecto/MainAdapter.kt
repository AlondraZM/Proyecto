package com.example.proyecto

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto.database.Product
import com.example.proyecto.databinding.ItemUserBinding
import org.json.JSONObject

class MainAdapter(private val productos: Array<Product>): RecyclerView.Adapter<MainAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MainHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainAdapter.MainHolder, position: Int) {
        holder.render(productos[position])
    }

    override fun getItemCount(): Int {
        return productos.size
    }

    class MainHolder(val binding: ItemUserBinding): RecyclerView.ViewHolder(binding.root){
        fun render(product: Product){
            binding.tvUser.setText("ID: "+ product.ID+"\nNombre: "+product.Nombre+"\nDescripcion: "+product.Descripcion+"\nPrecio: $"+product.Precio+"\nCalificaion: "+product.Calificacion)
        }

    }
}