package com.app.nb.androidme.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.app.nb.androidme.R;
import com.app.nb.androidme.adapters.MasterListAdapter;
import com.app.nb.androidme.data.ImageAssetsManager;

public class MasterListFragment extends Fragment {

    public MasterListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_master_list, container, false);

        GridView gridView = view.findViewById(R.id.image_grid_view);

        //crear adaptador
        MasterListAdapter adapter = new MasterListAdapter(getContext(), ImageAssetsManager.getAll());

        gridView.setAdapter(adapter);

        return view;
    }


}
