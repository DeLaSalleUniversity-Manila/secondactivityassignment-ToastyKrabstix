package com.example.giggy.weekdaysecondscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.*;
import android.widget.*;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private EditText Monthtxt;
    private EditText daytxt;
    private EditText yeartxt;
    private TextView tv;
    int i,m,d,y,c,a;
    public void GrabInputs(){
        Monthtxt = (EditText) findViewById(R.id.monthtxt);
        String mon = Monthtxt.getText().toString();
        m = Integer.parseInt(mon);

        daytxt = (EditText) findViewById(R.id.Datetxt);
        String day = daytxt.getText().toString();
        d = Integer.parseInt(day);

        yeartxt = (EditText) findViewById(R.id.Yeartxt);
        String year = yeartxt.getText().toString();
        a = Integer.parseInt(year);

        if(m == 1){
            m = 13;
        }else if (m==2){
            m = 14;
        }
        c = (int)(a * 0.01);
        y = (a - (c*100));
    }


    public void ConfirmbuttonOnClick(View v){

        GrabInputs();
        int q;
        q = (d + (((26*(m+1))/10)) + y + (y/4) + (c/4)+(5*c))%7;
        String z = "";
        switch(q){
            case 0: z = "Saturday"; break;
            case 1: z = "Sunday"; break;
            case 2: z = "Monday"; break;
            case 3:  z = "Tuesday"; break;
            case 4: z = "Wednesday";  break;
            case 5: z = "Thursday";  break;
            case 6:  z = "Friday"; break;
        }
        String t =  m +"/"+ d +"/"+ a + " is: " + z;
        Intent i = new Intent(this, Main2Activity.class);

        // Put attachment data along with the intent
        i.putExtra("message", t);

        startActivity(i);

    }
}
