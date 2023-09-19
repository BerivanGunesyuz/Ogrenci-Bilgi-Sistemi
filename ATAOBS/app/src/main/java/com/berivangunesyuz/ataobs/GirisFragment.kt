package com.berivangunesyuz.ataobs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_giris.*

class GirisFragment : Fragment() {
    private lateinit var dbRef:DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_giris, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        kaydagidisbutton.setOnClickListener {
            val action = GirisFragmentDirections.actionGirisFragmentToKayitFragment()
            Navigation.findNavController(it).navigate(action)
        }
        girisbutton.setOnClickListener() {
            dbRef = FirebaseDatabase.getInstance().getReference("Kisiler")
            dbRef.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val girisTc = girisTc.text.toString()
                    val girisSifre = girisSifre.text.toString()
                    var sayac=0
                    var sayac1=0
                    if (snapshot.exists()) {
                        for (i in snapshot.children) {
                            var ad = i.child("ad").getValue()
                            var soyad = i.child("soyad").getValue()
                            var email = i.child("email").getValue()
                            var telefon = i.child("telNo").getValue()
                            var tc = i.child("tc").getValue()
                            var unvan = i.child("unvan").getValue()
                            sayac=sayac+1
                            sayac1=sayac1+1
                            if ((girisTc == tc) && (girisSifre == tc) ) {
                              if(girisTc.toInt()==1){
                                  val action =GirisFragmentDirections.actionGirisFragmentToYoneticiFragment()
                                  Navigation.findNavController(it).navigate(action)
                                  Toast.makeText(context, "GİRİŞ BAŞARILI ", Toast.LENGTH_LONG).show()
                                  sayac1=sayac1-1
                              }
                                else if(unvan=="ogrenci"){
                                    val action=GirisFragmentDirections.actionGirisFragmentToOgrenciFragment()
                                  Navigation.findNavController(it).navigate(action)
                                  sayac1=sayac1-1
                              }
                                else{
                                    val action=GirisFragmentDirections.actionGirisFragmentToOgretimGorevlisiFragment()
                                  Navigation.findNavController(it).navigate(action)
                                  sayac1=sayac1-1
                              }

                            }

                        }
                        if(sayac==sayac1){
                        Toast.makeText(context, "GİRİŞ HATALI", Toast.LENGTH_LONG).show()
                        }
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                }

            })


        }
    }



}



