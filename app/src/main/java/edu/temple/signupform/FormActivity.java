package edu.temple.signupform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    private Button save;
    private EditText name;
    private EditText email;
    private EditText password;
    private EditText confirmPW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        addListenerOnButton();
    }

    private void addListenerOnButton() {
        name = (EditText)findViewById(R.id.Name);
        email = (EditText)findViewById(R.id.Email);
        password = (EditText)findViewById(R.id.Password);
        confirmPW = (EditText)findViewById(R.id.Confirm);
        save = (Button)findViewById(R.id.btnSave);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = new Toast(getApplicationContext());
                int duration = Toast.LENGTH_SHORT;
                Boolean allFieldsEntered = false;
                Boolean passwordsMatch = false;

                // MAKES SURE USER ENTERS IN ALL FIELDS
                if(name.length() == 0 || email.length() == 0 || password.length() == 0
                        || confirmPW.length() == 0)
                {
                    toast.makeText(FormActivity.this, "Please enter in all fields", duration).show();
                }
                else
                    allFieldsEntered = true;

                // MAKES SURE PASSWORDS ARE THE SAME
                String comparePW = password.getText().toString();
                String compareConfirmPW = confirmPW.getText().toString();
                if(!comparePW.equals(compareConfirmPW))
                    toast.makeText(FormActivity.this, "Passwords do not match", duration).show();
                else
                    passwordsMatch = true;

                // SAVES INFO AFTER ALL FIELDS ARE ENTERED AND PASSWORDS HAVE MATCHED
                if(allFieldsEntered && passwordsMatch)
                    toast.makeText(FormActivity.this, "You info has been save!", duration).show();
            }
        });
    }


}
