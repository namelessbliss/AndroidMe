package com.app.nb.androidme.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

public class MasterListAdapter extends BaseAdapter {

    private Context context;
    private List<Integer> mImagesIds;

    public MasterListAdapter(Context context, List<Integer> mImagesIds) {
        this.context = context;
        this.mImagesIds = mImagesIds;
    }

    @Override
    public int getCount() {
        return mImagesIds.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int id) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) { // If the view is not recycled, this creates a new ImageView to hold an image
            imageView = new ImageView(context);
            // define layout parameters
            imageView.setAdjustViewBounds(true);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }
        //set the image result and return the newly created ImageView
        imageView.setImageResource(mImagesIds.get(position));
        return imageView;
    }

}
