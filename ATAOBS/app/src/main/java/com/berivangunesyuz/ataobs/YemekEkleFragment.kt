package com.berivangunesyuz.ataobs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_yemek_ekle.*


class YemekEkleFragment : Fragment() {
    private lateinit var dbRef: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_yemek_ekle, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dbRef= FirebaseDatabase.getInstance().getReference("YEMEKLER")
        yemekeklebutton.setOnClickListener(){
            yemekekle()
        }
        super.onViewCreated(view, savedInstanceState)
    }

    private fun yemekekle() {
        var anayemek=anayemektext.text.toString()
        var arayemek=arayemektext.text.toString()
        var corba=corbatext.text.toString()
        var tatli=tatlitext.text.toString()

        val veriler=Yemekler(anayemek,arayemek,corba,tatli)
        dbRef.child("menu").setValue(veriler).addOnCompleteListener(){
            Toast.makeText(context,"KAYIT BAŞARILI", Toast.LENGTH_LONG).show()
            anayemektext.text.clear()
            arayemektext.text.clear()
            corbatext.text.clear()
            tatlitext.text.clear()
        }.addOnFailureListener{ err ->
            Toast.makeText(context,"KAYIT HATALI ${err.message}",Toast.LENGTH_LONG).show()
        }

    }
}