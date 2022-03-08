package com.anshu.wedin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.anshu.wedin.databinding.ActivityWedinBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_wedin.*

class WedinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wedin)

        val list = ArrayList<event>()
        var adapterevent:Adapter? = null

        list.add(event(R.drawable.ellipse2, "Rahul Kathuriya", "Priya Sharma"))
        list.add(event(R.drawable.ellipse3, "Manik Kathuriya", "Anupriya Sharma"))
        list.add(event(R.drawable.ellipse4, "Deepali Kathuriya", "Ayush Sharma"))
        list.add(event(R.drawable.ellipse2, "Rahul Kathuriya", "Priya Sharma"))
        list.add(event(R.drawable.ellipse3, "Manik Kathuriya", "Anupriya Sharma"))
        list.add(event(R.drawable.ellipse4, "Deepali Kathuriya", "Ayush Sharma"))

        adapterevent = Adapter(list)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = adapterevent

    }

}