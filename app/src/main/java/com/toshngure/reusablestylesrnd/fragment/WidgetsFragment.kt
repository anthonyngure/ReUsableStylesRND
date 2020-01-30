package com.toshngure.reusablestylesrnd.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.toshngure.reusablestylesrnd.GlideApp

import com.toshngure.reusablestylesrnd.R
import kotlinx.android.synthetic.main.avatars.*

/**
 * A simple [Fragment] subclass.
 */
class WidgetsFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

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


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_widgets_fragment, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_toggle_docs -> {
                val docsTextViews = arrayListOf<View>()
                view?.findViewsWithText(docsTextViews, "AppWidget", View.FIND_VIEWS_WITH_CONTENT_DESCRIPTION)
                Log.d(TAG, "Views with AppWidget -> ${docsTextViews.size}")
                view?.postDelayed({
                    for (v in docsTextViews) {
                        v.visibility = if (v.visibility == View.GONE) View.VISIBLE else View.GONE
                    }
                }, 5000)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    companion object {
        const val TAG = "WidgetsFragment"
    }

}
