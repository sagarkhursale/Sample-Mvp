package com.sagar.samplemvp.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sagar.samplemvp.R;
import com.sagar.samplemvp.root.App;

import javax.inject.Inject;


public class LoginActivity extends AppCompatActivity implements LoginActivityMvp.View {

    @Inject
    LoginActivityMvp.Presenter presenter;

    private EditText firstName;
    private EditText lastName;
    private Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ((App) getApplication()).getComponent().inject(this);


        firstName = findViewById(R.id.login_firstName_editText);
        lastName = findViewById(R.id.login_lastName_editText);
        login = findViewById(R.id.login_button);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.loginButtonClicked();
            }
        });

        // end
    }


    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.getCurrentUser();
    }


    @Override
    public String getFirstName() {
        return firstName.getText().toString();
    }


    @Override
    public String getLastName() {
        return lastName.getText().toString();
    }


    @Override
    public void showUserNotAvailable() {
        Toast.makeText(this, "Error the user is not available.", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void showInputError() {
        Toast.makeText(this, "First name or Last name cannot be empty.", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void showUserSavedMessage() {
        Toast.makeText(this, "User Saved!", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void setFirstName(String fname) {
        firstName.setText(fname);
    }


    @Override
    public void setLastName(String lname) {
        lastName.setText(lname);
    }

    // END
}
