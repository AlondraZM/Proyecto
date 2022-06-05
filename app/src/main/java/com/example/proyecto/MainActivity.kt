package com.example.proyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.proyecto.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = Firebase.database
        val myRef = database.reference

        myRef.child("Usuarios").child("1").setValue(User("001",  "ALoZM", "03/05/2021","130 pts", "0"))
        myRef.child("Usuarios").child("2").setValue(User("002",  "Orly32", "12/01/2020", "250 pts", "0"))
        myRef.child("Usuarios").child("3").setValue(User("003",  "Emilio34", "28/07/2021", "45 pts", "0"))

       /* myRef.child("Usuarios").get().addOnSuccessListener { response->
            Log.d("firebaseResponse", response.value.toString())
        }.addOnFailureListener{
            Log.e("firebaseResponse", "Error getting data", it)
        }*/

        //MENU
        val navView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        navView.setupWithNavController(navController)
/*
        myRef.child("Ejemplo").child("1").setValue(Card("1", "rojo", "corazones"))
        myRef.child("Ejemplo").child("1").setValue(Card("2", "rojo", "corazones"))
        myRef.child("Ejemplo").child("1").setValue(Card("3", "rojo", "corazones"))

        myRef.child("Usuarios").child("1").setValue(User("001", "Alondra", "22"))
        myRef.child("Usuarios").child("2").setValue(User("002", "Orlando", "10"))
        myRef.child("Usuarios").child("3").setValue(User("003", "Emilio", "15"))
        myRef.child("Usuarios").child("4").setValue(User("004", "Antonio", "43"))
    */


    }
}