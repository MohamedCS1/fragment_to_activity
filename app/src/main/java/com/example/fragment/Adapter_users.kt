package com.example.fragment
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.frag_to_activity.R
import com.example.pojo.Users_Model

class Adapter_users(): RecyclerView.Adapter<Adapter_users.viewholderusers>() {

    private var listenner: SetonItemClickListenner? = null
    private var arraylist = arrayListOf<Users_Model>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholderusers {

        return viewholderusers(LayoutInflater.from(parent.context).inflate(R.layout.card_item,parent,false))

    }

    override fun onBindViewHolder(holder: viewholderusers, position: Int) {
        holder.tv_name.text = arraylist[position].name
        holder.tv_prnm.text = arraylist[position].prnm
        holder.tv_age.text = arraylist[position].age.toString()

        holder.itemView.setOnClickListener {
            listenner?.onItemClick(arraylist[position])
        }
    }

    override fun getItemCount(): Int {
        return arraylist.size
    }

    class viewholderusers(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val tv_name = itemView.findViewById<TextView>(R.id.tv_name)
        val tv_prnm = itemView.findViewById<TextView>(R.id.tv_prnm)
        val tv_age = itemView.findViewById<TextView>(R.id.tv_age)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(ArrayList:ArrayList<Users_Model>)
    {
        this.arraylist = ArrayList
        notifyDataSetChanged()
    }

    fun listenner(listenner: SetonItemClickListenner)
    {
        this.listenner = listenner
    }
}
