package com.app.nb.androidme.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.app.nb.androidme.R;
import com.app.nb.androidme.adapters.MasterListAdapter;
import com.app.nb.androidme.data.ImageAssetsManager;

public class MasterListFragment extends Fragment {

    // Define una nueva interface que dispara un callback en el host Activity
    OnImageClickListener mCallBack;

    public MasterListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_master_list, container, false);

        GridView gridView = view.findViewById(R.id.image_grid_view);

        //crear adaptador
        MasterListAdapter adapter = new MasterListAdapter(getContext(), ImageAssetsManager.getAll());

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Dispara el metodo callback y pasa la posicion a la que se ha hecho click
                mCallBack.onImageSelected(position);
            }
        });

        return view;
    }

    /**
     * Interface que permite llamar al metodo onImageSelected en el host activity
     */
    public interface OnImageClickListener {
        void onImageSelected(int position); //Metodo que se dispara
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // Valida que el host activity ha implementado la interface, sino arrojara una exception
        try {
            mCallBack = (OnImageClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " debe implementar Interface OnImageClickListener");
        }
    }
}
