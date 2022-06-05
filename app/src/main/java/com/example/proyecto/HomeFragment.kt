package com.example.proyecto

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.android.volley.RequestQueue
import com.example.proyecto.databinding.FragmentHomeBinding
import com.google.firebase.database.ktx.*
import com.google.firebase.ktx.Firebase
import org.json.JSONArray

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)


        val database = Firebase.database
        val myRef = database.reference

        myRef.child("Usuarios").child("1").setValue(User("004", "AloZM09", "13/08/2020", "240 pts", "0"))
        myRef.child("Usuarios").child("2").setValue(User("012", "Orly67", "26/01/2021", "135 pts", "0"))
        myRef.child("Usuarios").child("3").setValue(User("024", "Emilio21", "06/12/2020", "75 pts", "0"))

        myRef.child("Usuarios").child("1").get().addOnSuccessListener { response->
            Log.d("firebaseResponse", response.value.toString())
            var user1: String = response.value.toString()

            binding.users.setText("$user1")
        }.addOnFailureListener{
            Log.e("firebaseResponse", "Error getting data", it)
        }

        myRef.child("Usuarios").child("2").get().addOnSuccessListener { response->
            Log.d("firebaseResponse", response.value.toString())
            var user2: String = response.value.toString()

            binding.users2.setText("$user2")
        }.addOnFailureListener{
            Log.e("firebaseResponse", "Error getting data", it)
        }

        myRef.child("Usuarios").child("3").get().addOnSuccessListener { response->
            Log.d("firebaseResponse", response.value.toString())
            var user3: String = response.value.toString()

            binding.users3.setText("$user3")
        }.addOnFailureListener{
            Log.e("firebaseResponse", "Error getting data", it)
        }



    /*    val navController = findNavController()
        binding.buttonToSearch.setOnClickListener {
            //Toast.makeText(context, "prueba", Toast.LENGTH_LONG).show()
            navController.navigate(R.id.action_homeFragment_to_searchFragment)
       }
    */

        return binding.root
    }
}