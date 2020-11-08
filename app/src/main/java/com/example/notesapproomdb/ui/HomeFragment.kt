package com.example.notesapproomdb.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.notesapproomdb.R
import com.example.notesapproomdb.db.NoteDatabase
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private final val TAG:String = "HomeFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recycler_view.setHasFixedSize(true)
        recycler_view.layoutManager = LinearLayoutManager(context)

        CoroutineScope(Dispatchers.Main).launch {
            val note = NoteDatabase(requireContext()).getNoteDao().getAllNotes()
            recycler_view.adapter = NotesAdapter(note)
        }

        btn_add.setOnClickListener{
            val action = HomeFragmentDirections.actionHomeFragmentToAddNotesFragment()
            Navigation.findNavController(it).navigate(action)
        }

    }
}