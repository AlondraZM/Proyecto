package com.example.proyecto

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.proyecto.database.Product
import com.example.proyecto.databinding.ActivityMainBinding
import com.example.proyecto.databinding.FragmentHomeBinding
import com.example.proyecto.databinding.FragmentListBinding
import org.json.JSONObject


class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private lateinit var queue: RequestQueue

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListBinding.inflate(layoutInflater)
        queue = Volley.newRequestQueue(requireActivity())

        for(num in 1..5){
            val ran = (1..20).random()
            getProduct(ran, num)
        }


        return binding.root
    }


    fun getProduct(ran: Int, num: Int){
        val url = "https://fakestoreapi.com/products/$ran"

        val jsonRequest = JsonObjectRequest(url, Response.Listener<JSONObject>{ response ->
            Log.i("prueba", response.toString())
            var pro: String = response.toString()

            if(num == 1){
                binding.sur1.setText("$pro")}
            if(num == 2){
                binding.sur2.setText("$pro")}
            if(num == 3){
                binding.sur3.setText("$pro")}
            if(num == 4){
                binding.sur4.setText("$pro")}
            if(num == 5){
                binding.sur5.setText("$pro")}

        },
            Response.ErrorListener { error ->
                Log.w("prueba", error.message as String)
            })

        queue.add(jsonRequest)

    }

    override fun onStop() {
        super.onStop()
        queue.cancelAll("Stopped")
    }

}