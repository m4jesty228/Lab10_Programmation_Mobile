package com.ensa.navigationdrawerdemo;

// Activité principale — gère le Navigation Drawer et les transactions de fragments
// C'est le point d'entrée de l'application

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    // DrawerLayout : conteneur racine qui gère l'ouverture/fermeture du drawer
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ── Toolbar : remplace l'ActionBar par défaut ──────────────────
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // ── DrawerLayout : référence au conteneur principal ───────────
        drawerLayout = findViewById(R.id.drawer_layout);

        // ── NavigationView : panneau latéral avec le menu ─────────────
        NavigationView navigationView = findViewById(R.id.nav_view);

        // Lier l'écouteur de clic sur les items du menu à cette Activity
        navigationView.setNavigationItemSelectedListener(this);

        // ── Toggle : bouton hamburger ☰ pour ouvrir/fermer le drawer ──
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,   // Description accessibilité ouverture
                R.string.navigation_drawer_close    // Description accessibilité fermeture
        );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState(); // Synchronise l'icône avec l'état du drawer

        // ── Afficher le Fragment 1 par défaut au lancement ────────────
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.contenu, new BlankFragment())
                    .commit();
            // Cocher "Accueil" dans le menu au lancement
            navigationView.setCheckedItem(R.id.nav_fragment1);
        }
    }

    // ══════════════════════════════════════════════════════════════════
    // Appelé quand l'utilisateur clique sur un item du Navigation Drawer
    // ══════════════════════════════════════════════════════════════════
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_fragment1) {
            // Remplace le contenu par le Fragment Accueil
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.contenu, new BlankFragment())
                    .commit();

        } else if (id == R.id.nav_fragment2) {
            // Remplace le contenu par le Fragment Tableau de bord
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.contenu, new BlankFragment2())
                    .commit();

        } else if (id == R.id.nav_list) {
            // Remplace le contenu par le Fragment Liste
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.contenu, new FragmentList())
                    .commit();
        }

        // Fermer le drawer après sélection d'un item
        // GravityCompat.START = ferme depuis la gauche
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    // Gérer le bouton retour : ferme le drawer s'il est ouvert
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START); // Ferme le drawer
        } else {
            super.onBackPressed(); // Comportement normal sinon
        }
    }
}