package wpiv10.myapplication;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import wpiv10.myapplication.constant.SQLCommand;
import wpiv10.myapplication.util.DBOperator;


public class EventSearch extends AppCompatActivity implements View.OnClickListener {
    Button searchButton;
    android.widget.Spinner Spinner;
    android.widget.Spinner Spinner1;
    private ListView listView;
    String eventattendees;
//    private final static String TAG= EventSearch.class.getName().toString();
//    Cursor cursor;
//    private SearchAdapter customAdapter;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_search);
        searchButton = (Button) this.findViewById(R.id.search_button2);
        searchButton.setOnClickListener(this);
        Spinner = (Spinner) this.findViewById(R.id.spinner2);
        Spinner1 = (Spinner) this.findViewById(R.id.spinner3);
        //customAdapter = new SearchAdapter(EventSearch.this,  cursor, 0);
        listView = (ListView) this.findViewById(R.id.show_listview);
        //listView.setAdapter(customAdapter);

         final int[] photo = new int[]{R.drawable.images, R.drawable.calendar, R.drawable.wpi_logo,R.drawable.wpi_whitelogo,R.drawable.worcester_polytechnic_institute3,
                 R.drawable.worcester_polytechnic_institute3, R.drawable.worcester_polytechnic_institute3,R.drawable.worcester_polytechnic_institute3};

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

                Cursor cursor = (Cursor) listView.getItemAtPosition(arg2);
                String event_number = cursor.getString(0);
                int number = Integer.parseInt(event_number);
                String name = cursor.getString(1);
                String eventdate = cursor.getString(2);
                String eventtime = cursor.getString(3);
                String location = cursor.getString(4);
                String eventdescription = cursor.getString(5);
                String eventattendees = cursor.getString(6);
                Bundle bundle = new Bundle();
                bundle.putString("eventNumber",event_number);
                bundle.putString("name","Name:"+name);
                bundle.putString("location","Location:"+location);
                bundle.putString("eventdate","Event Date:"+eventdate);
                bundle.putString("eventtime","Event Time:"+eventtime);
                bundle.putString("eventdescription","Event Description:"+eventdescription);
                bundle.putString("eventattendees","Event Attendees:"+eventattendees);
                bundle.putString("name1",name);

                bundle.putInt("photo", photo[number-1]);
                Intent intent = new Intent();
                intent.putExtras(bundle);
                intent.setClass(EventSearch.this, EventList1.class);
                startActivity(intent);
            }
        });
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }

    @Override
    public void onClick(View v) {
        String sql = "";
        int id = v.getId();

        if (id == R.id.search_button2) {
            // int position = Spinner.getSelectedItemPosition();
            String EventLocation = Spinner1.getSelectedItem().toString();
            String EventType = Spinner.getSelectedItem().toString();
            sql = SQLCommand.QUERY_6;
            String[] selectionArgs = {"%" + EventLocation + "%", "%" + EventType + "%"};
            Cursor cursor = DBOperator.getInstance().execQuery(sql, selectionArgs);
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(getApplicationContext(), R.layout.list_event_item,
                    cursor, new String[]{"_id", "event_name", "event_date", "event_time", "event_location", "event_desc","event_attendees"},
                    new int[]{R.id.Eventid, R.id.EventName,R.id.EventDate, R.id.EventTime, R.id.EventLocaion, R.id.EventDesc, R.id.EventAttendee},
                    SimpleCursorAdapter.IGNORE_ITEM_VIEW_TYPE);
            listView.setAdapter(adapter);

        }
    }

//    public void onResume(){
//        super.onResume();
//
//    }
//
//    @Override
//    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//        getMenuInflater().inflate(R.menu.options_menu, menu);
//
//
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
//            SearchManager manager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//            SearchView search = (SearchView) menu.findItem(R.id.search).getActionView();
//            search.setSearchableInfo(manager.getSearchableInfo(getComponentName()));
//
//            search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//
//                @Override
//                public boolean onQueryTextSubmit(String s) {
//                    Log.d(TAG, "onQueryTextSubmit ");
//                    cursor=DBOperator.getInstance().execQuery(SQLCommand.QUERY_10, new String[]{s});
//                    if (cursor==null){
//                        Toast.makeText(EventSearch.this,"No records found!",Toast.LENGTH_LONG).show();
//                    }else{
//                        Toast.makeText(EventSearch.this, cursor.getCount() + " records found!",Toast.LENGTH_LONG).show();
//                    }
//                    customAdapter.swapCursor(cursor);
//
//                    return false;
//                }
//
//                @Override
//                public boolean onQueryTextChange(String s) {
//                    Log.d(TAG, "onQueryTextChange ");
//                    cursor=DBOperator.getInstance().execQuery(SQLCommand.QUERY_10, new String[]{s});
//                    if (cursor!=null){
//                        customAdapter.swapCursor(cursor);
//                    }
//                    return false;
//                }
//
//            });
//
//        }
//
//        return true;
//
//    }

//    @Override
//    public void onClick(View v) {
//        String sql = "";
//        int id = v.getId();
//
//        if (id == R.id.search_button2) {
//            // int position = Spinner.getSelectedItemPosition();
//            String EventLocation = Spinner1.getSelectedItem().toString();
//            String EventType = Spinner.getSelectedItem().toString();
//            sql = SQLCommand.QUERY_6;
//            String[] selectionArgs = {"%" + EventLocation + "%", "%" + EventType + "%"};
//            Cursor cursor = DBOperator.getInstance().execQuery(sql, selectionArgs);
//            SimpleCursorAdapter adapter = new SimpleCursorAdapter(getApplicationContext(), R.layout.list_event_item,
//                    cursor, new String[]{"_id", "event_name", "event_date", "event_time", "event_location", "event_desc","event_attendees"},
//                    new int[]{R.id.Eventid, R.id.EventName,R.id.EventDate, R.id.EventTime, R.id.EventLocaion, R.id.EventDesc, R.id.EventAttendee},
//                    SimpleCursorAdapter.IGNORE_ITEM_VIEW_TYPE);
//            listView.setAdapter(adapter);
//
//        }
//    }
}

