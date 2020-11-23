package dev.brkic.lv2_orwma.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import dev.brkic.lv2_orwma.R;

import dev.brkic.lv2_orwma.common.RemoveClickListener;
import dev.brkic.lv2_orwma.viewHolders.StudentViewHolder;

public class StudentsAdapter extends RecyclerView.Adapter<StudentViewHolder> {

    private List<String> dataList = new ArrayList<>();
    private RemoveClickListener clickListener;

    public  StudentsAdapter(RemoveClickListener listener) {this.clickListener=listener;}

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cellView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_name, parent, false);
        return new StudentViewHolder(cellView, clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        holder.setName(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void addData(List<String> data) {
        this.dataList.clear();
        this.dataList.addAll(data);
        notifyDataSetChanged();
    }

    public void addNewCell(String name, int position) {
        if (dataList.size() >= position) {
            dataList.add(position, name);
            notifyItemInserted(position);
        }
    }

    public void removeCell(int position) {
        if (dataList.size() > position) {
            dataList.remove(position);
            notifyItemRemoved(position);
        }
    }

}