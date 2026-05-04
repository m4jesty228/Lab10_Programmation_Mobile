package com.ensa.navigationdrawerdemo;

// FragmentList — affiche une liste simple via ListFragment
// ListFragment gère automatiquement un ListView sans XML supplémentaire

import android.os.Bundle;
import android.widget.ArrayAdapter;
import androidx.fragment.app.ListFragment;

public class FragmentList extends ListFragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Données de la liste — personnalisées pour ce lab
        String[] elements = {
                "🎓 Module Android",
                "🔧 Navigation Drawer",
                "📦 Fragment Manager",
                "🎨 Vector Assets",
                "🔁 Transactions",
                "📋 ListFragment",
                "⚙️ ArrayAdapter",
                "🗂 FragmentBackStack",
                "🌐 ENSA Marrakech",
                "🚀 GCDSTE S4"
        };

        // ArrayAdapter lie le tableau de données au ListView du ListFragment
        // android.R.layout.simple_list_item_1 = layout natif Android pour une liste simple
        ArrayAdapter<String> adaptateur = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                elements
        );

        // setListAdapter() injecte l'adapter dans le ListView géré par ListFragment
        setListAdapter(adaptateur);
    }
}