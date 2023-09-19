package com.berivangunesyuz.ataobs

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment


class OgretimGorevlisiFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ogretim_gorevlisi, container, false)
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater!!.inflate(R.menu.ogretimuyesi_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


}