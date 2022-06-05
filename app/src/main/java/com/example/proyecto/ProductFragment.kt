package com.example.proyecto

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.example.proyecto.database.Product
import com.example.proyecto.databinding.FragmentListBinding
import com.example.proyecto.databinding.FragmentProductBinding
import org.json.JSONObject


class ProductFragment : Fragment() {

    private lateinit var binding: FragmentProductBinding
    private lateinit var queue: RequestQueue

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentProductBinding.inflate(layoutInflater)
        queue = Volley.newRequestQueue(requireActivity())

        /*mainViewModel.saveProduct(Product(
            "2", "Mens Casual Premium Slim Fit T-Shirts", "Slim-fitting style, three-button henley placket, light weight & soft fabric for breathable and comfortable wearing", "22.3", "4.1"
        ))
        mainViewModel.saveProduct(Product(
            "1", "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops", "Your perfect pack for everyday use and walks in the forest", "109.95", "3.9"
        ))

        mainViewModel.saveProduct(Product(
            "13", "Acer SB220Q bi 21.5 inches Full HD (1920 x 1080) IPS Ultra-Thin", "1. 5 inches Full HD (1920 x 1080) widescreen IPS display And Radeon free Sync technology", "599", "2.9"
        ))
        mainViewModel.saveProduct(Product(
            "7", "White Gold Plated Princess", "Classic Created Wedding Engagement Solitaire Diamond Promise Ring for Her", "9.99", "3"
        ))*/


        mainViewModel.getProducts()
        mainViewModel.savedProducts.observe(requireActivity(), {productsList ->

            if(!productsList.isNullOrEmpty()){
                var productos: Array<Product> = productsList.toTypedArray()
                binding.rvUser.adapter = MainAdapter(productos)

                for (product in productsList){
                    Log.d("thesearetheusers", "ID: "+ product.ID+"\nNombre: "+product.Nombre+"\nDescripcion: "+product.Descripcion+"\nPrecio: $"+product.Precio+"\nCalificaion: "+product.Calificacion)
                }
            }else{
                Log.d("thesearetheusers", "null or empty")
            }
        })


        fun onStop() {
            super.onStop()
            queue.cancelAll("Stopped")
        }


        return binding.root
    }






}