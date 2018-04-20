package com.example.allaccess.sprint1lab1_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class Page2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
//------------- user input objects ------------------
        final EditText lastName = findViewById(R.id.txtLast);
        final EditText firstName = findViewById(R.id.txtFirst);
        final EditText phoneNumber = findViewById(R.id.txtPhone);
        final EditText birthDate = findViewById(R.id.txtDate);
        final EditText birthYear = findViewById(R.id.txtYear);
//------------ fixed Text display output objects   -----------
        final TextView isCertificate = findViewById(R.id.txtCert);
        final TextView isAssociates = findViewById(R.id.txtAssociates);
//------------- Spinner objects -------------------------
        final Spinner spinCertificate = findViewById(R.id.spnCertificate);
        final Spinner spinAssociates = findViewById(R.id.spnAssociates);
        final Spinner spinMonth = findViewById(R.id.spnMonths);

// ----------- Button and Switch objects -----------
        final Switch switchProgram = findViewById(R.id.swProgram);
        final Button btnNext = findViewById(R.id.btnNext);

        switchProgram.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    spinAssociates.setVisibility(View.VISIBLE);
                    isAssociates.setVisibility(View.VISIBLE);
                    spinCertificate.setVisibility(View.GONE);
                    isCertificate.setVisibility(View.GONE);
                }
                else{
                    spinAssociates.setVisibility(View.GONE);
                    isAssociates.setVisibility(View.GONE);
                    spinCertificate.setVisibility(View.VISIBLE);
                    isCertificate.setVisibility(View.VISIBLE);
                }//-------- END else
            }// ------- END onCheckedChanged
        });


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastName.setError(null);
                firstName.setError(null);
                phoneNumber.setError(null);
                birthDate.setError(null);
                birthYear.setError(null);

                if (checkData()) {
                    String bdString = spinMonth.getSelectedItem().toString() + "/" + birthDate.getText().toString() + "/" + birthYear.getText().toString();

                    Intent nextScreen = new Intent(Page2.this, Page3.class);
                    nextScreen.putExtra("FirstName", firstName.getText().toString());
                    nextScreen.putExtra("LastName", lastName.getText().toString());
                    nextScreen.putExtra("Phone", phoneNumber.getText().toString());
                    nextScreen.putExtra("BirthDate", bdString);

                    if (spinAssociates.getVisibility() == View.VISIBLE) {
                        nextScreen.putExtra("isDegreeCert", "Degree");
                        nextScreen.putExtra("degreeCert", spinAssociates.getSelectedItem().toString());
                    } else {
                        nextScreen.putExtra("isDegreeCert", "Certificate");
                        nextScreen.putExtra("degreeCert", spinCertificate.getSelectedItem().toString());
                    }
                    //Start the activity
                    startActivity(nextScreen);
                }
            }
        });


    }//------------ END onCreate

    private boolean checkData(){
        //------------- user input objects ------------------
        final EditText lastName = findViewById(R.id.txtLast);
        final EditText firstName = findViewById(R.id.txtFirst);
        final EditText phoneNumber = findViewById(R.id.txtPhone);
        final EditText birthDate = findViewById(R.id.txtDate);
        final EditText birthYear = findViewById(R.id.txtYear);

        if(lastName.getText().toString().isEmpty()){
            lastName.setError("Last name required");
            lastName.requestFocus();
            return false;
        }

        if(firstName.getText().toString().isEmpty()){
            firstName.setError("First name required");
            firstName.requestFocus();
            return false;
        }

        if(phoneNumber.getText().toString().isEmpty()){
            phoneNumber.setError("Phone number required");
            phoneNumber.requestFocus();
            return false;
        }

       if(birthDate.getText().toString().isEmpty()){
            birthDate.setError("Date is required");
            birthDate.requestFocus();
            return false;
        }

        if(birthYear.getText().toString().isEmpty()){
            birthYear.setError("Year is required");
            birthYear.requestFocus();
            return false;
        }


        return true;
    }
}//---------------- RND class Page2
