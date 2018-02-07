package com.micky.it.week5;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText edt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn = (Button)findViewById(R.id.button);
        edt = (EditText) findViewById(R.id.editText);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Context context = getApplicationContext();
                SharedPreferences share = context.getSharedPreferences("share",context.MODE_PRIVATE);

                //Write a shared data
                SharedPreferences.Editor editor = share.edit();
                editor.putInt("highscore",100);
                editor.commit();

                //Read
                int highscore = share.getInt("highscore",-1);

                Toast toast = Toast.makeText(context,""+highscore,Toast.LENGTH_LONG);
                toast.show();
            }

        });


    }
}
