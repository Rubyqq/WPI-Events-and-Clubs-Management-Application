package wpiv10.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.database.Cursor;
import android.view.View.OnClickListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import wpiv10.myapplication.constant.SQLCommand;
import wpiv10.myapplication.util.DBOperator;

public class sign_upActivity extends AppCompatActivity implements OnClickListener {

    EditText firstname, lastname,phone_number, email, password, comfirmpassword, student_ID, Gender;
    Button joinin_btn;
    Spinner dspinner;
    ArrayAdapter<CharSequence> adapter;
    int a;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        firstname = (EditText) this.findViewById(R.id.firstname);
        lastname = (EditText) this.findViewById(R.id.lastname);
        student_ID = (EditText) this.findViewById(R.id.studentID);
        phone_number = (EditText) this.findViewById(R.id.PhoneNumber);
        email = (EditText) this.findViewById(R.id.email);
        Gender = (EditText)this.findViewById(R.id.gender);
        password = (EditText) this.findViewById(R.id.passwordb);
        comfirmpassword = (EditText) this.findViewById(R.id.confirmPassword);
        joinin_btn = (Button) this.findViewById(R.id.joinnowbutton);
        dspinner = (Spinner)this.findViewById(R.id.departmentspinner);
        adapter = ArrayAdapter.createFromResource(this,R.array.departmentspinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dspinner.setAdapter(adapter);


        joinin_btn.setOnClickListener(this);
        onSignInBackClick();
        //closeInBackClick();


    }

    public void onSignInBackClick() {
        TextView Sign_inText = (TextView)findViewById(R.id.Sign_in2);

        Sign_inText.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(sign_upActivity.this, MainActivity.class);
                        startActivity(intent);

                    }
                }
        );
    }

    /*public void closeInBackClick() {
        ImageButton close = (ImageButton)findViewById(R.id.closeButton);

        close.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(sign_upActivity.this, MainActivity.class);
                        startActivity(intent);

                    }
                }
        );
    }*/

    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.joinnowbutton) {
            String pass1 = password.getText().toString();
            String comfirmpass = comfirmpassword.getText().toString();
            String lastName = lastname.getText().toString();
            String firstName = firstname.getText().toString();
            String student_id =  student_ID.getText().toString();
            String phonenumber = phone_number.getText().toString();
            String email1 = email.getText().toString();
            String gender = Gender.getText().toString();

            if (pass1.length() ==0  || comfirmpass.length() ==0 || lastName.length() ==0 ||
                    firstName.length() ==0 || student_id.length() ==0 || phonenumber.length() ==0 || email1.length() ==0 || gender.length() == 0) {
                Toast.makeText(sign_upActivity.this, "Information can not be null", Toast.LENGTH_SHORT).show();
            }
            else if (pass1.equals(comfirmpass) && (gender.equals("F") || gender.equals("M"))){
                Toast.makeText(getBaseContext(), "Join in successfully", Toast.LENGTH_SHORT).show();
                DBOperator.getInstance().execSQL(SQLCommand.JOIN_IN, this.getArgs());
                Intent intent = new Intent(sign_upActivity.this, EventAndClub.class);
                this.startActivity(intent);

            }
            else if(!pass1.equals(comfirmpass)) {
                //popup message
                Toast.makeText(sign_upActivity.this, "Pass word don't match",
                        Toast.LENGTH_SHORT).show();

            }
        }

    }


    private String[] getArgs() {
        String d_id = "";
        String s = getArgs2()[0].toString();
        Cursor cursor = DBOperator.getInstance().execQuery(SQLCommand.QUERY_7, new String[]{s});
        if (cursor.moveToFirst()){
            do{
                String data = cursor.getString(cursor.getColumnIndex("deparment_id"));
                d_id = data;
                // do what ever you want here
            }while(cursor.moveToNext());
        }
        //d_id = cursor.getString(0);
        String[] args = null;
        args = new String[8];
        args[0] = student_ID.getText().toString();
        args[1] = firstname.getText().toString();
        args[2] = lastname.getText().toString();
        args[3] = phone_number.getText().toString();
        args[4] = email.getText().toString();
        args[5] = Gender.getText().toString();
        args[6] = comfirmpassword.getText().toString();
        args[7] = d_id;
        return args;

    }
    private String[] getArgs2() {

        String[] args2 = null;
        args2 = new String[1];
        args2[0] = dspinner.getSelectedItem().toString();
        return args2;
    }
}