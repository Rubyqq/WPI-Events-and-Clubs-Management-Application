package wpiv10.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import wpiv10.myapplication.constant.SQLCommand;
import wpiv10.myapplication.util.DBOperator;
import wpiv10.myapplication.view.TableView;

/**
 * Created by Mengyi on 11/12/2016.
 */
public class joinInActivity extends Activity {

    ListView evtListViewj;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join_in_ac);
        evtListViewj = (ListView)findViewById(R.id.joinin_listview1);
        //evtListViewj.setOnItemClickListener(new ItemClickListener());

        Bundle bundle = getIntent().getExtras();

        String eventdate = bundle.getString("date");
        String eventdate1 = bundle.getString("date1");
        TextView tv_5 = (TextView) findViewById(R.id.eventdate1);
        tv_5.setText(eventdate1);

        if(eventdate.equals("2016-11-06")) {
            String sql = SQLCommand.CHOOSE_DATE_EVENT_two;
            //String[] selectionArgs = {"%" + eventdate + "%"};
            Cursor cursor = DBOperator.getInstance().execQuery(sql);
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(getApplicationContext(), R.layout.list_join_in_ac,
                    cursor, new String[]{"_id", "event_name", "event_date", "event_time", "event_location", "event_desc", "event_attendees"},
                    new int[]{R.id.Eventid, R.id.EventNamej, R.id.EventDatej, R.id.EventTimej, R.id.EventLocaionj, R.id.EventDescj, R.id.EventAttendeej},
                    SimpleCursorAdapter.IGNORE_ITEM_VIEW_TYPE);
            evtListViewj.setAdapter(adapter);
        }
        if(eventdate.equals("2016-11-05")) {
            String sql = SQLCommand.CHOOSE_DATE_EVENT;
            Cursor cursor = DBOperator.getInstance().execQuery(sql);
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(getApplicationContext(), R.layout.list_join_in_ac,
                    cursor, new String[]{"_id", "event_name", "event_date", "event_time", "event_location", "event_desc", "event_attendees"},
                    new int[]{R.id.Eventid, R.id.EventNamej, R.id.EventDatej, R.id.EventTimej, R.id.EventLocaionj, R.id.EventDescj, R.id.EventAttendeej},
                    SimpleCursorAdapter.IGNORE_ITEM_VIEW_TYPE);
            evtListViewj.setAdapter(adapter);
        }
        if(eventdate.equals("2016-11-04")) {
            String sql = SQLCommand.CHOOSE_DATE_EVENT_one;
            Cursor cursor = DBOperator.getInstance().execQuery(sql);
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(getApplicationContext(), R.layout.list_join_in_ac,
                    cursor, new String[]{"_id", "event_name", "event_date", "event_time", "event_location", "event_desc", "event_attendees"},
                    new int[]{R.id.Eventid, R.id.EventNamej, R.id.EventDatej, R.id.EventTimej, R.id.EventLocaionj, R.id.EventDescj, R.id.EventAttendeej},
                    SimpleCursorAdapter.IGNORE_ITEM_VIEW_TYPE);
            evtListViewj.setAdapter(adapter);
        }
        if(eventdate.equals("2016-12-06")) {
            String sql = SQLCommand.CHOOSE_DATE_EVENT_four;
            Cursor cursor = DBOperator.getInstance().execQuery(sql);
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(getApplicationContext(), R.layout.list_join_in_ac,
                    cursor, new String[]{"_id", "event_name", "event_date", "event_time", "event_location", "event_desc", "event_attendees"},
                    new int[]{R.id.Eventid, R.id.EventNamej, R.id.EventDatej, R.id.EventTimej, R.id.EventLocaionj, R.id.EventDescj, R.id.EventAttendeej},
                    SimpleCursorAdapter.IGNORE_ITEM_VIEW_TYPE);
            evtListViewj.setAdapter(adapter);
        }
        if(eventdate.equals("2016-12-09")) {
            String sql = SQLCommand.CHOOSE_DATE_EVENT_three;
            Cursor cursor = DBOperator.getInstance().execQuery(sql);
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(getApplicationContext(), R.layout.list_join_in_ac,
                    cursor, new String[]{"_id", "event_name", "event_date", "event_time", "event_location", "event_desc", "event_attendees"},
                    new int[]{R.id.Eventid, R.id.EventNamej, R.id.EventDatej, R.id.EventTimej, R.id.EventLocaionj, R.id.EventDescj, R.id.EventAttendeej},
                    SimpleCursorAdapter.IGNORE_ITEM_VIEW_TYPE);
            evtListViewj.setAdapter(adapter);
        }
        if(eventdate.equals("2016-12-09")) {
            String sql = SQLCommand.CHOOSE_DATE_EVENT_three;
            Cursor cursor = DBOperator.getInstance().execQuery(sql);
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(getApplicationContext(), R.layout.list_join_in_ac,
                    cursor, new String[]{"_id", "event_name", "event_date", "event_time", "event_location", "event_desc", "event_attendees"},
                    new int[]{R.id.Eventid, R.id.EventNamej, R.id.EventDatej, R.id.EventTimej, R.id.EventLocaionj, R.id.EventDescj, R.id.EventAttendeej},
                    SimpleCursorAdapter.IGNORE_ITEM_VIEW_TYPE);
            evtListViewj.setAdapter(adapter);
        }
        if(eventdate.equals("2016-12-13")) {
            String sql = SQLCommand.CHOOSE_DATE_EVENT_five;
            Cursor cursor = DBOperator.getInstance().execQuery(sql);
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(getApplicationContext(), R.layout.list_join_in_ac,
                    cursor, new String[]{"_id", "event_name", "event_date", "event_time", "event_location", "event_desc", "event_attendees"},
                    new int[]{R.id.Eventid, R.id.EventNamej, R.id.EventDatej, R.id.EventTimej, R.id.EventLocaionj, R.id.EventDescj, R.id.EventAttendeej},
                    SimpleCursorAdapter.IGNORE_ITEM_VIEW_TYPE);
            evtListViewj.setAdapter(adapter);
        }



    }
}

