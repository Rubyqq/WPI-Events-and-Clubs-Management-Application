package wpiv10.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import wpiv10.myapplication.constant.SQLCommand;
import wpiv10.myapplication.util.DBOperator;

public class EventList1 extends Activity implements OnClickListener {
    private String eventattendees;
    private TextView tv_5;
    private String name1;
    TextView studentID;
    String eventnumber;
    String data;

    private Button MakeAppointmentBtn;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventinfo);
        MakeAppointmentBtn = (Button) this.findViewById(R.id.make_appointment);
        MakeAppointmentBtn.setOnClickListener(this);
        Bundle bundle = getIntent().getExtras();
        int id = bundle.getInt("photo");
        String name = bundle.getString("name");
        String location = bundle.getString("location");
        String eventdate = bundle.getString("eventdate");
        String eventtime = bundle.getString("eventtime");
        String eventdescription = bundle.getString("eventdescription");
        eventnumber = bundle.getString("eventNumber");
        name1 = bundle.getString("name1");


        ImageView Iv = (ImageView) findViewById(R.id.img);
        Iv.setImageResource(id);
        TextView tv = (TextView) findViewById(R.id.name);
        tv.setText(name);
        TextView tv_1 = (TextView) findViewById(R.id.location);
        tv_1.setText(location);
        TextView tv_2 = (TextView) findViewById(R.id.eventdate);
        tv_2.setText(eventdate);
        TextView tv_3 = (TextView) findViewById(R.id.eventtime);
        tv_3.setText(eventtime);
        TextView tv_4 = (TextView) findViewById(R.id.eventdescription);
        tv_4.setText(eventdescription);

        Cursor cursor = DBOperator.getInstance().execQuery(SQLCommand.QUERY_9, new String[]{name1});
        if (cursor.moveToFirst()){
            do{
                eventattendees = cursor.getString(cursor.getColumnIndex("event_attendees"));
                // do what ever you want here
            }while(cursor.moveToNext());
        }

        tv_5 = (TextView) findViewById(R.id.eventattendees);
        tv_5.setText("Event Attendees:" + eventattendees);


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.make_appointment) {

            studentID = (TextView) findViewById(R.id.studentID_edittext1);
            String studentId = studentID.getText().toString();


            Cursor cursor1 = DBOperator.getInstance().execQuery(SQLCommand.QUERY_1, new String[]{studentId});
            if (cursor1.moveToFirst()){
                do{
                    data = cursor1.getString(cursor1.getColumnIndex("student_id"));
                    // do what ever you want here
                }while(cursor1.moveToNext());
            }

            if(studentId.equals(data)) {


                Cursor cursor = DBOperator.getInstance().execQuery(SQLCommand.QUERY_9, new String[]{name1});
                if (cursor.moveToFirst()) {
                    do {
                        eventattendees = cursor.getString(cursor.getColumnIndex("event_attendees"));
                        // do what ever you want here
                    } while (cursor.moveToNext());
                }

                String s = eventattendees;
                int s1 = Integer.parseInt(s);
                int s2 = s1 + 1;

                StringBuilder sb = new StringBuilder();
                sb.append(s2);
                String s3 = sb.toString();

                tv_5 = (TextView) findViewById(R.id.eventattendees);
                tv_5.setText("Event Attendees:" + s3);

                DBOperator.getInstance().execSQL(SQLCommand.REGISTER_EVENT, this.getArgs());

                Toast.makeText(EventList1.this, "Join in successful",
                        Toast.LENGTH_SHORT).show();
            }

            else{
                Toast.makeText(EventList1.this, "The student ID does not exists",
                        Toast.LENGTH_SHORT).show();
            }
        }

        Button button = (Button)findViewById(R.id.make_appointment1);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //String studentId = studentID.getText().toString();

                            Intent intent = new Intent(EventList1.this, checkEvent.class);
                            startActivity(intent);
                        }


                    }

        );

    }

    private String[] getArgs() {

        String d_id = "";
        String s = getArgs2()[0].toString();
        Cursor cursor = DBOperator.getInstance().execQuery(SQLCommand.QUERY_8, new String[]{s});
        if (cursor.moveToFirst()){
            do{
                String data = cursor.getString(cursor.getColumnIndex("student_id"));
                d_id = data;
                // do what ever you want here
            }while(cursor.moveToNext());
        }

        String[] args = null;
        args = new String[3];
        args[0] = d_id;
        args[1] = eventnumber;
        args[2] = "Yes";
        return args;

    }

    private String[] getArgs2() {

        String[] args2 = null;
        args2 = new String[1];
        args2[0] = studentID.getText().toString();
        return args2;
    }



}