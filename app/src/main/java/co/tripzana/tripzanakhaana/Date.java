package co.tripzana.tripzanakhaana;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Date extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);


        TextView tt = (TextView) findViewById(R.id.textView2);
        tt.setText(getIntent().getExtras().getString("username"));
    }
}
