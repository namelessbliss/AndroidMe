package com.app.nb.androidme.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.app.nb.androidme.R;
import com.app.nb.androidme.data.ImageAssetsManager;
import com.app.nb.androidme.fragments.BodyPartFragment;

public class MainActivity extends AppCompatActivity {

    private int headIndex;
    private int bodyIndex;
    private int legIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {

            Bundle bundle = getIntent().getExtras();
            if (bundle != null) {
                headIndex = bundle.getInt("headIndex");
                bodyIndex = bundle.getInt("bodyIndex");
                legIndex = bundle.getInt("legIndex");

                //Establece la lista de cabezas y el indice de la imagen a mostrar
                BodyPartFragment headFragment = new BodyPartFragment();
                headFragment.setmImagesIds(ImageAssetsManager.getHeads());
                headFragment.setmListImageIndex(headIndex);

                BodyPartFragment bodyFragment = new BodyPartFragment();
                bodyFragment.setmImagesIds(ImageAssetsManager.getBodies());
                bodyFragment.setmListImageIndex(bodyIndex);

                BodyPartFragment legFragment = new BodyPartFragment();
                legFragment.setmImagesIds(ImageAssetsManager.getLegs());
                legFragment.setmListImageIndex(legIndex);

                FragmentManager fragmentManager = getSupportFragmentManager();

                //Fragment transaction
                fragmentManager.beginTransaction().add(R.id.head_container, headFragment).commit();
                fragmentManager.beginTransaction().add(R.id.body_container, bodyFragment).commit();
                fragmentManager.beginTransaction().add(R.id.leg_container, legFragment).commit();
            }
        }
    }
}
