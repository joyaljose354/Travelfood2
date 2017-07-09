package co.tripzana.tripzanakhaana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;

import android.os.Bundle;
import android.os.Environment;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;
import java.io.IOException;


public class traindetails extends AppCompatActivity {
    AutoCompleteTextView text;
    MultiAutoCompleteTextView text1;
    String[] languages={"Ernakulam-Patna 16359","Chennai-Trivandrum 22208","Trivandrum-Chennai 12698","Trivandrum-Mumbai 16332","Howrah-Ernakulam 22877"};
    String[] languages1={"Palakkad","Thrissur"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traindetails);


        text=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);
        text1=(MultiAutoCompleteTextView)findViewById(R.id.multiAutoCompleteTextView);


        ArrayAdapter adapter = new
                ArrayAdapter(this,android.R.layout.simple_list_item_1,languages);
        ArrayAdapter adapter1 = new
             ArrayAdapter(this,android.R.layout.simple_list_item_1,languages1);



        text.setAdapter(adapter);
        text.setThreshold(1);


        text1.setAdapter(adapter1);
        text1.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        final AutoCompleteTextView au = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);
        Button next = (Button) findViewById(R.id.button4);
        next.setOnClickListener(new View.OnClickListener(){

        public void onClick(View view)
        {
            Intent intent = new Intent(traindetails.this,Date.class);
            intent.putExtra("username",au.getText().toString());
            startActivity(intent);
        }


        });


    }
   /* public void sendmessage(View view)
    {
        Intent intent= new Intent(this,Date.class);
        AutoCompleteTextView au=(AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        String message = au.getText().toString();
        intent.putExtra("co.tripzana.tripzanakhaana.MESSAGE",message);
        startActivity(intent);

    }*/
}
