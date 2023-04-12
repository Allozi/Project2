package com.example.assignment2

import Calc_Fragment
import Color_Fragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_color -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, Color_Fragment())
                    .addToBackStack(null)
                    .commit()
                return true
            }
            R.id.menu_calc -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, Calc_Fragment())
                    .addToBackStack(null)
                    .commit()
                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }


}