package wpiv10.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import junit.framework.Test;

import wpiv10.myapplication.constant.SQLCommand;
import wpiv10.myapplication.util.DBOperator;

/**
 * Created by Mengyi on 11/14/2016.
 */
public class EventListActivity2 extends Activity {
    ListView evtListView2;

    //private SearchAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_list_test2);

        evtListView2 = (ListView)findViewById(R.id.checkout_listview2);
        evtListView2.setOnItemClickListener(new ItemClickListener());
        //customAdapter = new SearchAdapter(EventListActivity.this, cursor, 0);

        String sql = SQLCommand.CHECKOUT_LIST_Club_two;
        Cursor cursor = DBOperator.getInstance().execQuery(sql);

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                getApplicationContext(),
                R.layout.list_item_test2,
                cursor,
                new String[]{"_id", "event_name", "event_date", "event_time", "event_location"},
                new int[]{R.id.event_id2, R.id.event_name2, R.id.event_date2, R.id.event_time2, R.id.event_location2},
                SimpleCursorAdapter.IGNORE_ITEM_VIEW_TYPE
        );
        evtListView2.setAdapter(adapter);

    }

    class ItemClickListener implements AdapterView.OnItemClickListener {
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Cursor cursor = (Cursor) evtListView2.getItemAtPosition(position);
            //String eventid = cursor.getString(0);
            String eventName = cursor.getString(1);
            String evnetdate = cursor.getString(2);
            String evnettime = cursor.getString(3);
            String eventLocation = cursor.getString(4);
            Toast.makeText(getApplicationContext(),"\nEvent Name: " + eventName+ "\nEvent Date: " + evnetdate+ "\nEvent Time: " + evnettime+ "\nEvent Location: " + eventLocation, Toast.LENGTH_LONG).show();
            if (position == 0) {
                Intent intent = new Intent(EventListActivity2.this, chessEventPage.class);
                startActivity(intent);
            }
            else if (position == 1) {
                Intent intent = new Intent(EventListActivity2.this, ballRoomDanceEvent.class);
                startActivity(intent);
            }
            else if (position == 2) {
                Intent intent = new Intent(EventListActivity2.this, eventQuiz.class);
                startActivity(intent);
            }
            else if (position == 3) {
                Intent intent = new Intent(EventListActivity2.this, eventBowling.class);
                startActivity(intent);
            }
            else if (position == 4) {
                Intent intent = new Intent(EventListActivity2.this, eventMovieShowTime.class);
                startActivity(intent);
            }
            else if (position == 5) {
                Intent intent = new Intent(EventListActivity2.this, eventMiddleWeekSocial.class);
                startActivity(intent);
            }
        }
    }


}
