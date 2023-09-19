package com.berivangunesyuz.ataobs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_ders_listesi.*


class DersListesiFragment : Fragment() {
    private lateinit var dbRef:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ders_listesi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        derslerigetir()
    }

    private fun derslerigetir() {
        dbRef= FirebaseDatabase.getInstance().getReference("DERSLER")
        dbRef.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
              var sb=StringBuilder()
                if(snapshot.exists()){
                    for(i in snapshot.children){
                        var dersadi=i.child("dersadi").getValue()
                        var dershocasi=i.child("dershocasi").getValue()
                        var derskodu=i.child("derskodu").getValue()
                        sb.append("${i.key} \n $dersadi \n $dershocasi \n $derskodu \n")
                    }
                    derslerigostertext.setText(sb)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }


}