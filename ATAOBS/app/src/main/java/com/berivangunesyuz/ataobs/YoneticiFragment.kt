package com.berivangunesyuz.ataobs

import android.app.Activity
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation


class YoneticiFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_yonetici, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.yonetici_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
   override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id=item.itemId
        if(id==R.id.yemekekleyegitbutton){
            val action=YoneticiFragmentDirections.actionYoneticiFragmentToYemekEkleFragment()
            Navigation.findNavController(context as Activity,R.id.fragmentContainerView ).navigate(action)
        }
        if(id==R.id.duyuruekleyegitbutton){
            val action=YoneticiFragmentDirections.actionYoneticiFragmentToDuyuruEkleFragment()
            Navigation.findNavController(context as Activity,R.id.fragmentContainerView).navigate(action)
        }
        if(id==R.id.dersekleyegitbutton){
            val action =YoneticiFragmentDirections.actionYoneticiFragmentToDersEkleFragment()
            Navigation.findNavController(context as Activity,R.id.fragmentContainerView).navigate(action)
        }
        if(id==R.id.cikis){
            val action=YoneticiFragmentDirections.actionYoneticiFragmentToGirisFragment()
            Navigation.findNavController(context as Activity,R.id.fragmentContainerView).navigate(action)
        }
        if(id==R.id.kayitonayagit){
            Toast.makeText(context,"Kayıt onayı yapınız",Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }

}