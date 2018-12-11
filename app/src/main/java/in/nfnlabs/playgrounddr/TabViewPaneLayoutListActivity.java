package in.nfnlabs.playgrounddr;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import in.nfnlabs.playgrounddr.AdapterClasses.SimpleItemRecyclerViewAdapter;
import in.nfnlabs.playgrounddr.FragmentCategory.FirstFragment;
import in.nfnlabs.playgrounddr.FragmentCategory.FirstNestedFragment;
import in.nfnlabs.playgrounddr.FragmentCategory.FourthFragment;
import in.nfnlabs.playgrounddr.FragmentCategory.SecondFragment;
import in.nfnlabs.playgrounddr.FragmentCategory.TabViewPaneLayoutDetailFragment;
import in.nfnlabs.playgrounddr.FragmentCategory.ThirdFragment;
import in.nfnlabs.playgrounddr.model.ListPaneModel;

import java.util.ArrayList;
import java.util.List;

/**
 * An activity representing a list of Notes. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link TabViewPaneLayoutDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class TabViewPaneLayoutListActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    FirstFragment firstFragment;
    SecondFragment secondFragment;
    ThirdFragment thirdFragment;
    FourthFragment fourthFragment;
    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;
    private static final String TAG = "TabViewPaneLayoutListAc";

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    private Fragment fragment = null;
    private Fragment fragmentClass;
    private FragmentManager fragmentManager;
    private NavigationView nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabviewpanelayout_list);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(false);
        toggle.syncState();

        nav = (NavigationView) findViewById(R.id.nav);
        nav.setNavigationItemSelectedListener(this);
        //setupDrawerContent(nav);


        selectDrawerItem(R.id.nav_camera);


/**
 * default selected item in Navigation menu
 */
/*
        if (savedInstanceState == null) {
            // Insert the fragment_landing by replacing any existing fragment_landing
            fragmentClass = FirstFragment.class;
            fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.tabviewpanelayout_detail_container, fragment_landing).commit();
            // Highlight the selected item has been done by NavigationView
            nav.getMenu().findItem(0).setChecked(true);
        }*/

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (drawer.isDrawerOpen(Gravity.RIGHT)) {
                    drawer.closeDrawer(Gravity.RIGHT);
                } else {
                    drawer.openDrawer(Gravity.RIGHT);
                }
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        if (findViewById(R.id.tabviewpanelayout_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }

    }

    /*private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;

                    }
                });

    }*/

    public void selectDrawerItem(int menuItemId) {
        // Create a new fragment_landing and specify the fragment_landing to show based on nav item clickedz
        switch (menuItemId) {
            case R.id.nav_camera:
                if (firstFragment == null)
                    firstFragment = new FirstFragment();
                fragmentClass = firstFragment;
                break;
            case R.id.nav_gallery:
                if (secondFragment == null)
                    secondFragment = new SecondFragment();
                fragmentClass = secondFragment;
                break;
            case R.id.nav_manage:
                if (thirdFragment == null)
                    thirdFragment = new ThirdFragment();
                fragmentClass = thirdFragment;
                break;
            case R.id.nav_share:
                if (fourthFragment == null)
                    fourthFragment = new FourthFragment();
                fragmentClass = fourthFragment;
                break;
            case R.id.nav_send:
                if (fourthFragment == null)
                    fourthFragment = new FourthFragment();
                fragmentClass = fourthFragment;
                break;
            default:
        }

        // Insert the fragment_landing by replacing any existing fragment_landing

            getSupportFragmentManager().beginTransaction().replace(R.id.tabviewpanelayout_detail_container, fragmentClass).commit();

        // Highlight the selected item has been done by NavigationView

        // Set action bar title

        // Close the navigation drawer

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sample, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {

        selectDrawerItem(menuItem.getItemId());
        menuItem.setChecked(true);

        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

//    private void setupRecyclerView(@NonNull Recyc2lerView recyclerView) {
//        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(this, listitems, mTwoPane));
//    }


}
