package com.example.covid_19_tracker

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.fragment.app.Fragment
import com.example.covid_19_tracker.fragments.DashboardFragment
import com.example.covid_19_tracker.fragments.MapFragment
import com.example.covid_19_tracker.fragments.TestFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		setNavBarOnClickListener()
	}

	override fun onCreateView(parent: View?, name: String, context: Context, attrs: AttributeSet): View? {
		supportFragmentManager.beginTransaction().replace(R.id.fragment_container,DashboardFragment()).commit()
		return super.onCreateView(parent, name, context, attrs)
	}

	fun setNavBarOnClickListener(){
		val bottomNavbar : BottomNavigationView = findViewById(R.id.menu)
		var currentFragment = Fragment()
		bottomNavbar.setOnNavigationItemSelectedListener { item ->
			when (item.itemId) {
				R.id.nav_dashboard -> {
					currentFragment = DashboardFragment()
				}
				R.id.nav_map -> {
					currentFragment = MapFragment()
				}
				R.id.nav_test -> {
					currentFragment = TestFragment()
				}
			}
			supportFragmentManager.beginTransaction().replace(R.id.fragment_container,currentFragment).commit()
			true
		}
	}


}