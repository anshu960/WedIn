package com.anshu.wedin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_wedin.*

class WedinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wedin)

        val list = ArrayList<DataEvent>()
        var adapterevent:Adapter? = null

        list.add(DataEvent(R.drawable.ellipse2, "Anshu Singh", "Nisha Singh",
            8, "Dec", 2020))
        list.add(DataEvent(R.drawable.ellipse3, "Manik Kathuriya", "Anupriya Sharma",
            20,"Feb", 2020))
        list.add(DataEvent(R.drawable.ellipse4, "Deepali Kathuriya", "Ayush Sharma",
        12,"March", 2020))
        list.add(DataEvent(R.drawable.ellipse2, "Rahul Kathuriya", "Priya Sharma",
            12, "June", 2010))
        list.add(DataEvent(R.drawable.ellipse2, "Anshu Singh", "Nisha Singh",
            8, "Dec", 2022))
        list.add(DataEvent(R.drawable.ellipse3, "Manik Kathuriya", "Anupriya Sharma",
            20,"Feb", 2020))
        list.add(DataEvent(R.drawable.ellipse4, "Deepali Kathuriya", "Ayush Sharma",
            12,"March", 2020))
        list.add(DataEvent(R.drawable.ellipse2, "Rahul Kathuriya", "Priya Sharma",
            12, "June", 2010))


        adapterevent = Adapter(list)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = adapterevent

    }

}