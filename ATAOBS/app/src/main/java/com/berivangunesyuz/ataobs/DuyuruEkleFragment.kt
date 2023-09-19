package com.berivangunesyuz.ataobs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_duyuru_ekle.*


class DuyuruEkleFragment : Fragment() {
    private lateinit var dbRef: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_duyuru_ekle, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dbRef= FirebaseDatabase.getInstance().getReference("DUYURULAR")
        duyurueklebutton.setOnClickListener(){
            duyuruekle()
        }
    }

    private fun duyuruekle() {
        var duyuru=duyurutext.text.toString()
        val id=dbRef.push().key!!

        val veriler=Duyurular(duyuru,id)
        dbRef.child(id).setValue(veriler).addOnCompleteListener(){
            Toast.makeText(context,"KAYIT BAŞARILI", Toast.LENGTH_LONG).show()
            duyurutext.text.clear()

        }.addOnFailureListener{ err ->
            Toast.makeText(context,"KAYIT HATALI ${err.message}",Toast.LENGTH_LONG).show()

        }


    }

}