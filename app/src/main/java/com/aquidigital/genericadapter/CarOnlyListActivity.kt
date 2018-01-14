package com.aquidigital.genericadapter

import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.content_main2.*

class CarOnlyListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        setSupportActionBar(toolbar)

        initFab()
        mockData()
        setAdapter()

    }

    private fun setAdapter() {

        val myAdapter = object  : GenericAdapter<Car>(mockData()){

            override fun getLayoutId(position: Int, obj: Car): Int {
                return R.layout.car_layout
            }

        }
        ListViewActivity2.layoutManager = LinearLayoutManager(this)
        ListViewActivity2.setHasFixedSize(true)
        ListViewActivity2.adapter = myAdapter

    }

    private fun mockData(): List<Car> {
        return listOf(
                Car("Ford", Color.WHITE),
                Car("Audi", Color.BLACK),
                Car("Vauxhal", Color.RED),
                Car("Ford", Color.BLUE),
                Car("Ford", Color.GREEN))
    }

    private fun initFab() {
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

}
