package com.ensa.navigationdrawerdemo;

// Fragment 1 — Accueil
// Affiché quand l'utilisateur clique sur "Accueil" dans le drawer

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

public class BlankFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate = convertit le XML en objet View utilisable en Java
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }
}