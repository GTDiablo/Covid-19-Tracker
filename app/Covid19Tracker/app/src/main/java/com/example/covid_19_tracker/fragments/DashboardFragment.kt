package com.example.covid_19_tracker.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import com.example.covid_19_tracker.R
import java.util.Timer
import java.util.TimerTask

class DashboardFragment : Fragment() {

	private var timer = Timer()
	private val delay : Long = 500

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {

		val rootView = inflater.inflate(R.layout.fragment_dashboard, container, false)
		initSearchBar(rootView)
		return rootView
	}

	private fun timerSchedule(timer: Timer, executeUnit: () -> Unit) {
		timer.schedule(object : TimerTask() {
			override fun run() {
				requireActivity().runOnUiThread {
					executeUnit()
				}
			}
		}, delay)
	}

	private fun initSearchBar(view: View) {

		val searchBar = view.findViewById<EditText>(R.id.searchBar)
		searchBar!!.addTextChangedListener(object : TextWatcher {
			override fun afterTextChanged(s: Editable?) {
					timer.cancel()
					timer = Timer()
					timerSchedule(timer) { Toast.makeText(requireActivity().applicationContext, searchBar.text,Toast.LENGTH_LONG).show()}
			}

			override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {/*no-op*/
			}

			override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {/*no-op*/
			}
		}
		)
	}
}
