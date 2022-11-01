package com.example.mysketchbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnPaint, btnText, btnClear;
    private PaintArea paintArea;
    private EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPaint = (ImageButton) findViewById(R.id.btnPaint);
        btnText = (ImageButton) findViewById(R.id.btnText);
        btnClear = (ImageButton) findViewById(R.id.btnClear);
        paintArea = (PaintArea) findViewById(R.id.paint);
        paintArea.setVisibility(View.INVISIBLE);
        text = (EditText) findViewById(R.id.editTextTextPersonName);
        text.setVisibility(View.INVISIBLE);
        EditText yourEditText= (EditText) findViewById(R.id.editTextTextPersonName);

    }

    public void onBtnTextClick(View view) {
        text = (EditText) findViewById(R.id.editTextTextPersonName);

        text.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {

            public void run() {
//        ((EditText) findViewById(R.id.et_find)).requestFocus();
//
                EditText yourEditText= (EditText) findViewById(R.id.editTextTextPersonName);
                yourEditText.requestFocus(1);
//        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//        imm.showSoftInput(yourEditText, InputMethodManager.SHOW_IMPLICIT);

                showKeyboard();
            }
        }, 200);
    }

    public void onBtnPaintClick(View view) {
        paintArea.setVisibility(View.VISIBLE);
    }

    public void onBtnClearClick(View view) {
        paintArea.cleanPaintArea();
        text = (EditText) findViewById(R.id.editTextTextPersonName);
        closeKeyboard();
        text.setVisibility(View.INVISIBLE);
        text.setText("text");
    }
    public void showKeyboard(){
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }

    public void closeKeyboard(){
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }
}