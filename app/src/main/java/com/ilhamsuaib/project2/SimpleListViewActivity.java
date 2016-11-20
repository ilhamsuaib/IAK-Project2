package com.ilhamsuaib.project2;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class SimpleListViewActivity extends AppCompatActivity {

    ListView lvNamaBuah;
    ArrayAdapter<String> arrayAdapter;
    String[] arrNamaBuah = {"Durian","Jambu","Mangga","Nanas","Pepaya","Nangka","Jeruk","Anggur","Apel","Leci","DLL"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        lvNamaBuah = (ListView) findViewById(R.id.lv_nama_buah);
        arrayAdapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, arrNamaBuah);
        lvNamaBuah.setAdapter(arrayAdapter);

        //ketika list item diklik
        lvNamaBuah.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), "On Clic Buah : "+arrNamaBuah[position], Toast.LENGTH_SHORT).show();
            }
        });

        //ketika list item di long klik
        lvNamaBuah.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                DisplayMyDialog(position);
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    private void DisplayMyDialog(final int position){
        String[] options = {"Edit","Hapus","New Item"};
        AlertDialog.Builder builder = new AlertDialog.Builder(SimpleListViewActivity.this);
        builder.setTitle("Pilih");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    //ketika edit diclik
                    case 0:
                        Toast.makeText(getBaseContext(), "Saya ingin mengedit : "+arrNamaBuah[position], Toast.LENGTH_SHORT).show();
                        break;
                    //ketika hapus diclik
                    case 1:
                        //do something
                        break;
                    //ketika new item diclick
                    case 2:
                        //do something
                        break;
                }
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
