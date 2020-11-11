package com.example.notesapproomdb.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapproomdb.R
import com.example.notesapproomdb.db.Note
import com.example.notesapproomdb.ui.HomeFragmentDirections
import kotlinx.android.synthetic.main.note_layout.view.*

class NotesAdapter(val notes:List<Note>) : RecyclerView.Adapter<NotesAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.note_layout, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.view.tv_title_display.text = notes[position].title
        holder.view.tv_notebody_display.text = notes[position].note

        holder.view.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToAddNotesFragment()
            action.note = notes[position]
            Navigation.findNavController(it).navigate(action)
        }
    }

    class MyViewHolder(val view:View) : RecyclerView.ViewHolder(view)

}