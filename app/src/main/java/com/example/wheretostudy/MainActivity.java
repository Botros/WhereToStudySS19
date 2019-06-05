package com.example.wheretostudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //DB Code:
    DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatabaseHelper = new DatabaseHelper(this);
        Button btnLoginPage=(Button)findViewById(R.id.btnLoginPage);
        btnLoginPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this,Login.class);
                startActivity(intent);
            }
        });
    }

    public void addUser(String newUser, String newPassword){
        boolean userAdded = mDatabaseHelper.addUser(newUser, newPassword);

        //check if insert was successful
        if(userAdded)
            toastMessage("Neuer Benutzer erfolgreich angelegt!");
        else
            toastMessage("Fehler beim Registrieren des neuen Nutzers!");
    }

    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
