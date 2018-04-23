package com.example.allaccess.sprint1lab1_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    String realName = "Peter";
    String realPassword = "password";
    String goodLogin = "Login Successful";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //--------assign varia to user input
        final EditText userName = findViewById(R.id.txtUserName);
        final EditText userPassword = findViewById(R.id.txtPassword);
        final TextView logInSuccess = findViewById(R.id.txtSuccess);
        final Button btnLogin = (Button) findViewById(R.id.buttonLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Page2.class));

/*                if (userName.getText().toString().equals(realName))
                {
                    if (userPassword.getText().toString().equalsIgnoreCase(realPassword)) {
                        startActivity(new Intent(getApplicationContext(), Page2.class));
                    }
                    else{
                        logInSuccess.setText(null);
                        Toast.makeText(MainActivity.this, "incorrect password", Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    logInSuccess.setText(null);
                    Toast.makeText(MainActivity.this, "unknown user", Toast.LENGTH_LONG).show();
                }*/

            }//------ END onClick
        }); // ------- END setOnClickListener
    }// ------------ END onCreate


}
