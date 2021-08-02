package com.example.emailsendingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText url;
    EditText subject;
    EditText message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        url = findViewById(R.id.url);
        subject = findViewById(R.id.subject);
        message = findViewById(R.id.message);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlText = url.getText().toString();
                String subjectText = subject.getText().toString();
                String messageText = message.getText().toString();
                Toast.makeText(MainActivity.this, "You will be Redirected", Toast.LENGTH_SHORT).show();

                String [] address = {urlText};
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("*/*");
                intent.putExtra(Intent.EXTRA_EMAIL, address);
                intent.putExtra(Intent.EXTRA_SUBJECT, subjectText);
                intent.putExtra(Intent.EXTRA_TEXT, messageText);
                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }

            }

        });

    }

}