package com.example.fragmentdemo

import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmentdemo.databinding.FragmentOutputBinding


class OutputFragment : Fragment() {

    lateinit var binding: FragmentOutputBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOutputBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        var city:String  =
            if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
                activity?.intent?.getStringExtra("city")?: "Keine Stadt vorhanden"
            else
                arguments?.getString("city","keine Stadt vorhanden")?: lastValue

        binding.tvCity.text = city

        binding.btnWeb.setOnClickListener {
            // Aufruf der Website durch impliziten Intent. Kein direktes Ziel
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("http://www.$city.de")
            startActivity(intent)
        }
        lastValue = city
        return binding.root
    }

    private companion object{
        var lastValue = ""
    }

}