package com.example.rickandmorty_.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.rickandmorty_.R
import com.example.rickandmorty_.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBottomNavigation()
        changeTitleToolbar()
    }

    private fun initBottomNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        setupWithNavController(binding.bottomNavigation, navController)
    }

    private fun changeTitleToolbar() {
        val appBarConfiguration = AppBarConfiguration.Builder(
            R.id.characterFragment,
            R.id.locationFragment,
            R.id.episodesFragment
        ).build()
        setupWithNavController(binding.bottomNavigation, navController)
        NavigationUI.setupWithNavController(binding.toolbarMain, navController, appBarConfiguration)
    }
}