package com.example.homework1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DayRecyclerView extends RecyclerView.Adapter<DayRecyclerView.ViewHolder> {

    private ItemClickListener clickListener;
    public List<String> dayList;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.day_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DayRecyclerView.ViewHolder holder, int position) {
        holder.bind(dayList.get(position));
    }

    @Override
    public int getItemCount() {
        return dayList.size();
    }

    public void updateItems(List<String> newList)
    {
        dayList = newList;
        notifyDataSetChanged();
    }
    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView dayText;
        ImageView dayImage;
        Button dayButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dayText = itemView.findViewById(R.id.the_fragments_text);
            dayImage= itemView.findViewById(R.id.the_days_image);
            dayButton = itemView.findViewById(R.id.the_days_button);
            dayButton.setOnClickListener(this);
        }

        public void bind(String s) {
            dayText.setText(s);
            s=s.toLowerCase();

            //sauce: https://stackoverflow.com/questions/13351003/find-drawable-by-string
            Context context = dayImage.getContext();
            int id = context.getResources().getIdentifier(s, "drawable", context.getPackageName());
            dayImage.setImageResource(id);
        }
        @Override
        public void onClick(View view)
        {

            if(clickListener!=null) clickListener.onItemClick(dayText.getText(), 0);

        }
    }
    public interface ItemClickListener {
        void onItemClick(CharSequence dayName, int dayImage);
    }
}
