package wpiv10.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Toast;

import wpiv10.myapplication.constant.SQLCommand;
import wpiv10.myapplication.util.DBOperator;
import wpiv10.myapplication.view.TableView;

/**
 * Created by Mengyi on 11/12/2016.
 */
public class eventBowling extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_bowling);


    }
}
