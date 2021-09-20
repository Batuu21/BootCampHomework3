package com.example.homework3

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val bottomNavigationView: BottomNavigationView = requireActivity().findViewById(R.id.bottomnavigationview)
        bottomNavigationView.visible()

        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onResume() {
        super.onResume()

        val activity = activity as MainActivity

        activity.onBackPressedDispatcher.addCallback(viewLifecycleOwner, object :
            OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                AlertDialog.Builder(requireContext())
                    .setTitle("Çıkış")
                    .setMessage("Çıkmak istediğinize emin misiniz?")
                    .setCancelable(false)
                    .setNegativeButton("Evet") { _, _ ->
                        activity.finish()
                    }
                    .setPositiveButton("Hayır") { dialog, _ ->
                        dialog.dismiss()
                    }
                    .show()
            }
        })

    }



}