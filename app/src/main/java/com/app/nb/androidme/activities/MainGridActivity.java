package com.app.nb.androidme.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.app.nb.androidme.R;
import com.app.nb.androidme.data.ImageAssetsManager;
import com.app.nb.androidme.fragments.BodyPartFragment;
import com.app.nb.androidme.fragments.MasterListFragment;

public class MainGridActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {

    private int headIndex;
    private int bodyIndex;
    private int legIndex;

    private Button btnNext;

    private boolean mTwoPane; // variable para validad si se rendereza en dos paneles o un solo panel

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_grid);

        btnNext = findViewById(R.id.btnNext);

        if (findViewById(R.id.two_pane_linearLayout) != null) { // Este solo existe si esta establecida la vista de dos paneles
            mTwoPane = true;

            btnNext.setVisibility(View.GONE);

            //Establece la contidad de columnas del gridview que se ubica en el master list fragment
            GridView gridView = findViewById(R.id.image_grid_view);
            gridView.setNumColumns(2);

            // create nuew body part fragments
            if (savedInstanceState == null) {

                //Establece la lista de cabezas y el indice de la imagen a mostrar
                BodyPartFragment headFragment = new BodyPartFragment();
                headFragment.setmImagesIds(ImageAssetsManager.getHeads());

                BodyPartFragment bodyFragment = new BodyPartFragment();
                bodyFragment.setmImagesIds(ImageAssetsManager.getBodies());

                BodyPartFragment legFragment = new BodyPartFragment();
                legFragment.setmImagesIds(ImageAssetsManager.getLegs());

                FragmentManager fragmentManager = getSupportFragmentManager();

                //Fragment transaction
                fragmentManager.beginTransaction().add(R.id.head_container, headFragment).commit();
                fragmentManager.beginTransaction().add(R.id.body_container, bodyFragment).commit();
                fragmentManager.beginTransaction().add(R.id.leg_container, legFragment).commit();

            }
        } else {
            mTwoPane = false;
        }
    }

    @Override
    public void onImageSelected(int position) {
        // recibe y muestra en un toast la posicion seleccionada en el master list fragment
        Toast.makeText(this, "Posicion : " + position, Toast.LENGTH_SHORT).show();
        // 0 para la cabeza, 1 para el cuerpo, 2 para las piernas
        int bodyPartNumber = position / 12;
        // asegura que el index esté entre 0-11
        int listIndex = position - 12 * bodyPartNumber;

        if (mTwoPane) {

            BodyPartFragment newFragment = new BodyPartFragment();

            switch (bodyPartNumber) {
                case 0:
                    newFragment.setmImagesIds(ImageAssetsManager.getHeads());
                    newFragment.setmListImageIndex(listIndex);
                    getSupportFragmentManager().beginTransaction().replace(R.id.head_container, newFragment).commit();
                    break;
                case 1:
                    newFragment.setmImagesIds(ImageAssetsManager.getBodies());
                    newFragment.setmListImageIndex(listIndex);
                    getSupportFragmentManager().beginTransaction().replace(R.id.body_container, newFragment).commit();
                    break;
                case 2:
                    newFragment.setmImagesIds(ImageAssetsManager.getLegs());
                    newFragment.setmListImageIndex(listIndex);
                    getSupportFragmentManager().beginTransaction().replace(R.id.leg_container, newFragment).commit();
                    break;
            }
        } else {

            switch (bodyPartNumber) {
                case 0:
                    headIndex = listIndex;
                    break;
                case 1:
                    bodyIndex = listIndex;
                    break;
                case 2:
                    legIndex = listIndex;
                    break;
            }


            Bundle bundle = new Bundle();
            bundle.putInt("headIndex", headIndex);
            bundle.putInt("bodyIndex", bodyIndex);
            bundle.putInt("legIndex", legIndex);

            final Intent intent = new Intent(this, MainActivity.class);
            intent.putExtras(bundle);

            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(intent);
                }
            });
        }
    }


}
