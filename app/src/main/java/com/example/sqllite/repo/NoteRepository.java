package com.example.sqllite.repo;

import android.content.Context;

import androidx.room.Room;

import com.example.sqllite.AppDataBase;
import com.example.sqllite.dao.NoteDAO;
import com.example.sqllite.models.Note;

import java.util.List;

public class NoteRepository {
    private NoteDAO noteDAO;

    public NoteRepository(Context context) {
        AppDataBase appDataBase = Room.databaseBuilder(context, AppDataBase.class, "MyDB").build();
        noteDAO = appDataBase.noteDAO();
    }

    public void insertNote(Note note) {
        noteDAO.insertNote(note);
    }
    public List<Note> getNotes() {
        return noteDAO.getNotes();
    }
}
