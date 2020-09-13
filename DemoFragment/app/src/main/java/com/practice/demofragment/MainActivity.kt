package com.practice.demofragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity(), OnItemSelectedListener {

    private val arrayListFragment by lazy { ArrayListFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bundle = Bundle()
        bundle.putStringArrayList("numbers", arrayListOf<String>("1", "2", "3", "4", "5"))
        arrayListFragment.arguments = bundle

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container_main_fragment, arrayListFragment)
            .commit()
    }

   override fun onSelectedItem(position: Int) {
        Toast.makeText(this, "$position", Toast.LENGTH_SHORT).show()
    }
}