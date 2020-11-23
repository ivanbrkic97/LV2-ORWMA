package dev.brkic.lv2_orwma.viewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import dev.brkic.lv2_orwma.R;
import dev.brkic.lv2_orwma.common.RemoveClickListener;

public class StudentViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener
{

    private TextView nameTextView;
    private ImageView removeImageView;
    private RemoveClickListener clickListener;

    public StudentViewHolder(@NonNull View itemView, RemoveClickListener listener)
    {
        super(itemView);
        this.clickListener = listener;
        nameTextView = itemView.findViewById(R.id.nameTextView);
        removeImageView = itemView.findViewById(R.id.removeImageView);
        removeImageView.setOnClickListener(this);
        //itemView.setOnClickListener(this);
    }

    public void  setName(String name)
    {
        nameTextView.setText(name);
    }


    @Override
    public void onClick(View view)
    {
        clickListener.onNameClick(getAdapterPosition());
    }
}