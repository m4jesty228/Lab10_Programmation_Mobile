package com.ensa.navigationdrawerdemo;

// Fragment 2 — Tableau de bord
// Affiché quand l'utilisateur clique sur "Tableau de bord" dans le drawer

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

public class BlankFragment2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate du layout XML associé à ce fragment
        return inflater.inflate(R.layout.fragment_blank2, container, false);
    }
}