package com.atguigu.mobileplayer2.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.mobileplayer2.R;
import com.atguigu.mobileplayer2.bean.SearchBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * 作者：zxm
 * 作用：NetVideoPager的适配器
 */
public class SearchAdapter extends BaseAdapter {

    private  Context context;
    private final List<SearchBean.ItemData> Items;

    public SearchAdapter(Context context, List<SearchBean.ItemData> mediaItems){
        this.context = context;
        this.Items = mediaItems;
    }

    @Override
    public int getCount() {
        return Items.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoder viewHoder;
        if(convertView ==null){
            convertView = View.inflate(context, R.layout.item_netvideo_pager,null);
            viewHoder = new ViewHoder();
            viewHoder.iv_icon = (ImageView) convertView.findViewById(R.id.iv_icon);
            viewHoder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            viewHoder.tv_desc = (TextView) convertView.findViewById(R.id.tv_desc);
            convertView.setTag(viewHoder);
        }else{
            viewHoder = (ViewHoder) convertView.getTag();
        }

        //根据position得到列表中对应位置的数据
        SearchBean.ItemData mediaItem = Items.get(position);
        viewHoder.tv_name.setText(mediaItem.getItemTitle());
        viewHoder.tv_desc.setText(mediaItem.getKeywords());
        //1.使用xUtils3请求图片
//        x.image().bind(viewHoder.iv_icon,mediaItem.getImageUrl());
        //2.使用Glide请求图片
//        Glide.with(context).load(mediaItem.getImageUrl())
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .placeholder(R.drawable.video_default)
//                .error(R.drawable.video_default)
//                .into(viewHoder.iv_icon);
        //3.使用Picasso 请求图片
        String url=mediaItem.getItemImage().getImgUrl1();
        if (!TextUtils.isEmpty(url)) {
            Picasso.with(context).load(url)
                    .placeholder(R.drawable.video_default)
                    .error(R.drawable.video_default)
                    .into(viewHoder.iv_icon);
        }else {
            Picasso.with(context).load(R.drawable.video_default)
                    .placeholder(R.drawable.video_default)
                    .error(R.drawable.video_default)
                    .into(viewHoder.iv_icon);

        }
        return convertView;
    }
    static class ViewHoder{
        ImageView iv_icon;
        TextView tv_name;
        TextView tv_desc;
    }
}

