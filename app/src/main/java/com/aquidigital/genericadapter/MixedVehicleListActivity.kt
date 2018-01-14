package com.aquidigital.genericadapter

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.aquidigital.genericadapter.extensions.OnItemClickListener
import com.aquidigital.genericadapter.extensions.addOnItemClickListener
import com.aquidigital.genericadapter.extensions.launchActivity
import kotlinx.android.synthetic.main.activity_main.*


class MixedVehicleListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setAdapter()
        setItemClickListener()
    }

    private fun setAdapter() {
        val myAdapter = object : GenericAdapter<Any>(mixedVehicleMockData()) {
            override fun getLayoutId(position: Int, obj: Any): Int {
                return when (obj) {
                    is Car -> R.layout.car_layout
                    is Bus -> R.layout.bus_layout
                    else -> R.layout.car_layout
                }
            }
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = myAdapter
    }

    private fun setItemClickListener() {
        recyclerView.addOnItemClickListener(object : OnItemClickListener {
            override fun onItemClicked(position: Int, view: View) {
                launchActivity<CarOnlyListActivity> { }
            }
        })
    }

    private fun mixedVehicleMockData(): List<Any> {
        return listOf(Car("audi", Color.BLACK), Bus("Eicher", Color.BLUE),
                Bus("Benz", Color.BLACK), Car("Suzuki", Color.WHITE))
    }
}
