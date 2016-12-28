package wpiv10.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EventAndClub extends AppCompatActivity {
    private static Button Events_button, Clubs_button;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_and_club);
        eventActivity();
        clubActivity();
    }
    public void eventActivity() {
        Events_button = (Button)findViewById(R.id.Events_btn);

        Events_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(EventAndClub.this, MainTest.class);
                        startActivity(intent);

                    }
                }
        );
    }
    public void clubActivity() {
        Clubs_button = (Button)findViewById(R.id.Clubs_btn);

        Clubs_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(EventAndClub.this, MainTestClub.class);
                        startActivity(intent);

                    }
                }
        );
    }


}