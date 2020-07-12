package com.esoxjem.movieguide;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.esoxjem.movieguide.listing.MoviesListingActivity;


public class LoginActivity extends AppCompatActivity {
    TextView register;
    EditText username, password;
    Button login;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        register = (TextView) findViewById(R.id.register);
        databaseHelper = new DatabaseHelper(this);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameValue = username.getText().toString();
                String passwordValue = password.getText().toString();

                if (databaseHelper.isLoginValid(usernameValue, passwordValue)) {
                    Intent intent = new Intent(LoginActivity.this, MoviesListingActivity.class);
                    startActivity(intent);
                    //Toast.makeText(LoginActivity.this,"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                    Toast toast=Toast.makeText(LoginActivity.this,"Đăng nhập thành công", Toast.LENGTH_SHORT);
                    View view=toast.getView();
                    TextView view1 =(TextView)view.findViewById(android.R.id.message);
                    view1.setTextColor(Color.GREEN);
                    view.setBackgroundResource(R.color.colorMessage1);
                    toast.show();
                }
                else {
                    //Toast.makeText(LoginActivity.this,"Sai username hoặc password!", Toast.LENGTH_SHORT).show();
                    Toast toast=Toast.makeText(LoginActivity.this,"Sai username hoặc password!", Toast.LENGTH_SHORT);
                    View view=toast.getView();
                    TextView view1 =(TextView)view.findViewById(android.R.id.message);
                    view1.setTextColor(Color.RED);
                    view.setBackgroundResource(R.color.colorMessage2);
                    toast.show();
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);

            }
        });
    }

}
