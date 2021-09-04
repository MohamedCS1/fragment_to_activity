package com.example.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.frag_to_activity.R
import com.example.pojo.Users_Model

class user_fragment : Fragment() {

    private var listenner:listenner_form_fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onAttach(context: Context) {

        listenner = context as listenner_form_fragment

        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v  = inflater.inflate(R.layout.fragment_user_fragment, container, false)

        val rv = v.findViewById<RecyclerView>(R.id.rv_users)

        val list = arrayListOf<Users_Model>()

        list.add(Users_Model("Mohamed" ,"Mezenner" ,19))

        list.add(Users_Model("Sonadil" ,"Almodir" ,20))

        list.add(Users_Model("Hmida" ,"Dhmikoch" ,21))

        list.add(Users_Model("Abdlh" ,"Abdlhajl" ,22))

        list.add(Users_Model("Yannis" ,"Drbach" ,23))

        val lm = LinearLayoutManager(activity)

        rv.layoutManager = lm

        val adapter = Adapter_users()

        rv.adapter = adapter

        adapter.setList(list)

        adapter.listenner(object :SetonItemClickListenner
        {
            override fun onItemClick(user: Users_Model) {

                listenner?.onClickitem(user)

            }

        })

        return v
    }

    interface listenner_form_fragment
    {
        fun onClickitem(user:Users_Model)
    }

}