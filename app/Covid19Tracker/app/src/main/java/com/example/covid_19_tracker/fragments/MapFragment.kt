package com.example.covid_19_tracker.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.covid_19_tracker.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.Circle
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapFragment : Fragment() {

	private val callback = OnMapReadyCallback { googleMap ->
						   
		val sydney = LatLng(-34.0, 151.0)
		val usa = LatLng(40.0,-100.0)
		val eu = LatLng(50.0,30.0)
		val africa = LatLng(10.0,20.0)
		val china = LatLng(30.0,-260.0)

		googleMap.addMarker(MarkerOptions().position(sydney).title("27,965"))
		googleMap.addMarker(MarkerOptions().position(usa).title("14,534,035"))
		googleMap.addMarker(MarkerOptions().position(eu).title("13,972,781"))
		googleMap.addMarker(MarkerOptions().position(africa).title("2,275,213"))
		googleMap.addMarker(MarkerOptions().position(china).title("4,023,872")) // change
		val circleOpAU : CircleOptions = CircleOptions().center(sydney).radius(279650000.0).fillColor(0x550000FF)
		val circleOpUSA : CircleOptions = CircleOptions().center(usa).radius(1500000.0).fillColor(0x550000FF)
		val circleOpEU : CircleOptions = CircleOptions().center(eu).radius(1300000.0).fillColor(0x550000FF)
		val circleOpAF : CircleOptions = CircleOptions().center(africa).radius(1000000.0).fillColor(0x550000FF)
		val circleOpCH : CircleOptions = CircleOptions().center(china).radius(1100000.0).fillColor(0x550000FF)
		val circleCH = googleMap.addCircle(circleOpCH)
		val circleAU = googleMap.addCircle(circleOpAU)
		val circleUSA = googleMap.addCircle(circleOpUSA)
		val circleEU = googleMap.addCircle(circleOpEU)
		val circleAF = googleMap.addCircle(circleOpAF)

		googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
	}

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? = inflater.inflate(R.layout.fragment_map, container, false)

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
		mapFragment?.getMapAsync(callback)
	}

}
