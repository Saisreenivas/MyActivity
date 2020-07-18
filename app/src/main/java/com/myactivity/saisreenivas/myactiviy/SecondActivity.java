package com.myactivity.saisreenivas.myactiviy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView textView;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = (TextView) findViewById(R.id.textView);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String extra = extras.getString("activityOne");
            textView.setText(extra);
        }

        backButton = (Button) findViewById(R.id.button2);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent returnIntent = getIntent();
                returnIntent.putExtra("returnData", "I am from the Second Activity");
                returnIntent.putExtra("somethingElse", "I am something else");
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }
}
