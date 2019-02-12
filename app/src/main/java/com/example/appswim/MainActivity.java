package com.example.appswim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.appswim.database.SwimmerLab;

public class MainActivity extends AppCompatActivity {

    private EditText mTextoSwimmer;
    private Button mGuardar;
    private Button mBorrar;

    private SwimmerLab mSwimmerLab;
    private Swimmer mSwimmer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
