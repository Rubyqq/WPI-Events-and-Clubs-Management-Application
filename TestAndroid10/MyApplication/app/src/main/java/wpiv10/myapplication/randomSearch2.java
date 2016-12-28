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


public class randomSearch2 extends AppCompatActivity {

    private ListView listView;
    private final static String TAG= EventSearch.class.getName().toString();
    Cursor cursor;
    private SearchAdapter customAdapter;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.club_searchr);

        customAdapter = new SearchAdapter(randomSearch2.this,  cursor, 0);
        listView = (ListView) this.findViewById(R.id.show_listviewrs);
        listView.setAdapter(customAdapter);

        if(cursor==null) insertDummy();

    }

    private void insertDummy(){
        cursor=DBOperator.getInstance().execQuery(SQLCommand.QUERY_14);
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getApplicationContext(), R.layout.club_searchin,
                cursor, new String[]{"_id", "club_name"},
                new int[]{R.id.clubidrs, R.id.clubNamers},
                SimpleCursorAdapter.IGNORE_ITEM_VIEW_TYPE);
        listView.setAdapter(adapter);
    }



    public void onResume(){
        super.onResume();

    }

    @Override
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.options_menu, menu);


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            SearchManager manager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
            SearchView search = (SearchView) menu.findItem(R.id.search).getActionView();
            search.setSearchableInfo(manager.getSearchableInfo(getComponentName()));

            search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

                @Override
                public boolean onQueryTextSubmit(String s) {
                    Log.d(TAG, "onQueryTextSubmit ");
                    cursor=DBOperator.getInstance().execQuery(SQLCommand.QUERY_15, new String[]{s});
                    SimpleCursorAdapter adapter = new SimpleCursorAdapter(getApplicationContext(), R.layout.club_searchin,
                            cursor, new String[]{"_id", "club_name"},
                            new int[]{R.id.clubidrs, R.id.clubNamers},
                            SimpleCursorAdapter.IGNORE_ITEM_VIEW_TYPE);
                    listView.setAdapter(adapter);

                    if (cursor!=null){
                        customAdapter.swapCursor(cursor);
                    }
                    if (cursor==null){
                        Toast.makeText(randomSearch2.this,"No records found!",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(randomSearch2.this, cursor.getCount() + " records found!",Toast.LENGTH_LONG).show();
                    }
                    customAdapter.swapCursor(cursor);


                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    Log.d(TAG, "onQueryTextChange ");
                    cursor=DBOperator.getInstance().execQuery(SQLCommand.QUERY_14);
                    SimpleCursorAdapter adapter = new SimpleCursorAdapter(getApplicationContext(), R.layout.club_searchin,
                            cursor, new String[]{"_id", "club_name"},
                            new int[]{R.id.clubidrs, R.id.clubNamers},
                            SimpleCursorAdapter.IGNORE_ITEM_VIEW_TYPE);
                    listView.setAdapter(adapter);
//                    if (cursor == null) {
//                        return true;
//                    } else if (!cursor.moveToFirst()) {
//                        cursor.close();
//                        return true;
//                    }
                    if (cursor!=null){
                        customAdapter.swapCursor(cursor);
                    }
                    return false;
                }

            });

        }

        return true;

    }

}

