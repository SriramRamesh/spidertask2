package com.example.android.spidersubmsn2;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;


public class MainActivity extends ActionBarActivity {
  public static String[] A =new String[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] Size=new String[35];
        Size[0]="Size";
        for(int i=1;i<=30;i++)
            Size[i]=Integer.toString(i);
        Spinner s1=(Spinner)findViewById(R.id.Spinner);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,Size);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        s1.setAdapter(adapter);
     }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public static int Flag[]=new int[3];

    public void RadioOnClick(View view)
      {
          boolean checked=((RadioButton)view).isChecked();
          switch(view.getId())
          {
              case R.id.radioButton:
                   if(checked)
                       Flag[0]=1;
                  else
                       Flag[0]=0;
                   break;
              case R.id.radioButton2:
                  if(checked)
                      Flag[1]=1;
                  else
                      Flag[1]=0;
                  break;
              case R.id.radioButton3:
                  if(checked)
                      Flag[2]=1;
                  else
                      Flag[2]=0;
                  break;
          }


      }

    public void Message(View v)
    {
        //Saving EditText to a String S
        EditText e=(EditText)findViewById(R.id.editText);
        String S=e.getText().toString();
        //Declaring Spinners for size and color
        Spinner s1=(Spinner)findViewById(R.id.Spinner);
        Spinner s2=(Spinner)findViewById(R.id.Spinner2);
        s1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                A[0]=parent.getSelectedItem().toString();
            }


            public void onNothingSelected(AdapterView<?> arg0) {
                A[0]="size";

            }
        });
        s2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                A[1]=parent.getSelectedItem().toString();
            }


            public void onNothingSelected(AdapterView<?> arg0) {
                A[1]="color";

            }
        });
       /* Intent intent=new Intent(MainActivity.this,MainActivity2Activity.class);
        intent.putExtra("EditText",S).putExtra("RadioFlags",Flag).putExtra("Size and color",A);
        startActivity(intent);
        */
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
