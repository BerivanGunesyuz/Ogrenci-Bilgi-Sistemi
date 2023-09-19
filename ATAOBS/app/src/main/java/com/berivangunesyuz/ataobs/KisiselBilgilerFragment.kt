package com.berivangunesyuz.ataobs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.berivangunesyuz.ataobs.databinding.FragmentGirisBinding
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_giris.*
import kotlinx.android.synthetic.main.fragment_kisisel_bilgiler.*


class KisiselBilgilerFragment : Fragment() {
    private lateinit var dbRef: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kisisel_bilgiler, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        kisiselbilgilerigetir()
    }

    private fun kisiselbilgilerigetir() {
        dbRef=FirebaseDatabase.getInstance().getReference("Kisiler")
        dbRef.addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                var sb=StringBuilder()
                if(snapshot.exists()){
                    for(i in snapshot.children){
                        var ad = i.child("ad").getValue()
                        var soyad = i.child("soyad").getValue()
                        var email = i.child("email").getValue()
                        var telefon = i.child("telNo").getValue()
                        var tc = i.child("tc").getValue()
                        var unvan = i.child("unvan").getValue()

                            sb.append("${i.key} \n  $ad \n  $soyad \n  $email  \n $telefon  \n $tc \n $unvan \n\n")

                    }
                    kisiselbilgilerigoster.setText(sb)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }


}