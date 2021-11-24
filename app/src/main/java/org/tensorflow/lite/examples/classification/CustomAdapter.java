package org.tensorflow.lite.examples.classification;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    // 리사이클러뷰의 아이템을 담는 배열
    private ArrayList<CustomData> arrayList;

    public CustomAdapter(ArrayList<CustomData> arrayList) {
        this.arrayList = arrayList;
    }

    // 아이템이 처음 생성될 때의 생명 주기
    @NonNull
    @Override
    public CustomAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_button, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    // 아이템이 추가될 때의 생명 주기
    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.CustomViewHolder holder, int position) {
        holder.iv_icon.setImageResource(arrayList.get(position).getIv_icon());
        holder.tv_name.setText(arrayList.get(position).getTv_name());

        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String curName = holder.tv_name.getText().toString();
                Toast.makeText(v.getContext(), curName, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    // 생성한 클래스
    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected ImageView iv_icon;
        protected TextView tv_name;
        int itemIdx = -1;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            this.iv_icon = itemView.findViewById(R.id.iv_custom_item);
            this.tv_name = itemView.findViewById(R.id.tv_custom_item);
        }
    }
}
