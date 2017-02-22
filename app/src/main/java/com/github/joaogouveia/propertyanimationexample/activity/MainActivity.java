package com.github.joaogouveia.propertyanimationexample.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.github.joaogouveia.propertyanimationexample.R;
import com.github.joaogouveia.propertyanimationexample.fragment.AlphaFragment;
import com.github.joaogouveia.propertyanimationexample.fragment.ColorFragment;
import com.github.joaogouveia.propertyanimationexample.fragment.CustomFragment;
import com.github.joaogouveia.propertyanimationexample.fragment.PivotRotationFragment;
import com.github.joaogouveia.propertyanimationexample.fragment.RotationFragment;
import com.github.joaogouveia.propertyanimationexample.fragment.ScaleFragment;
import com.github.joaogouveia.propertyanimationexample.fragment.TranslationFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.navigation_view)
    NavigationView navigationView;
    @Bind(R.id.drawer)
    DrawerLayout drawerLayout;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        ButterKnife.bind(this);
        initToolbar();
        initNavigationView();
        initDrawer();
        navigationView.setCheckedItem(R.id.alpha);
        setFragment(AlphaFragment.newInstance());
    }

    private void initDrawer() {
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    private void initNavigationView() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                switch (menuItem.getItemId()) {
                    case R.id.alpha:
                        setFragment(AlphaFragment.newInstance());
                        toolbar.setTitle("Alpha");
                        return true;
                    case R.id.rotation:
                        setFragment(RotationFragment.newInstance());
                        toolbar.setTitle("Rotation");
                        return true;
                    case R.id.translation:
                        setFragment(TranslationFragment.newInstance());
                        toolbar.setTitle("Translation");
                        return true;
                    case R.id.scale:
                        setFragment(ScaleFragment.newInstance());
                        toolbar.setTitle("Scale");
                        return true;
                    case R.id.pivot_rotation:
                        setFragment(PivotRotationFragment.newInstance());
                        toolbar.setTitle("Pivot + Rotation");
                        return true;
                    case R.id.color:
                        setFragment(ColorFragment.newInstance());
                        toolbar.setTitle("Color");
                        return true;
                    case R.id.custom:
                        setFragment(CustomFragment.newInstance());
                        toolbar.setTitle("Custom");
                        return true;
                    default:
                        Toast.makeText(getApplicationContext(), "Somethings Wrong", Toast.LENGTH_SHORT).show();
                        return true;

                }
            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

}
