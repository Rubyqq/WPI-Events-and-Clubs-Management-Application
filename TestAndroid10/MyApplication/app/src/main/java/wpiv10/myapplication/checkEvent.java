package wpiv10.myapplication;

import wpiv10.myapplication.constant.SQLCommand;
import wpiv10.myapplication.view.TableView;
import wpiv10.myapplication.util.DBOperator;
import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ScrollView;

public class checkEvent extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.for_event_registration_check);
        //copy database file
        try{
            DBOperator.copyDB(getBaseContext());
        }catch(Exception e){
            e.printStackTrace();
        }
        //implement SQL query and get cursor of resultset
        Cursor cursor = DBOperator.getInstance().execQuery(SQLCommand.FOR_SCROLLVIEW);
        TableView tableView = new TableView(this, cursor);
        //show data in tableview
        ScrollView scrollView = (ScrollView)this.findViewById(R.id.scrollView1);
        scrollView.addView(tableView);
    }
}

