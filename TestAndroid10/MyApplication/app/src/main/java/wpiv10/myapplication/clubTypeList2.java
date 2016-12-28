package wpiv10.myapplication;


import android.widget.ListView;



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
public class clubTypeList2 extends Activity {
    ListView cListView;

    //private SearchAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.club_list1);

        cListView = (ListView)findViewById(R.id.club_listview1);
        cListView.setOnItemClickListener(new ItemClickListener());
        //customAdapter = new SearchAdapter(EventListActivity.this, cursor, 0);

        String sql = SQLCommand.QUERY_18;
        Cursor cursor = DBOperator.getInstance().execQuery(sql);
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                getApplicationContext(),
                R.layout.club_item1,
                cursor,
                new String[]{"_id", "club_name", "club_chapter", "club_email"},
                new int[]{R.id.club_id1, R.id.club_name1, R.id.club_chapter1, R.id.club_email1},
                SimpleCursorAdapter.IGNORE_ITEM_VIEW_TYPE
        );
        cListView.setAdapter(adapter);

    }

    class ItemClickListener implements AdapterView.OnItemClickListener {
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Cursor cursor = (Cursor) cListView.getItemAtPosition(position);
            //String eventid = cursor.getString(0);
            String clubName = cursor.getString(1);
            String clubChapter = cursor.getString(2);
            String clubEmail = cursor.getString(3);

            Toast.makeText(getApplicationContext(),"\nClub Name: " + clubName+ "\nClub Chapter: " + clubChapter+ "\nClub Email: " + clubEmail, Toast.LENGTH_LONG).show();
            if (position == 0) {
                Intent intent = new Intent(clubTypeList2.this, gsgClub.class);
                startActivity(intent);
            }
            else if (position == 1) {
                Intent intent = new Intent(clubTypeList2.this, sasaClub.class);
                startActivity(intent);
            }

        }
    }


}
