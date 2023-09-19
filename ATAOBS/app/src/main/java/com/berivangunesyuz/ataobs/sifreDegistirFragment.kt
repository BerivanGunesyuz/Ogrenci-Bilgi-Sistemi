package com.berivangunesyuz.ataobs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.berivangunesyuz.ataobs.databinding.FragmentGirisBinding
import com.berivangunesyuz.ataobs.databinding.FragmentKayitBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_giris.*
import kotlinx.android.synthetic.main.fragment_kayit.*
import kotlinx.android.synthetic.main.fragment_sifre_degistir.*


class sifreDegistirFragment : Fragment() {
  //private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sifre_degistir, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        güncellebutton.setOnClickListener {
            val yeniSifre=yeniSifreText.text.toString()
            val tc= girisTc.text.toString()
            //guncelle(tc,yeniSifre)

        }
    }

   /* private fun guncelle(tc:String,sifre:String) {
        dbRef=FirebaseDatabase.getInstance().getReference("Kisiler")
        val guncelle1= mapOf<String,String>(
            "girisSifre" to sifre
        )
        dbRef.child(tc).updateChildren(guncelle1).addOnSuccessListener {
            Toast.makeText(context,"GÜNCELLEME BAŞARILI",Toast.LENGTH_LONG).show()

        }.addOnFailureListener{
            Toast.makeText(context,"GÜNCELLEME YAPILAMADI",Toast.LENGTH_LONG).show()
        }
    }*/



}