package com.example.sematec_1.Adapters;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sematec_1.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.TestViewHolder> {

    List<String> myList;

    public RecyclerAdapter(List<String> list) {

        myList = list;
    }

    @NonNull
    @Override
    public TestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_items, parent, false);
        TestViewHolder holder = new TestViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TestViewHolder holder, int position) {

       /* switch (position) {
            case 0:
                holder.item_tv.setText("mohammad");
                break;
            case 1:
                holder.item_tv.setText("mohammad");
                break;
            case 2:
                holder.item_tv.setText("mohammad");
                break;
            case 3:
                holder.item_tv.setText("mohammad");
                break;

            case 4:
                holder.item_tv.setText("ali");
                holder.item_img.setImageResource(R.drawable.apr);
                break;

        }          */

    String s = myList.get(position);
    holder.item_tv.setText(s);

    }

    @Override
    public int getItemCount() {
        return (myList!=null) ? myList.size():0;
    }

    class TestViewHolder extends RecyclerView.ViewHolder {
        TextView item_tv;
        ImageView item_img;

        public TestViewHolder(@NonNull View itemView) {
            super(itemView);
            item_tv = itemView.findViewById(R.id.item_tv);
            item_img = itemView.findViewById(R.id.item_image);
        }
    }
}
