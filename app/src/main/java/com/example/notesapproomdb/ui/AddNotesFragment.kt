package com.example.notesapproomdb.ui

import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.notesapproomdb.R
import com.example.notesapproomdb.db.Note
import com.example.notesapproomdb.db.NoteDatabase
import kotlinx.android.synthetic.main.fragment_add_notes.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddNotesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_notes, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //NoteDatabase(requireActivity()).getNoteDao()
        btn_save.setOnClickListener{
            val notestitle = et_title.text.toString().trim()
            val notesBody = et_notes.text.toString().trim()

            if(notestitle.isEmpty())
            {
                et_title.error = "Enter a title"
                et_title.requestFocus()
                return@setOnClickListener
            }
            if(notesBody.isEmpty())
            {
                et_notes.error = "Enter Notes"
                et_notes.requestFocus()
                return@setOnClickListener
            }

//            val note = Note(title = notestitle,note = notesBody)
//            saveNotes(note)

            CoroutineScope(Dispatchers.Main).launch {
                val note = Note(title = notestitle,note = notesBody)
                NoteDatabase(requireContext()).getNoteDao().addNote(note)
                Toast.makeText(activity, "Notes Saved", Toast.LENGTH_SHORT).show()
            }
        }
    }

//    private fun saveNotes(note: Note)
//    {
//        class SaveNotes : AsyncTask<Void,Void,Void>(){
//            override fun doInBackground(vararg p0: Void?): Void? {
//                NoteDatabase(requireContext()).getNoteDao().addNote(note)
//                return null
//            }
//
//            override fun onPostExecute(result: Void?) {
//                super.onPostExecute(result)
//                Toast.makeText(activity, "Notes Saved", Toast.LENGTH_SHORT).show()
//            }
//        }
//
//        SaveNotes().execute()
//    }


}