package com.osamadev.computingassignment1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.core.view.size
import androidx.recyclerview.widget.RecyclerView
import com.osamadev.computingassignment1.R
import com.osamadev.computingassignment1.model.data
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.main_data_item_layout.view.*

class dataAdapter(var context:Context ,var array:ArrayList<data>) : RecyclerView.Adapter<dataAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       var root = LayoutInflater.from(context).inflate(R.layout.main_data_item_layout,parent,false)
        return MyViewHolder(root)
    }

    override fun getItemCount(): Int {
        return array.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      holder.name.text = array[position].name
      holder.number.text = array[position].number
      holder.address.text = array[position].address
    }

    class MyViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
       var name = itemView.main_item_data_txt_userName
       var number = itemView.main_item_data_txt_number
       var address = itemView.main_item_data_txt_adddress
    }


}