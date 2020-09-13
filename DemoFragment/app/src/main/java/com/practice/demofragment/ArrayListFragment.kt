package com.practice.demofragment

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment

class ArrayListFragment : ListFragment() {
    companion object {
        private val NUMBERS: ArrayList<String> =
            arrayListOf("1", "2", "3", "4", "5", "6", "7", "8", "9")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        listAdapter =
            ArrayAdapter(activity!!, android.R.layout.simple_list_item_activated_1, NUMBERS)
        listView.choiceMode = ListView.CHOICE_MODE_SINGLE
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        listView.setItemChecked(position, true)
    }
}