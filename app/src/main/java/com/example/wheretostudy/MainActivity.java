package com.example.wheretostudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //DB Code:
    DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatabaseHelper = new DatabaseHelper(this);
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
