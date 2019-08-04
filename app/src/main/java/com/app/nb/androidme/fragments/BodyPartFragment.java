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

import java.util.ArrayList;
import java.util.List;

public class BodyPartFragment extends Fragment {

    // constantes para almacenar la info del estado de la lista de iamges y su index (key:value)
    public static final String IMAGE_ID_LIST = "image_ids";
    public static final String LIST_INDEX = "List_index";

    // Variables para almacenar la lista de iamgenes y el index de la imagen a mostrar
    private List<Integer> mImagesIds;
    private int mListImageIndex;

    public BodyPartFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Carga el estado guardado (la lista de imagenes y el index) si lo hay
        mImagesIds = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
        mListImageIndex = savedInstanceState.getInt(LIST_INDEX);

        // Inflate the layout
        View view = inflater.inflate(R.layout.fragment_body_part, container, false);

        final ImageView imageView = view.findViewById(R.id.body_part_image_view);

        imageView.setImageResource(mImagesIds.get(mListImageIndex));

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListImageIndex < mImagesIds.size() - 1)
                    mListImageIndex++;
                else
                    mListImageIndex = 0;
                imageView.setImageResource(mImagesIds.get(mListImageIndex));
            }
        });

        return view;
    }

    public void setmImagesIds(List<Integer> mImagesIds) {
        this.mImagesIds = mImagesIds;
    }

    public void setmListImageIndex(int mListImageIndex) {
        this.mListImageIndex = mListImageIndex;
    }

    /**
     * Guardar el estado actual del fragment
     */
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>) mImagesIds);
        outState.putInt(LIST_INDEX, mListImageIndex);
    }
}
