package com.example.notesapproomdb.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapproomdb.R
import com.example.notesapproomdb.db.Note
import kotlinx.android.synthetic.main.note_layout.view.*

class NotesAdapter(val notes:List<Note>) : RecyclerView.Adapter<NotesAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.note_layout,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.view.tv_title_display.text = notes[position].title
        holder.view.tv_notebody_display.text = notes[position].note
    }


    class MyViewHolder(val view:View) : RecyclerView.ViewHolder(view)
}