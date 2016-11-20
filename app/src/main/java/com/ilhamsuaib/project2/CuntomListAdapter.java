package com.ilhamsuaib.project2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ilham on 20/11/2016.
 */

public class CuntomListAdapter extends BaseAdapter{

    int[] arrImage;
    String[] arrNama, arrWaktu, arrPesan;
    LayoutInflater inflater = null;

    public CuntomListAdapter(Context context, int[] img, String[] nama, String[] waktu, String[] pesan) {
        arrImage = img;
        arrNama = nama;
        arrWaktu = waktu;
        arrPesan = pesan;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arrNama.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class Holder{
        ImageView imgUser;
        TextView tvNama, tvWaktu, tvPesan;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        convertView = inflater.inflate(R.layout.custom_list_adapter, null);
        holder.imgUser = (ImageView) convertView.findViewById(R.id.img_user);
        holder.tvNama = (TextView) convertView.findViewById(R.id.tv_nama);
        holder.tvWaktu = (TextView) convertView.findViewById(R.id.tv_waktu);
        holder.tvPesan = (TextView) convertView.findViewById(R.id.tv_pesan);

        //mengasih nilai pada view (imageView, textview)
        holder.imgUser.setImageResource(arrImage[position]);
        holder.tvNama.setText(arrNama[position]);
        holder.tvWaktu.setText(arrWaktu[position]);
        holder.tvPesan.setText(arrPesan[position]);
        return convertView;
    }
}
