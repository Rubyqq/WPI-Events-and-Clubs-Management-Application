/*package wpiv6.myapplication.fragment;

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

import wpiv6.myapplication.EventListActivity;
import wpiv6.myapplication.R;
import wpiv6.myapplication.Test1;

public class Fragment1 extends Fragment {
    public Fragment1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);
        final String[] menuItems = {"Mathmatics", "Business", "Chemical Engineering", "Computer Science", "Fire Protection Engineering"};
        ListView listView = (ListView) view.findViewById(R.id.listView1);

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                menuItems);

        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Toast.makeText(Fragment1.this.getActivity(),"You choose Mathmatics", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Fragment1.this.getActivity(), EventListActivity.class);
                    startActivity(intent);
                }
                else if (position == 1) {
                    Toast.makeText(Fragment1.this.getActivity(),"You choose Business", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Fragment1.this.getActivity(), Test1.class);
                    startActivity(intent);
                }
                else if (position == 2) {
                    Toast.makeText(Fragment1.this.getActivity(),"You choose Chemical Engineering", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Fragment1.this.getActivity(), Test1.class);
                    startActivity(intent);
                }
                else if (position == 3) {
                    Toast.makeText(Fragment1.this.getActivity(),"You choose Computer Science", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Fragment1.this.getActivity(), Test1.class);
                    startActivity(intent);
                }
                else if (position == 4) {
                    Toast.makeText(Fragment1.this.getActivity(),"You choose Fire Protection Engineering", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Fragment1.this.getActivity(), Test1.class);
                    startActivity(intent);
                }
            }
        });
        return view;
    }
}*/