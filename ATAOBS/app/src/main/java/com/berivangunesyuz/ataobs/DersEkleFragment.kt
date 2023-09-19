package com.berivangunesyuz.ataobs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_ders_ekle.*


class DersEkleFragment : Fragment() {
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ders_ekle, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dbRef= FirebaseDatabase.getInstance().getReference("DERSLER")
        derseklebutton.setOnClickListener(){
            derskaydet()
        }

        super.onViewCreated(view, savedInstanceState)
    }

    private fun derskaydet() {
    var dersAdi=dersaditext.text.toString()
    var dersKodu=derskodutext.text.toString()
    var hocaAdi=hocaaditext.text.toString()

    val veriler =DersVerileri(dersAdi,dersKodu,hocaAdi)
    dbRef.child(dersAdi).setValue(veriler) .addOnCompleteListener(){
        Toast.makeText(context,"KAYIT BAŞARILI", Toast.LENGTH_LONG).show()
        dersaditext.text.clear()
        derskodutext.text.clear()
        hocaaditext.text.clear()
    }  .addOnFailureListener{ err ->
        Toast.makeText(context,"KAYIT HATALI ${err.message}",Toast.LENGTH_LONG).show()
    }
    }

}