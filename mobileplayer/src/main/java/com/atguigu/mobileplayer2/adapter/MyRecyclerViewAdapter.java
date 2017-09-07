package com.atguigu.mobileplayer2.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.mobileplayer2.R;
import com.atguigu.mobileplayer2.bean.MediaItem;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

/**
 * Created by zxn on 2017-09-05.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {


    private final Context context;
    private ArrayList<MediaItem> mediaItems;

    public MyRecyclerViewAdapter(Context context, ArrayList<MediaItem> mediaItems){
        this.context=context;
        this.mediaItems=mediaItems;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView=View.inflate(context, R.layout.item_netvideo,null);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MediaItem mediaItem=mediaItems.get(position);
        holder.tv_name.setText(mediaItem.getName());
        Glide.with(context).load(mediaItem.getImageUrl())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.video_default)
                .error(R.drawable.video_default)
                .into(holder.iv_icon);
    }
    @Override
    public int getItemCount() {
        return mediaItems.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        private ImageView iv_icon;
        private TextView tv_name;
        public MyViewHolder(View itemView) {
            super(itemView);
            cardView= (CardView) itemView;
            iv_icon= (ImageView) itemView.findViewById(R.id.iv_icon);
            tv_name= (TextView) itemView.findViewById(R.id.tv_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener!=null){
                        onItemClickListener.onItemClick(v,mediaItems,getAdapterPosition());
                    }
                }
            });
        }
    }
    public interface OnItemClickListener{
        /**
         * 当recyclerview某个被点击的时候回调
         * @param view
         * @param data
         */
        public void onItemClick(View view,ArrayList<MediaItem> mediaItems,int position);
    }
    private OnItemClickListener onItemClickListener;

    /**
     * 设置RecyclerView的点击事件
     * @param onItemClickListener
     */
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
