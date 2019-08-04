package com.app.nb.androidme.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.app.nb.androidme.R;
import com.app.nb.androidme.data.ImageAssetsManager;

public class BodyPartFragment extends Fragment {

    public BodyPartFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout
        View view = inflater.inflate(R.layout.fragment_body_part, container, false);

        ImageView imageView = view.findViewById(R.id.body_part_image_view);

        imageView.setImageResource(ImageAssetsManager.getHeads().get(0));

        return view;
    }
}
