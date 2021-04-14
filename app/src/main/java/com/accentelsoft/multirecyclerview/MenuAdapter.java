package com.accentelsoft.multirecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Designed and Developed by Mohammad suhail ahmed on 14/04/2021
 */
public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private List<Integer> groupData = new ArrayList<>();
    private List<Menu> menuDetails = new ArrayList<>();

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item,parent,false);
        return new MenuAdapter.MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder viewHolder, int position) {
        Menu dataModel = menuDetails.get(position);
        if(groupData.get(position) == 0){
            viewHolder.header.setVisibility(View.VISIBLE);
            viewHolder.header.setText(menuDetails.get(position).getCategoryname());
        }
        else{
            viewHolder.header.setVisibility(View.GONE);
        }
        viewHolder.menuName.setText(dataModel.getMenuname());
    }

    public void setDataList(List<Menu> data, List<Integer> groupData){
        menuDetails=data;
        this.groupData = groupData;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return menuDetails.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder{

        private TextView header,menuName;
        private Button add;
        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            header = itemView.findViewById(R.id.menu_category);
            menuName = itemView.findViewById(R.id.menu_name);
            add = itemView.findViewById(R.id.add);
        }
    }
}
