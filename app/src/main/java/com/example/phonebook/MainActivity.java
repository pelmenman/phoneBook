package com.example.phonebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import com.example.phonebook.Phones.Phones;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private EditText name, surname, phoneNumber;
    private FirebaseDatabase data;
    private DatabaseReference phoneBook;
    private Button save, read;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String savedName = name.getText().toString();
                String savedSurname = surname.getText().toString();
                String savedPhone = phoneNumber.getText().toString();

                name.setText("");
                surname.setText("");
                phoneNumber.setText("");

                Phones contact = new Phones(savedName, savedSurname, savedPhone);
                //phoneBook.setValue(contact);
            }
        });
    }

    private void init() {
        name = findViewById(R.id.name);
        name.setHint("Name");

        surname = findViewById(R.id.surname);
        surname.setHint("Surname");

        phoneNumber = findViewById(R.id.phoneNumber);
        phoneNumber.setHint("Phone");

        data = FirebaseDatabase.getInstance("https://phonebook-6d31f-default-rtdb.europe-west1.firebasedatabase.app");
        phoneBook = data.getReference("Contact");

        save = findViewById(R.id.saveButton);
        read = findViewById(R.id.readButton);
    }

}