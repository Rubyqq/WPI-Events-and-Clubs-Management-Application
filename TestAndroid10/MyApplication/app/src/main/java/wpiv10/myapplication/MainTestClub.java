package wpiv10.myapplication;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class MainTestClub extends AppCompatActivity {

    private ListView Listview;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragmentclubtype);
        final String[] menuItems = {"Sport", "Social", "Student Association", "Art"};
        ListView Listview = (ListView) findViewById(R.id.listView2);

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                menuItems);

        Listview.setAdapter(listViewAdapter);
        Listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Toast.makeText(MainTestClub.this,"You choose Sport", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainTestClub.this, clubTypeList.class);
                    startActivity(intent);
                }
                else if (position == 1) {
                    Toast.makeText(MainTestClub.this,"You choose Social", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainTestClub.this, clubTypeList1.class);
                    startActivity(intent);
                }
                else if (position == 2) {
                    Toast.makeText(MainTestClub.this,"You choose Student Association", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainTestClub.this, clubTypeList2.class);
                    startActivity(intent);
                }
                else if (position == 3) {
                    Toast.makeText(MainTestClub.this,"You choose Art", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainTestClub.this, clubTypeList3.class);
                    startActivity(intent);
                }
            }
        });

//        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_opened, R.string.drawer_closed){
//
//            @Override
//            public void onDrawerOpened(View drawerView) {
//                super.onDrawerOpened(drawerView);
//                invalidateOptionsMenu();
//            }
//
//            @Override
//            public void onDrawerClosed(View drawerView) {
//                super.onDrawerClosed(drawerView);
//                invalidateOptionsMenu();
//            }
//        };
//
//        drawerLayout.setDrawerListener(actionBarDrawerToggle);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu1, menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

//        if(actionBarDrawerToggle.onOptionsItemSelected(item)) {
//            return true;
//        }

        if (item.getItemId()== R.id.decSearch) {
            Intent intent = new Intent(MainTestClub.this, randomSearch1.class);
            this.startActivity(intent);
            return super.onOptionsItemSelected(item);
        }
        if (item.getItemId()== R.id.decSearch1) {
            Intent intent = new Intent(MainTestClub.this, randomSearch2.class);
            this.startActivity(intent);
            return super.onOptionsItemSelected(item);
        }

        return super.onOptionsItemSelected(item);
    }
}