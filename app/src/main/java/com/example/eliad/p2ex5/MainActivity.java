package com.example.eliad.p2ex5;

import android.app.SearchManager;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ShowContact(View view){

// Open the contact picker (after button click)
        Intent intent = new Intent(Intent.ACTION_PICK,
                ContactsContract.Contacts.CONTENT_URI);

// Start Intent
        startActivityForResult(intent, 4);
    }

    public void sendSms(View view){
        EditText phoneNumField = (EditText)findViewById(R.id.txtPhoneNumber);
        String phoneNumber = phoneNumField.getText().toString().trim();
// Prepare Intent to open SMS viewer/sender
        Uri uri = Uri.parse("smsto:" + phoneNumber);
        Intent smsIntent = new Intent(Intent.ACTION_SENDTO, uri);
        smsIntent.putExtra("sms_body", "SMS text content here");
// Start Intent
        startActivity(smsIntent);
    }

    public void openWeb(View view){
// Prepare Intent to open URL
        String url = "http://www.google.co.il";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
// Start Intent
        startActivity(intent);

    }

    public void takePhoto(View view){
        // Prepare Camera Intent
        Intent cameraIntent = new
                Intent(MediaStore.ACTION_IMAGE_CAPTURE);
// Start Intent
        startActivityForResult(cameraIntent , 123);

    }

    public void search(View view){
        EditText edittext= (EditText)findViewById(R.id.editText);
        String q = edittext.getText().toString();
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH );
        intent.putExtra(SearchManager.QUERY, q);
        startActivity(intent);
    }

}
