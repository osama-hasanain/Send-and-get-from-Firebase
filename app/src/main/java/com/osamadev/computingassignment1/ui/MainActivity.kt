package com.osamadev.computingassignment1.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.osamadev.computingassignment1.R
import com.osamadev.computingassignment1.adapter.dataAdapter
import com.osamadev.computingassignment1.model.data
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var dataArray : ArrayList<data>
    lateinit var dataAdapter : dataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = FirebaseFirestore.getInstance()
        dataArray = ArrayList()
        dataAdapter = dataAdapter(this,dataArray)
        main_recycler.layoutManager = LinearLayoutManager(this)
        main_recycler.adapter = dataAdapter


        db.collection("data")
            .get()
            .addOnSuccessListener { query ->
                for (q in query){
                    val newData = q.toObject(data::class.java)
                    dataArray.add(newData)
                }
            }
            .addOnCompleteListener {
                dataAdapter.notifyDataSetChanged()
            }
        main_btn_send.setOnClickListener {
            if (main_txt_name.text.isNotEmpty() && main_txt_number.text.isNotEmpty() && main_txt_address.text.isNotEmpty()){
                var data = data(main_txt_name.text.toString(),main_txt_number.text.toString(),main_txt_address.text.toString())
                db.collection("data")
                    .add(data)
                    .addOnSuccessListener {
                        dataArray.add(data)
                        Toast.makeText(this,"Added is Successful",Toast.LENGTH_LONG).show()
                        dataAdapter.notifyDataSetChanged()
                        main_txt_name.text.clear()
                        main_txt_number.text.clear()
                        main_txt_address.text.clear()
                    }
            }else{
                Toast.makeText(this,"Please fill all boxes",Toast.LENGTH_LONG).show()
            }
        }

    }
}