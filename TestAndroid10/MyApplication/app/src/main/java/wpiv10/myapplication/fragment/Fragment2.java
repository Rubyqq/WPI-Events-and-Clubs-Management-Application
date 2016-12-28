package wpiv10.myapplication.fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import wpiv10.myapplication.DateDialog;
import wpiv10.myapplication.EventList1;
import wpiv10.myapplication.EventListActivity;
import wpiv10.myapplication.EventListActivity1;
import wpiv10.myapplication.EventListActivity2;
import wpiv10.myapplication.EventListActivity3;
import wpiv10.myapplication.R;
import wpiv10.myapplication.Test1;
import wpiv10.myapplication.constant.SQLCommand;
import wpiv10.myapplication.joinInActivity;
import wpiv10.myapplication.util.DBOperator;
import wpiv10.myapplication.view.TableView;

public class Fragment2 extends Fragment {
    private View rootview;
    private EditText txtDate;
    private ListView listView;

    public Fragment2() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment2, container, false);

        txtDate = (EditText) rootview.findViewById(R.id.txtdate);
        //listView = (ListView) rootview.findViewById(R.id.show_listview_f2);

        setUpViews();
        setUpViews1();

        final String[] menuItems = {"chess   2016-11-05 23:00:00   gym",
                "Dance   2016-11-04 06:00:00   gym", "Food Tasting   2016-11-05 08:00:00   cc", "Quiz   2016-11-06 07:00:00   cc",
                "Diya   2016-12-09 07:00:00   wb"};
        listView = (ListView) rootview.findViewById(R.id.checkout_listview21);

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                menuItems);

        listView.setAdapter(listViewAdapter);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if (position == 0) {
//                    Intent intent = new Intent(Fragment2.this.getActivity(), Test1.class);
//                    startActivity(intent);
//                }
//
//            }
//        });
        return rootview;
    }


    private void setUpViews() {
        rootview.findViewById(R.id.txtdate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                if (id == R.id.txtdate) {
                    DateDialog dialog = new DateDialog(v);
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    dialog.show(ft, "DatePicker");

                }
            }
        });
    }
    private void setUpViews1() {
        rootview.findViewById(R.id.OK_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                String txtdate1;
                if (id == R.id.OK_button && txtDate.getText().toString().length() != 0) {

                    txtdate1 = txtDate.getText().toString();
                    Bundle bundle = new Bundle();
                    bundle.putString("date",txtdate1);
                    bundle.putString("date1","The date you choose is: "+txtdate1);
                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    intent.setClass(Fragment2.this.getActivity(), joinInActivity.class);
                    startActivity(intent);

                }
                else if(txtDate.getText().toString().length() == 0){
                    Toast.makeText(Fragment2.this.getActivity(), "Date can not be null", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}



