package wpiv10.myapplication;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import wpiv10.myapplication.adapter.SlidingMenuAdapter;
//import wpiv10.myapplication.fragment.Fragment1;
import wpiv10.myapplication.constant.SQLCommand;
import wpiv10.myapplication.fragment.Fragment2;
import wpiv10.myapplication.fragment.Fragment3;
import wpiv10.myapplication.fragment.Fragment4;
import wpiv10.myapplication.model.ItemSlideMenu;
import wpiv10.myapplication.util.DBOperator;
import wpiv10.myapplication.util.Pair;
import wpiv10.myapplication.view.ChartGenerator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by NgocTri on 10/18/2015.
 */
public class MainTest extends AppCompatActivity {

    private List<ItemSlideMenu> listSliding;
    private SlidingMenuAdapter adapter;
    private ListView listViewSliding;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_test);

        //Init component
        listViewSliding = (ListView) findViewById(R.id.lv_sliding_menu);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        listSliding = new ArrayList<>();
        //Add item for sliding list
        listSliding.add(new ItemSlideMenu(R.mipmap.ic_launcher1, "Club"));
        listSliding.add(new ItemSlideMenu(R.drawable.event_type, "Event Type"));
        listSliding.add(new ItemSlideMenu(R.drawable.calendar, "Date"));
        listSliding.add(new ItemSlideMenu(R.drawable.ic_action_about, "Event Summary"));
        listSliding.add(new ItemSlideMenu(R.drawable.type_and_location, "Type & Location"));
        listSliding.add(new ItemSlideMenu(R.drawable.business_department_icon, "Return"));
        adapter = new SlidingMenuAdapter(this, listSliding);
        listViewSliding.setAdapter(adapter);

        //Display icon to open/ close sliding list
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Set title
        setTitle(listSliding.get(0).getTitle());
        //item selected
        listViewSliding.setItemChecked(0, true);
        //Close menu
        drawerLayout.closeDrawer(listViewSliding);

        //Display fragment 1 when start
        replaceFragment(0);
        //Hanlde on item click

        listViewSliding.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Set title
                setTitle(listSliding.get(position).getTitle());
//                if(position == 0){
//                    Intent intent = new Intent(MainTest.this, EventSearch.class);
//                    this.startActivity(intent);
//                }
                if (position == 3) {
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
                            "Event Held in 2016", pairList);
                    startActivity(intent);
                    Toast.makeText(MainTest.this,"You choose event summary", Toast.LENGTH_SHORT).show();
                }
                if (position == 4) {
                    Intent intent = new Intent(MainTest.this, EventSearch.class);
                    startActivity(intent);
                    Toast.makeText(MainTest.this,"You choose event type and location", Toast.LENGTH_SHORT).show();
                }
                if (position == 5) {
                    Intent intent = new Intent(MainTest.this, EventAndClub.class);
                    startActivity(intent);
                    Toast.makeText(MainTest.this,"You choose return", Toast.LENGTH_SHORT).show();
                }


                //item selected
                listViewSliding.setItemChecked(position, true);
                //Replace fragment
                replaceFragment(position);
                //Close menu
                drawerLayout.closeDrawer(listViewSliding);

            }

        });

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_opened, R.string.drawer_closed){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }
        };

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        if (item.getItemId()== R.id.menuSearch) {
            Intent intent = new Intent(MainTest.this, randomSearch.class);
            this.startActivity(intent);
            return super.onOptionsItemSelected(item);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    //Create method replace fragment

    private void replaceFragment(int pos) {
        Fragment fragment = null;
        switch (pos) {
            case 0:
                fragment = new Fragment3();
                break;
            case 1:
                fragment = new Fragment4();
                break;
            case 2:
                fragment = new Fragment2();
                break;
//            case 3:
//                fragment = new Fragment1();
//                break;
            default:
                fragment = new Fragment2();
                break;
        }

        if(null!=fragment) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.main_content, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
}
