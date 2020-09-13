package com.practice.demofragment

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment
import java.lang.ClassCastException

class ArrayListFragment : ListFragment() {

    private var onItemSelectedListener: OnItemSelectedListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            onItemSelectedListener = (context as OnItemSelectedListener)
        } catch (e: ClassCastException) {
            throw ClassCastException(activity.toString() + " must implement OnItemSelectedListener Interface")
        }
    }

    private fun getList(): ArrayList<String> {
        return arguments!!.getStringArrayList("numbers")!!
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        listAdapter =
            ArrayAdapter(activity!!, android.R.layout.simple_list_item_activated_1, getList())
        listView.choiceMode = ListView.CHOICE_MODE_SINGLE
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        listView.setItemChecked(position, true)
        onItemSelectedListener?.onSelectedItem(position)
    }
}