package com.example.sqllite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.sqllite.databinding.ActivityMainBinding;
import com.example.sqllite.view_model.MainViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        MainViewModel mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mainViewModel.init(this);
        binding.setViewModel(mainViewModel);
        binding.setLifecycleOwner(this);

        //Связывам view напрямую с MainViewBinging
        //Связь двусторонняя изменение в MainViewBinging -> изменение в View и наоборот


//        TextView tv = findViewById(R.id.text);
//
//        findViewById(R.id.btInsert).setOnClickListener(v -> {
//            mainViewModel.insertClick();
//        });
//
//        findViewById(R.id.btGeAll).setOnClickListener(v -> {
//            mainViewModel.getAllClick();
//        });
//
//        mainViewModel.getNotesLD().observe(this, o -> {
//            tv.setText(o);
//        });
    }

}