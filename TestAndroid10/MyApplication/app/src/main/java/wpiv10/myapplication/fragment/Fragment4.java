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
import wpiv10.myapplication.EventTypeList;
import wpiv10.myapplication.EventTypeList1;
import wpiv10.myapplication.EventTypeList2;
import wpiv10.myapplication.EventTypeList3;
import wpiv10.myapplication.R;
import wpiv10.myapplication.Test1;

public class Fragment4 extends Fragment {
    public Fragment4() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment4, container, false);
        final String[] menuItems = {"Sport", "Social", "Culture", "Art", "Game", "Creative", "Technology", "Academic", "Adventure"};
        ListView listView = (ListView) view.findViewById(R.id.listView4);

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                menuItems);

        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Toast.makeText(Fragment4.this.getActivity(),"You choose Sport", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Fragment4.this.getActivity(), EventTypeList.class);
                    startActivity(intent);
                }
                else if (position == 1) {
                    Toast.makeText(Fragment4.this.getActivity(),"You choose Social", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Fragment4.this.getActivity(),EventTypeList1.class);
                    startActivity(intent);
                }
                else if (position == 2) {
                    Toast.makeText(Fragment4.this.getActivity(),"You choose Culture", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Fragment4.this.getActivity(), EventTypeList2.class);
                    startActivity(intent);
                }
                else if (position == 3) {
                    Toast.makeText(Fragment4.this.getActivity(),"You choose Art", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Fragment4.this.getActivity(), EventTypeList3.class);
                    startActivity(intent);
                }
            }
        });
        return view;
    }
}