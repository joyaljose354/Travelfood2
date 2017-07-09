package co.tripzana.tripzanakhaana;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;
import java.util.Calendar;


public class traindetails extends AppCompatActivity{

    int year_x,month_x,day_x;
    static final int DIALOG_ID = 0 ;
    TextView text5;
    AutoCompleteTextView text;
    MultiAutoCompleteTextView text1;
    String[] languages={"Ernakulam-Patna 16359","Chennai-Trivandrum 22208","Trivandrum-Chennai 12698","Trivandrum-Mumbai 16332","Howrah-Ernakulam 22877"};
    String[] languages1={"Palakkad","Thrissur"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traindetails);

        showDialogueButtonClick();

        final Calendar cal = Calendar.getInstance();
        year_x = cal.get(Calendar.YEAR);
        month_x = cal.get(Calendar.MONTH);
        day_x = cal.get(Calendar.DAY_OF_MONTH);
        text=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);
        text1=(MultiAutoCompleteTextView)findViewById(R.id.multiAutoCompleteTextView);

        text5 = (TextView)findViewById(R.id.textView4);
      //  text.setText(dpickerListener.year_x);
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

  /*  public String getCurrentDate(){
        StringBuilder builder=new StringBuilder();
        builder.append("Current Date: ");
        builder.append((dpickerListener.getMonth() + 1)+"/");//month is 0 based
        builder.append(dpickerListener.getDayOfMonth()+"/");
        builder.append(dpickerListener.getYear());
        return builder.toString();
    }*/

    public void showDialogueButtonClick(){
        ImageView image = (ImageView) findViewById(R.id.calender);
        image.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        showDialog(DIALOG_ID);
                    }
                }
        );
    }


    @Override
    protected Dialog onCreateDialog(int id) {
        if(id==DIALOG_ID)
        {
            return new DatePickerDialog(this,dpickerListener,year_x,month_x,day_x);
        }
        return null;

    }

    final DatePickerDialog.OnDateSetListener dpickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

            year_x = year;
            String t =Integer.toString(year_x) ;
            month_x = month + 1;
            day_x = dayOfMonth;
            String u =Integer.toString(month_x) ;
            String v =Integer.toString(day_x) ;
            //Toast.makeText(traindetails.this,year_x + "/" + month_x + "/" + day_x,Toast.LENGTH_LONG).show();
            text5.setText(u+"/"+v+"/"+t);
        }
    };
   /* public void sendmessage(View view)
    {
        Intent intent= new Intent(this,Date.class);
        AutoCompleteTextView au=(AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        String message = au.getText().toString();
        intent.putExtra("co.tripzana.tripzanakhaana.MESSAGE",message);
        startActivity(intent);

    }*/
}
