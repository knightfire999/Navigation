package com.example.navigation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.fragment_title.view.*

class TitleFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    //working with any widgets needs to be done here because this is when the layout starts to actually exist
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_title, container, false)

        //manipulate all the widgets here in between inflating and returning
        rootView.button_titleFragment_navTest.setOnClickListener { view : View ->
            if(Math.random() < 0.5) {
                view.findNavController().navigate(R.id.action_titleFragment_to_SecondFragment)
            }
            else {
                view.findNavController().navigate(R.id.action_titleFragment_to_blankFragment)
            }
        }
        setHasOptionsMenu(true)

        //return inflated view
        return rootView
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.
        onNavDestinationSelected(item,requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            TitleFragment()
    }
}