package com.example.sqllite.view_model;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.sqllite.models.Note;
import com.example.sqllite.repo.NoteRepository;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainViewModel extends ViewModel {
    NoteRepository noteRepository;
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    private MutableLiveData<String> notesLD = new MutableLiveData<>();

    public void init(Context context){
        noteRepository = new NoteRepository(context);
    }

    public MutableLiveData<String> getNotesLD() {
        return notesLD;
    }

    public void setNotesLD(String notesStr) {
        this.notesLD.postValue(notesStr);
    }

    public void insertClick() {
        executorService.execute(() -> {
            noteRepository.insertNote(new Note("Kek"));
        });
    }

    public void getAllClick() {
        executorService.execute(() -> {
            notesLD.postValue(noteRepository.getNotes().toString());
        });
    }
}
