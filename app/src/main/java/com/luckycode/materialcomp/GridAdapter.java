package com.luckycode.materialcomp;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.RelativeLayout;

/**
 * Created by marcelocuevas on 4/23/18.
 */

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.GridItemViewHolder> {

    @Override
    public GridItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_grid,parent,false);
        return new GridItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GridItemViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return 150;
    }

    class GridItemViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout mainBG;

        public GridItemViewHolder(View itemView) {
            super(itemView);
            mainBG = itemView.findViewById(R.id.main_bg);
        }

        public void bind(int position){
            if(position % 2 == 0 )
                mainBG.setBackgroundColor(Color.WHITE);
            else
                mainBG.setBackgroundColor(Color.BLACK);
        }

    }
}
