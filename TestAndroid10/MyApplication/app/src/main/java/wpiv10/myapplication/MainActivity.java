package wpiv10.myapplication;


import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import wpiv10.myapplication.util.DBOperator;
import wpiv10.myapplication.constant.SQLCommand;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    private static EditText userid;
    private static EditText password1;
    private static Button loginBtn;
    private static TextView signupwords;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userid = (EditText) this.findViewById(R.id.studentId);
        password1 = (EditText) this.findViewById(R.id.passworda);
        loginBtn = (Button) this.findViewById(R.id.login_button);
        loginBtn.setOnClickListener(this);
        SignUpButton();

    }


    public void SignUpButton() {
        signupwords = (TextView) findViewById(R.id.signupwords);

        signupwords.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, sign_upActivity.class);
                        startActivity(intent);

                    }
                }
        );
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.login_button) {
            String usernameid = userid.getText().toString();
            String password = password1.getText().toString();
            if (usernameid.length() ==0  || password.length() ==0) {
                Toast.makeText(MainActivity.this, "username or password can not be null", Toast.LENGTH_SHORT).show();
            }
            else {
                Cursor cursor = DBOperator.getInstance().execQuery(SQLCommand.QUERY_2, new String[]{usernameid});
                if (cursor.getCount() > 0) {
                    Cursor pwdcursor = DBOperator.getInstance().execQuery(SQLCommand.QUERY_3, new String[]{usernameid, password});
                    if (pwdcursor.getCount() > 0) {
                        Toast.makeText(getBaseContext(),"login successfully",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(this, EventAndClub.class);
                        this.startActivity(intent);
                    }
                    else {
                        Toast.makeText(getBaseContext(),"password is wrong!",Toast.LENGTH_SHORT).show();

                    }
                }
                else {
                    Toast.makeText(getBaseContext(),"fail",Toast.LENGTH_SHORT).show();
                }
            }

        }
    }
}