package com.app.nb.androidme.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.app.nb.androidme.R;
import com.app.nb.androidme.data.ImageAssetsManager;
import com.app.nb.androidme.fragments.BodyPartFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Establece la lista de cabezas y el indice de la imagen a mostrar
        BodyPartFragment headFragment = new BodyPartFragment();
        headFragment.setmImagesIds(ImageAssetsManager.getHeads());
        headFragment.setmListImageIndex(1);

        BodyPartFragment bodyFragment = new BodyPartFragment();
        bodyFragment.setmImagesIds(ImageAssetsManager.getBodies());
        bodyFragment.setmListImageIndex(1);

        BodyPartFragment legFragment = new BodyPartFragment();
        legFragment.setmImagesIds(ImageAssetsManager.getLegs());
        legFragment.setmListImageIndex(1);

        FragmentManager fragmentManager = getSupportFragmentManager();

        //Fragment transaction
        fragmentManager.beginTransaction().add(R.id.head_container, headFragment).commit();
        fragmentManager.beginTransaction().add(R.id.body_container, bodyFragment).commit();
        fragmentManager.beginTransaction().add(R.id.leg_container, legFragment).commit();
    }
}
