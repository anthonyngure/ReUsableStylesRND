package com.toshngure.reusablestylesrnd.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.toshngure.reusablestylesrnd.GlideApp

import com.toshngure.reusablestylesrnd.R
import kotlinx.android.synthetic.main.avatars.*

/**
 * A simple [Fragment] subclass.
 */
class WidgetsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_widgets, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.bottomButton).setOnClickListener {
            findNavController().navigate(WidgetsFragmentDirections.toFragmentFirst())
        }

        val pdslUrl = "https://mula.co.ke/mula_ke/api/v1/images/services/KPLC_BuyTokens.png"
        normalAvatarNI.fetchImage(GlideApp.with(this).load(pdslUrl))
        smallAvatarNI.fetchImage(GlideApp.with(this).load(pdslUrl))
    }

}
