package com.example.moni3.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.moni3.R;
import com.example.moni3.bean.SatinBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class SatinAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<SatinBean.DataBean> list;
    private LayoutInflater inflater;
    private final int text_Only=0;
    private final int IMAGE_LEFT=1;

    public SatinAdapter(Context context, List<SatinBean.DataBean> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder;
        if (viewType==text_Only) {
            View view = inflater.inflate(R.layout.rv_rightimg_item, parent, false);
            holder = new NormalViewHolder(view);
        } else if (viewType==IMAGE_LEFT) {
            View view = inflater.inflate(R.layout.rv_pullimg_item, parent, false);
            holder = new ImagesViewHolder(view);
        } else {
            holder = null;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SatinBean.DataBean dataBean = list.get(position);
        if(getItemViewType(position)==text_Only){
            NormalViewHolder normalViewHolder = (NormalViewHolder) holder;
            normalViewHolder.img01.setImageURI(dataBean.getProfile_image());
            normalViewHolder.text1.setText(dataBean.getName());
            normalViewHolder.text2.setText(dataBean.getCreated_at());


        }else{
            ImagesViewHolder imagesViewHolder = (ImagesViewHolder) holder;
            imagesViewHolder.img01.setImageURI(dataBean.getProfile_image());
            imagesViewHolder.text1.setText(dataBean.getName());
            imagesViewHolder.text2.setText(dataBean.getCreated_at());
            //imagesViewHolder.img02.setVideoURI(dataBean.getVideouri());

        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return text_Only;
        } else{
            return IMAGE_LEFT;
        }
    }


        class NormalViewHolder extends RecyclerView.ViewHolder {


            private final SimpleDraweeView img01;
            private final TextView text1;
            private final TextView text2;


            public NormalViewHolder(View itemView) {
                super(itemView);
                img01 = itemView.findViewById(R.id.img01);
                text1 = itemView.findViewById(R.id.text1);
                text2 = itemView.findViewById(R.id.text2);
            }
        }

        class ImagesViewHolder extends RecyclerView.ViewHolder {


            private final SimpleDraweeView img01;
            private final TextView text1;
            private final TextView text2;
            private final VideoView img02;

            public ImagesViewHolder(View itemView) {
                super(itemView);

                img01 = itemView.findViewById(R.id.img01);
                text1 = itemView.findViewById(R.id.text1);
                text2 = itemView.findViewById(R.id.text2);
                img02 = itemView.findViewById(R.id.img02);

            }
        }


    }