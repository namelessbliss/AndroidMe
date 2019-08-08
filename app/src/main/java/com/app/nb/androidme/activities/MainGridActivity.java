package com.app.nb.androidme.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.app.nb.androidme.R;
import com.app.nb.androidme.fragments.MasterListFragment;

public class MainGridActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {

    private int headIndex;
    private int bodyIndex;
    private int legIndex;

    private Button btnNext;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_grid);

        btnNext = findViewById(R.id.btnNext);
    }

    @Override
    public void onImageSelected(int position) {
        // recibe y muestra en un toast la posicion seleccionada en el master list fragment
        Toast.makeText(this, "Posicion : " + position, Toast.LENGTH_SHORT).show();
        // 0 para la cabeza, 1 para el cuerpo, 2 para las piernas
        int bodyPartNumber = position / 12;
        // asegura que el index esté entre 0-11
        int listIndex = position - 12 * bodyPartNumber;

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
