package com.example.quoctuan.project_karaoke.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.quoctuan.project_karaoke.R;
import com.example.quoctuan.project_karaoke.model.Music;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Admin on 3/25/2017.
 */

public class MusicAdapter extends ArrayAdapter<Music> {
    Activity context;
    @LayoutRes int resource;
    @NonNull List<Music> objects;
    public MusicAdapter(@NonNull Activity context, @LayoutRes int resource, @NonNull List<Music> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row =  inflater.inflate(this.resource,null);

        TextView txtMa= (TextView) row.findViewById(R.id.txtMa);
        TextView txtTen= (TextView) row.findViewById(R.id.txtTen);
        TextView txtCaSi= (TextView) row.findViewById(R.id.txtCaSi);
        ImageButton btnLike= (ImageButton) row.findViewById(R.id.btnLike);
        ImageButton btnDisLike= (ImageButton) row.findViewById(R.id.btnDisLike);

        final Music music = this.objects.get(position);

        txtTen.setText(music.getTen());
        txtMa.setText(music.getMa());
        txtCaSi.setText(music.getCaSi());

        if (music.isThich()){
            btnLike.setVisibility(View.INVISIBLE);
            btnDisLike.setVisibility(View.VISIBLE);
        }
        else {
            btnLike.setVisibility(View.VISIBLE);
            btnDisLike.setVisibility(View.INVISIBLE);
        }

        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyThich(music);
            }
        });

        return row;
    }

    private void xuLyThich(Music music) {

        music.setThich(true);

    }
}
