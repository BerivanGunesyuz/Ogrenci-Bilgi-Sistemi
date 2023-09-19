package com.berivangunesyuz.ataobs

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_ogrenci.*

class OgrenciFragment : Fragment() {
    private lateinit var dbRef: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ogrenci, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater!!.inflate(R.menu.menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item!!.itemId
        if (id == R.id.nav_kisiselBilgiler) {
            val action = OgrenciFragmentDirections.actionOgrenciFragmentToKisiselBilgilerFragment2()
            Navigation.findNavController(context as Activity, R.id.fragmentContainerView)
                .navigate(action)
        }
        if (id == R.id.nav_notlarim) {
            val action = OgrenciFragmentDirections.actionOgrenciFragmentToNotlarFragment()
            Navigation.findNavController(context as Activity, R.id.fragmentContainerView)
                .navigate(action)
        }
        if (id == R.id.nav_derslerim) {
            val action = OgrenciFragmentDirections.actionOgrenciFragmentToDersListesiFragment()
            Navigation.findNavController(context as Activity, R.id.fragmentContainerView)
                .navigate(action)
        }
        if (id == R.id.nav_cikis) {
            val action = OgrenciFragmentDirections.actionOgrenciFragmentToGirisFragment()
            Navigation.findNavController(context as Activity, R.id.fragmentContainerView)
                .navigate(action)
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        duyurulariGetir()
        yemeklerigetir()

    }

    private fun yemeklerigetir() {
        dbRef=FirebaseDatabase.getInstance().getReference("YEMEKLER")
        dbRef.addValueEventListener(object :ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val sb=StringBuilder()
                if(snapshot.exists()){
                    for(i in snapshot.children){
                        val anayemek=i.child("anayemek").getValue()
                        val arayemek=i.child("arayemek").getValue()
                        val corba=i.child("corba").getValue()
                        val tatli=i.child("tatli").getValue()
                        sb.append("${i.key}  \n $anayemek \n $arayemek \n $corba \n $tatli ")
                    }
                    yemeklerigoster.setText(sb)
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }

    private fun duyurulariGetir() {
        dbRef=FirebaseDatabase.getInstance().getReference("DUYURULAR")
        dbRef.addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val sb=StringBuilder()
             if(snapshot.exists()) {
                 for(i in snapshot.children){
                  val duyuru=i.child("duyuru").getValue()
                     sb.append("${i.key} \n $duyuru")

                 }
                 duyurugostertext.setText(sb)
             }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }
}
