package com.example.federico_mustich.zuccthis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);

        Button cifraButton = (Button) findViewById(R.id.CifraButton);
        cifraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CriptAlg codex = new CriptAlg(editText.getText().toString());
                editText.setText(codex.cifra());
            }
        });

        Button decifraButton = (Button) findViewById(R.id.DecifraButton);
        decifraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CriptAlg codex = new CriptAlg(editText.getText().toString());
                editText.setText(codex.decifra());
            }
        });

        Button cancButton = (Button) findViewById(R.id.CancButton);
        cancButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });
    }
}
