package com.example.frag_to_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.fragment.Adapter_users
import com.example.fragment.SetonItemClickListenner
import com.example.fragment.user_fragment
import com.example.pojo.Users_Model

class MainActivity : AppCompatActivity(),user_fragment.listenner_form_fragment {

    var tv_name: TextView? = null
    var tv_prnm: TextView? = null
    var tv_age: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_name = findViewById<TextView>(R.id.a_tv_name)
        tv_prnm = findViewById<TextView>(R.id.a_tv_prnm)
        tv_age = findViewById<TextView>(R.id.a_tv_age)

    }

    override fun onClickitem(user: Users_Model) {
        tv_name?.text = user.name
        tv_prnm?.text = user.prnm
        tv_age?.text = user.age.toString()

    }
}