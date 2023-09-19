package com.berivangunesyuz.ataobs

import android.content.Context
import android.os.Bundle
import android.provider.ContactsContract.RawContacts.Data
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.berivangunesyuz.ataobs.databinding.ActivityMainBinding
import com.berivangunesyuz.ataobs.databinding.FragmentKayitBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_giris.*
import kotlinx.android.synthetic.main.fragment_kayit.*


class KayitFragment : Fragment() {
    private lateinit var dbRef:DatabaseReference
    private lateinit var kid:String

    lateinit var firebaseDatabase: FirebaseDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kayit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val database = FirebaseDatabase.getInstance().reference
        super.onViewCreated(view, savedInstanceState)
        dbRef=FirebaseDatabase.getInstance().getReference("Kisiler")
        kaydolbutton.setOnClickListener() {
            kisilereKaydet()
            val action=KayitFragmentDirections.actionKayitFragmentToGirisFragment()
            Navigation.findNavController(it).navigate(action)
        }
}

    private fun kisilereKaydet() {
        var ad = adText.text.toString()
        var soyad = soyadText.text.toString()
        var tc = tcEditText.text.toString()
        var telefon = telefonEditText.text.toString()
        var email = mailEditText.text.toString()
        var unvan = unvanEditText.text.toString()
        var girisSifre= tcEditText.text.toString()

         //kid=dbRef.push().key!!

        val veriler=ObsVeriler(ad,soyad,tc,telefon,email,unvan,girisSifre)
        dbRef.child(tc).setValue(veriler)
            .addOnCompleteListener{
                Toast.makeText(context,"KAYIT BAŞARILI",Toast.LENGTH_LONG).show()
                // KAYITTAN SONRA TEXTLERİN İÇERİSİNİ BOŞALTIYORUZ
                adText.text.clear()
                soyadText.text.clear()
                tcEditText.text.clear()
               telefonEditText.text.clear()
               mailEditText.text.clear()
                unvanEditText.text.clear()

            }.addOnFailureListener{ err ->
                Toast.makeText(context,"KAYIT HATALI ${err.message}",Toast.LENGTH_LONG).show()

            }

    }
}











