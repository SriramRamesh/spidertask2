package com.example.android.spidersubmsn2;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity2Activity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);
        Intent intent=getIntent();
        String[] A=intent.getStringArrayExtra("Size and color");
        String Message =intent.getStringExtra("EditText");
        int Flag[]=intent.getIntArrayExtra("RadioFlags");
        TextView t=(TextView)findViewById(R.id.textView);
        t.setText(Message);
        if(Flag[0]==1&&Flag[1]==1)
        {
            t.setTypeface(null, Typeface.BOLD_ITALIC);
        }
        else
        {
            if (Flag[1]==1)
            {
                t.setTypeface(null, Typeface.ITALIC);
            }
            if(Flag[0]==1)
            {
                t.setTypeface(null, Typeface.BOLD);
            }
        }

        if(!A[0].equals("Size")) {
            int size = Integer.parseInt(A[0]);
            t.setTextSize(13 + size);
        }
        String color=A[1];
       if(color.equals("bright_pink"))
              t.setTextColor(Color.parseColor("#ee09e4"));
       else if(color.equals("red"))
                t.setTextColor(Color.RED);
       else if(color.equals("orange"))
            t.setTextColor(Color.parseColor("#ee8809"));
       else if(color.equals("yellow"))
            t.setTextColor(Color.YELLOW);
       else if(color.equals("green"))
            t.setTextColor(Color.GREEN);
       else if(color.equals("blue"))
            t.setTextColor(Color.BLUE);
       else if(color.equals("violet"))
            t.setTextColor(Color.parseColor("#7F00FF"));
       else if(color.equals("magenta"))
            t.setTextColor(Color.MAGENTA);
        else
            t.setTextColor(Color.WHITE);

        String Font=A[2];
        String loc;
        if(Font.equals("Lobster"))
            loc="Fonts/Lobster.otf";
        else if(Font.equals("Great Vibes"))
            loc="Fonts/GreatVibes-Regular.otf";
        else if(Font.equals("Open Sans"))
            loc="Fonts/OpenSans-Light.ttf";
        else if(Font.equals("Chunk Five"))
            loc="Fonts/Chunkfive.otf";
        else if(Font.equals("Alex Brush"))
            loc="Fonts/AlexBrush-Regular.ttf";
        else if(Font.equals("Good Dog"))
            loc="Fonts/GoodDog.otf";
        else if(Font.equals("Quick Sand"))
            loc="Fonts/Quicksand-Light.otf";
        else
            loc="None";
        if(!loc.equals("None")) {
            Typeface type = Typeface.createFromAsset(getAssets(),loc);
            t.setTypeface(type);
        }
}
    public void GotoMainActivity(View v)
    {
        Intent in=new Intent(MainActivity2Activity.this,MainActivity.class);
        startActivity(in);
    }
    public void ExitApp(View v)
    {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
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
}
