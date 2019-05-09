package com.example.userpc.projet1;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class tdi203Activity extends Activity {
  EditText e1 = null;
  EditText e2=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tdi203);


    }


    public void traiter(View view) {
        //ici event click sur button
        //@string/x1
        //recuperer numero et email from edittext
      e1=(EditText) findViewById(R.id.nn);
       e2=(EditText)findViewById(R.id.email);

       String m=e1.getText().toString()+
               " "+e2.getText().toString();

        Toast.makeText(this,m,Toast.LENGTH_SHORT).show();
    }
}
