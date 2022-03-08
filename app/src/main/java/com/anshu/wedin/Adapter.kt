package com.anshu.wedin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(val menuList: ArrayList<event>) : RecyclerView.Adapter<Adapter.MyviewHolder>() {
    class MyviewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val text:TextView = itemView.findViewById(R.id.couple)
        val text2:TextView = itemView.findViewById(R.id.couple2)
        val coupleimg:ImageView = itemView.findViewById(R.id.couple_img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        val viewHolder= LayoutInflater.from(parent.context).inflate(R.layout.event_list,parent,false)
        return MyviewHolder(viewHolder)
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        holder.text.text = menuList[position].coupleName1
        holder.text.text = menuList[position].coupleName2
        holder.coupleimg.setImageResource(menuList[position].coupleimg)
    }

    override fun getItemCount(): Int {
        return menuList.size
    }
}