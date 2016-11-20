package com.ilhamsuaib.project2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.clans.fab.FloatingActionButton;


public class MainActivity extends AppCompatActivity {

    Button btnSimpleLv, btnCustomLv;
    FloatingActionButton fabSimpleLv, fabCustomLv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fabSimpleLv = (FloatingActionButton) findViewById(R.id.fab_simple_lv);
        fabCustomLv = (FloatingActionButton) findViewById(R.id.fab_custom_lv);

        fabSimpleLv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), SimpleListViewActivity.class));
            }
        });

        fabCustomLv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), CustomListViewActivity.class));
            }
        });


        btnSimpleLv = (Button) findViewById(R.id.btn_simple_lv);
        btnCustomLv = (Button) findViewById(R.id.btn_custom_lv);
        //ketika tombol btnSimpleLv diklik
        btnSimpleLv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //menuju halaman/activity SimpleListViewActivity
                startActivity(new Intent(getBaseContext(), SimpleListViewActivity.class));
            }
        });

        //ketika tombol btnCustomLv diklik
        btnCustomLv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //menuju halaman/activity CustomListViewActivity
                startActivity(new Intent(getBaseContext(), CustomListViewActivity.class));
            }
        });
    }
}
