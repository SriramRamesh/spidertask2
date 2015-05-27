package com.example.android.spidersubmsn2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
  public static String[] A =new String[3];
    public static int Flag[]=new int[3];
  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText t=(EditText)findViewById(R.id.editText);
        t.setText("Enter Text");
        String[] Size=new String[35];
        Size[0]="Size";
        for(int i=1;i<=30;i++)
            Size[i]=Integer.toString(i);
      Spinner s1=(Spinner)findViewById(R.id.Spinner);
      Spinner s3=(Spinner)findViewById(R.id.Spinner3);
      String Fonts[]={"Lobster","Great Vibes","Open Sans","Chunk Five","Alex Brush","Good Dog","Quick Sand"};
      ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,Size);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        s1.setAdapter(adapter);
      ArrayAdapter<String> adapter2=new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,Fonts);
      adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
      s3.setAdapter(adapter2);
  }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public void RadioOnClick1(View view)
      {
          Flag[0]=1;


      }
    public void RadioOnClick2(View view)
    {
        Flag[1]=1;


    }
    public String getTEXT()
    {
        EditText e=(EditText)findViewById(R.id.editText);
        String S=e.getText().toString();
        if(S.equals("Enter Text")) {
          Toast t=Toast.makeText(getApplicationContext(), "Please enter text", Toast.LENGTH_LONG);
            t.show();
        }
            return S;
    }

    public void Message(View v)
    {
        //Saving EditText to a String S
        String S=getTEXT();
        if(S.equals("Enter Text"))
            return ;

        //Declaring Spinners for size and color
        Spinner s1=(Spinner)findViewById(R.id.Spinner);
        Spinner s2=(Spinner)findViewById(R.id.Spinner2);
        Spinner s3=(Spinner)findViewById(R.id.Spinner3);
        A[0]=s1.getSelectedItem().toString();
        A[1]=s2.getSelectedItem().toString();
        A[2]=s3.getSelectedItem().toString();
        Intent intent=new Intent(MainActivity.this,MainActivity2Activity.class);
        intent.putExtra("EditText",S).putExtra("RadioFlags",Flag).putExtra("Size and color",A);
        startActivity(intent);
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
