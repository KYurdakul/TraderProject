package com.example.kerem.traderproject.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.kerem.traderproject.Model.Item;
import com.example.kerem.traderproject.R;

import java.util.List;

public class RecyclerViewAdapter extends  RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    List<Item> items;
    private Context context;


    public RecyclerViewAdapter(List<Item> items, Context context) {
        this.items = items;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        viewHolder.menkul.setText(items.get(i).getSymbol());
        viewHolder.miktart2.setText(String.valueOf(items.get(i).getQty_T2()));
        viewHolder.fiyat.setText(String.valueOf(items.get(i).getLastPx()));
        viewHolder.tutar.setText(String.format("%,.3f",(items.get(i).getQty_T2())*(items.get(i).getLastPx())));

    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView menkul,miktart2,fiyat,tutar;

        public ViewHolder(View itemView) {
            super(itemView);
            menkul = itemView.findViewById(R.id.text1);
            miktart2 = itemView.findViewById(R.id.text2);
            fiyat = itemView.findViewById(R.id.text3);
            tutar = itemView.findViewById(R.id.text4);

        }
    }
}

