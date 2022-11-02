package com.example.customizedlistproject;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class BilAdapter extends BaseAdapter {


     ArrayList<Bil> biler;
     Context context;

    public BilAdapter(ArrayList<Bil> biler, Context context) {
        this.biler=biler;
        this.context=context;
    }

    @Override
    public int getCount() {
        return biler.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View v =inflater.inflate(R.layout.bil_item_layout, null);

        Bil bil=biler.get(position);

        ImageView img=v.findViewById(R.id.imgBil);
        img.setImageResource(bil.getBilledId());

        TextView txtNavn= v.findViewById(R.id.txtName);
        txtNavn.setText(bil.getName());
        TextView txtDescription=v.findViewById(R.id.txtDescription);
        txtDescription.setText(bil.getBeskrivelse());
        Button btnDelete =v.findViewById(R.id.btnDelete);
        btnDelete.setText("Delele " + bil.getName());
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                AlertDialog.Builder alert = new AlertDialog.Builder(context);
                alert.setTitle("Delete Bil?" +bil.getName());
                alert.setMessage("Ønsker De at slette den biler?");

                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton)
                    {
                        int posToRemove = position;
                        Bil remove = biler.remove(posToRemove);
                        notifyDataSetChanged();
                    }
                });

                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int whichButton)
                    {

                    }
                });

                alert.show();
            }
        });

        return v;
    }
}
