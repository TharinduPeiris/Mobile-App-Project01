package com.example.project;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdsListAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<Ads> adsList;

    public AdsListAdapter(Context context, int layout, ArrayList<Ads> adsList) {
        this.context = context;
        this.layout = layout;
        this.adsList = adsList;
    }

    @Override
    public int getCount() {
        return adsList.size();
    }

    @Override
    public Object getItem(int position) {
        return adsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder = new ViewHolder();

        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.txtname = (TextView) row.findViewById(R.id.textName);
            holder.txtprice = (TextView) row.findViewById(R.id.textPrice);
            holder.imageView = (ImageView) row.findViewById(R.id.imageView3);
            row.setTag(holder);

        } else {
            holder = (ViewHolder) row.getTag();
        }

        Ads ads = adsList.get(position);
        holder.txtname.setText(ads.getName());
        holder.txtprice.setText(ads.getPrice());
        byte[] adimage = ads.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(adimage,0, adimage.length);
        holder.imageView.setImageBitmap(bitmap);
        return row;
    }

    private class ViewHolder {
        ImageView imageView;
        TextView txtname, txtprice;


    }


}
