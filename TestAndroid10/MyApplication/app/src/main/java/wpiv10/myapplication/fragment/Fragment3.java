package wpiv10.myapplication.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import wpiv10.myapplication.EventListActivity;
import wpiv10.myapplication.EventListActivity1;
import wpiv10.myapplication.EventListActivity2;
import wpiv10.myapplication.EventListActivity3;
import wpiv10.myapplication.R;
import wpiv10.myapplication.Test1;

public class Fragment3 extends Fragment {
    public Fragment3() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3, container, false);
        final String[] menuItems = {"Chess club", "Ballroom dance club", "Graduate student Government", "South Asian Student Assiciation",
                "Badminton Club", "Ballroom Dance Team (BDT)", "Beta Theta Pi Fraternity (Beta Theta Pi)", "Game Development Club (GDC)",
        "Gender Equality Club (WPI GEC)", "Genius Entrepreneurship Club (IEC)", "German Club (Deutschklub) (German Club)", "Get Involved! (Get Involved!)",
        "Ultimate Frisbee Club (Ultimate Frisbee)", "Underwater Hockey (UWH)"};
        ListView listView = (ListView) view.findViewById(R.id.listView3);

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                menuItems);

        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Toast.makeText(Fragment3.this.getActivity(),"You choose Chess club", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Fragment3.this.getActivity(), EventListActivity.class);
                    startActivity(intent);
                }
                else if (position == 1) {
                    Toast.makeText(Fragment3.this.getActivity(),"You choose Ballroom dance club", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Fragment3.this.getActivity(), EventListActivity1.class);
                    startActivity(intent);
                }
                else if (position == 2) {
                    Toast.makeText(Fragment3.this.getActivity(),"You choose Graduate student Government", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Fragment3.this.getActivity(), EventListActivity2.class);
                    startActivity(intent);
                }
                else if (position == 3) {
                    Toast.makeText(Fragment3.this.getActivity(),"You choose South Asian Student Assiciation", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Fragment3.this.getActivity(), EventListActivity3.class);
                    startActivity(intent);
                }
            }
        });
        return view;
    }
}