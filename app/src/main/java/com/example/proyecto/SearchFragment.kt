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
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.proyecto.database.Product
import com.example.proyecto.databinding.FragmentProductBinding
import com.example.proyecto.databinding.FragmentSearchBinding
import org.json.JSONObject


class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var queue: RequestQueue

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSearchBinding.inflate(layoutInflater)
        queue = Volley.newRequestQueue(requireActivity())

        binding.btnUpdate.setOnClickListener {
            var num = binding.etSearch.text

            if(num.isEmpty()){
                Toast.makeText(requireActivity(),"Id invalido", Toast.LENGTH_LONG).show()
            }else{
                val url = "https://fakestoreapi.com/products/$num"

                val jsonRequest = JsonObjectRequest(url, Response.Listener<JSONObject>{ response ->
                    Log.i("prueba2", response.toString())
                    var pro: String = response.toString()
                        binding.result.setText("$pro")
                },
                    Response.ErrorListener { error ->
                        Log.w("prueba2", error.message as String)
                    })

                queue.add(jsonRequest)

            }
        }

        return binding.root
    }

}