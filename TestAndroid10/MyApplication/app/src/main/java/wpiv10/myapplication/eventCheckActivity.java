/*package wpiv10.myapplication;

import wpiv10.myapplication.constant.SQLCommand;
import wpiv10.myapplication.util.DBOperator;
import wpiv10.myapplication.util.Pair;
import wpiv10.myapplication.view.ChartGenerator;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class eventCheckActivity extends AppCompatActivity implements OnClickListener {

    EditText stuIdEdit, eventIdEdit;
    DatePicker datePicker;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_event_ac);
        stuIdEdit = (EditText) this.findViewById(R.id.studentID_edittext);
        eventIdEdit = (EditText) this.findViewById(R.id.EventID_edittext);
        datePicker = (DatePicker) this.findViewById(R.id.datePicker1);

        Button backBtn = (Button) this.findViewById(R.id.summary_btn);
        backBtn.setOnClickListener(this);
        Button checkoutBtn = (Button) this.findViewById(R.id.checkout_btn);
        checkoutBtn.setOnClickListener(this);
        Button returnBtn = (Button) this.findViewById(R.id.return_btn);
        returnBtn.setOnClickListener(this);

        Button summaryBtn = (Button) this.findViewById(R.id.summary_btn);
        summaryBtn.setOnClickListener(this);
    }

    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.checkout_btn) {

            DBOperator.getInstance().execSQL(SQLCommand.REGISTER_EVENT,
                    this.getArgs(true));
            Toast.makeText(getBaseContext(), "Checkout successfully",
                    Toast.LENGTH_SHORT).show();
        } else if (id == R.id.return_btn) {

            DBOperator.getInstance().execSQL(SQLCommand.CHECK_EVENT,
                    this.getArgs(false));
            Toast.makeText(getBaseContext(), "Return successfully",
                    Toast.LENGTH_SHORT).show();
        } else if (id == R.id.back_to_main_page_btn) {

            Intent intent = new Intent(this, MainActivity.class);
            this.startActivity(intent);
        } else if (id == R.id.summary_btn) {

            Cursor cursor = DBOperator.getInstance().execQuery(
                    SQLCommand.CHECKOUT_SUMMARY);
            List<Pair> pairList = new LinkedList<Pair>();
            for (int i = 1; i <= 12; i++) {
                Pair pair = new Pair(i, 0);
                pairList.add(pair);
            }
            while (cursor.moveToNext()) {
                int location = Integer.parseInt(cursor.getString(0));
                pairList.get(location - 1).setNumber(
                        Double.parseDouble(cursor.getString(1)));
            }
            Intent intent = ChartGenerator.getBarChart(getBaseContext(),
                    "Checkout Summary in 2016", pairList);
            this.startActivity(intent);
        }
    }*.

    /**
     * Get input data including studentID, book callnum, date and returned state
     *
     * @param isCheck
     * @return
     */
/*    private String[] getArgs(boolean isCheck) {

        String d_id = "";
        String e_id = "";
        String s = getArgs2()[0].toString();
        String s1 = getArgs3()[0].toString();
        Cursor cursor = DBOperator.getInstance().execQuery(SQLCommand.QUERY_8, new String[]{s});
        Cursor cursor1 = DBOperator.getInstance().execQuery(SQLCommand.QUERY_9, new String[]{s});
        if (cursor.moveToFirst()){
            do{
                String data = cursor.getString(cursor.getColumnIndex("student_id"));
                d_id = data;
                // do what ever you want here
            }while(cursor.moveToNext());
        }

        if (cursor1.moveToFirst()){
            do{
                String data1 = cursor1.getString(cursor.getColumnIndex("event_id"));
                e_id = data1;
                // do what ever you want here
            }while(cursor.moveToNext());
        }
        String[] args = null;
        if (isCheck) {
            args = new String[4];
            // stid
            args[0] = d_id;
            // callnum
            args[1] = e_id;
            // date
            int year = datePicker.getYear();
            int month = datePicker.getMonth();
            int day = datePicker.getDayOfMonth();
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month, day);
            // format the date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            args[2] = dateFormat.format(calendar.getTime());

            args[3] = "N";
        } else {
            args = new String[3];
            args[0] = "Y";
            args[1] = d_id;
            args[2] = e_id;
        }
        return args;
    }
    private String[] getArgs2() {
        String[] args2 = null;
        args2 = new String[1];
        args2[0] = stuIdEdit.getText().toString();
        return args2;
    }
    private String[] getArgs3() {
        String[] args3 = null;
        args3 = new String[1];
        args3[0] = eventIdEdit.getText().toString();
        return args3;
    }
}*/
