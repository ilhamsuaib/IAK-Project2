package com.ilhamsuaib.project2;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class CustomListViewActivity extends AppCompatActivity {

    ListView lvObrolan;
    int[] arrImage = {R.drawable.avara1, R.drawable.avatar2,
            R.drawable.avatar3, R.drawable.avatar4, R.drawable.avatar5};
    String[] arrNama = {"Invoker","Magnus","Jugernut","Templar Assasin","Roshan"};
    String[] arrWaktu = {"08:50 am","07:30 am","06:50 pm","12:53 pm","10:42 am"};
    String[] arrPesan = {"Selamat, anda menjadi pemenang undian minggu ini.",
            "Selamat, anda menjadi pemenang undian minggu ini.",
            "Mama minta pulsa, nmr yg lama dah ganti jadi kirim ke nomr ini aja...",
            "Selamat, anda menjadi pemenang undian minggu ini.",
            "Selamat, anda menjadi pemenang undian minggu ini."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);
        lvObrolan = (ListView) findViewById(R.id.lv_obrolan);
        CuntomListAdapter list_tem = new CuntomListAdapter(getBaseContext(), arrImage, arrNama, arrWaktu, arrPesan);
        lvObrolan.setAdapter(list_tem);
        //ketika diklik lama
        lvObrolan.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //menampilkan pesan konfirmasi untuk menghapus
                DeleteConfirmationDialog(position);
                return true;
            }
        });
        setTitle("Obrolan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void DeleteConfirmationDialog(final int position){
        AlertDialog.Builder builder = new AlertDialog.Builder(CustomListViewActivity.this);
        builder.setTitle("Hapus?");
        builder.setMessage("Anda yakin akan menghapus data "+arrNama[position]+"?");
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(), "Data "+arrNama[position]+" telah dihapus!", Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
