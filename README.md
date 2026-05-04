# 🧭 NavigationDrawerDemo 📱

> Application Android développée dans le cadre du **LAB — Navigation Drawer & Fragments**  
> Module : Programmation Mobile Android | ENSA Marrakech — GCDSTE S4

---

## 🎯 Objectifs pédagogiques

- Mettre en place un **Navigation Drawer** (menu latéral) from scratch
- Gérer dynamiquement plusieurs **Fragments** dans une seule Activity
- Maîtriser les **transactions de fragments** via `FragmentManager`
- Personnaliser le menu latéral avec des **icônes vectorielles**
- Utiliser un **ListFragment** pour afficher une liste sans XML supplémentaire

---

## 🏗️ Structure du projet

```
NavigationDrawerDemo/
├── java/com.ensa.navigationdrawerdemo/
│   ├── MainActivity.java          # Activité principale + gestion du Drawer
│   ├── BlankFragment.java         # Fragment Accueil (fond violet clair)
│   ├── BlankFragment2.java        # Fragment Tableau de bord (fond vert foncé)
│   └── FragmentList.java          # Fragment Liste (ListFragment natif)
└── res/
    ├── layout/
    │   ├── activity_main.xml      # DrawerLayout racine + NavigationView
    │   ├── content_main.xml       # Conteneur FrameLayout des fragments
    │   ├── nav_header_main.xml    # En-tête du panneau latéral
    │   ├── fragment_blank.xml     # Layout Fragment 1
    │   └── fragment_blank2.xml    # Layout Fragment 2
    ├── menu/
    │   └── activity_main_drawer.xml  # Items du menu Navigation Drawer
    └── drawable/
        ├── ic_home.xml            # Icône vectorielle Accueil
        ├── ic_dashboard.xml       # Icône vectorielle Tableau de bord
        └── ic_list.xml            # Icône vectorielle Liste
```

---

## ⚙️ Fonctionnement de l'application

| Action | Résultat attendu |
|---|---|
| Lancement de l'app | Fragment Accueil affiché par défaut |
| Clic sur ☰ (hamburger) | Panneau latéral s'ouvre depuis la gauche |
| Clic sur **Accueil** | Fragment 1 affiché — fond violet clair |
| Clic sur **Tableau de bord** | Fragment 2 affiché — fond vert foncé |
| Clic sur **Liste** | ListFragment affiché avec 10 éléments |
| Appui sur **Retour** | Ferme le drawer s'il est ouvert |

---

## 🧩 Concepts clés illustrés

### 🗂 DrawerLayout
Conteneur racine qui gère l'ouverture et la fermeture du panneau latéral. Le `NavigationView` doit obligatoirement être son **dernier enfant**.

### 📋 NavigationView
Composant Material Design qui affiche le menu (`app:menu`) et l'en-tête (`app:headerLayout`) du drawer.

### 🔁 FragmentManager & Transactions
```java
getSupportFragmentManager()
    .beginTransaction()
    .replace(R.id.contenu, new BlankFragment())
    .commit();
```
- `replace()` : remplace le fragment affiché dans le `FrameLayout`
- `commit()` : valide et applique la transaction

### 📊 ListFragment
Fragment natif Android qui génère et gère son propre `ListView` **sans XML supplémentaire** — il suffit de lui passer un `ArrayAdapter`.

### 🎨 Vector Assets
Icônes vectorielles créées via **New → Vector Asset → Clip Art**, redimensionnables sans perte de qualité.

---

## 🛠️ Technologies utilisées

| Élément | Détail |
|---|---|
| Langage | Java |
| Min SDK | API 24 (Android 7.0 Nougat) |
| IDE | Android Studio |
| Composants | DrawerLayout, NavigationView, FragmentManager |
| Librairies | AndroidX AppCompat, Material Components |

## 🎬 Démonstration

> https://github.com/user-attachments/assets/f5687de8-2ce7-481e-9ecb-58097938d0f3

---

## 🧪 Scénario de test

1. ▶️ Lancement de l'application
2. Vérification que le **Fragment Accueil** s'affiche par défaut
3. Ouverture du drawer via le bouton **☰**
4. Clic sur **Tableau de bord** → fond vert foncé ✅
5. Clic sur **Liste** → liste de 10 éléments ✅
6. Appuyer sur **Retour** → drawer se ferme ✅
7. Naviguer entre les fragments → aucun crash ✅

---

## 👤 Auteur

**DOSSAH Landry**  
ENSA Marrakech | GCDSTE S4  
Module : Programmation Mobile Android — Java
