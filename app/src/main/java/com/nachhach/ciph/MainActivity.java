package com.nachhach.ciph;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fabEncode;
    private FloatingActionButton fabHelp;
    private EditText key;
    private EditText OUTPUT;
    private EditText INPUT;
    private Cipher cipher;
    private Lexer lex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        key = findViewById(R.id.keyText);
        INPUT = findViewById(R.id.inputText);
        OUTPUT = findViewById(R.id.outText);
        fabEncode = findViewById(R.id.encodeBtn);
        fabHelp = findViewById(R.id.helpBtn);

        lex = new Lexer(INPUT.getText().toString());
        cipher = new Cipher(key.getText().toString());

        fabEncode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (lex.validWord() && lex.validKey(key.getText().toString())){

                    lex.setWord();

                    OUTPUT.setText(cipher.Encode(lex.getWord()));

                }
            }
        });

    }

    void showHelp(){

        fabHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }
}
