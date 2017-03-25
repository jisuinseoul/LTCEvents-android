package org.learnteachcode.seoul.android.ltcevents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // This gets the message from the intent that sent
        // us to this activity
        Intent originIntent = getIntent();
        String message = originIntent.getStringExtra("org.learnteachcode.seoul.android.ltcevents.message");

        // Retrieve the text view from the layout
        // and set the text of it to the message we got from the intent
        TextView textView = (TextView) findViewById(R.id.outputText);
        textView.setText(message);
    }
}
