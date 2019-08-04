package co.ocha.cardproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

public class RegisterExistedPersonActivity extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_existed_person);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register_existed_person, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class RegistedByIDFragment extends Fragment {
       AppCompatButton continue_by_id;
       Intent intent;
        private static final String ARG_SECTION_NUMBER = "section_number";

        public RegistedByIDFragment () {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static RegistedByIDFragment  newInstance(int sectionNumber) {
            RegistedByIDFragment  fragment = new RegistedByIDFragment ();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_register_existed_person_by_id, container, false);

            return rootView;
        }

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            continue_by_id = view.findViewById(R.id.search_card_button_by_id);
            continue_by_id.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent = new Intent(getContext(),CardActivity.class);
                    startActivity(intent);
                }
            });
        }
    }

    public static class RegistedBySearchFragment extends Fragment {
        AppCompatButton continue_by_search;
        Intent intent;
        private static final String ARG_SECTION_NUMBER = "section_number";

        public RegistedBySearchFragment () {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static RegistedBySearchFragment  newInstance(int sectionNumber) {
            RegistedBySearchFragment  fragment = new RegistedBySearchFragment ();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_register_existed_person_by_search, container, false);

            return rootView;
        }

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            continue_by_search = view.findViewById(R.id.search_card_button_by_search2);
            continue_by_search.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent = new Intent(getContext(),CardActivity.class);
                    startActivity(intent);
                }
            });
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment;

            switch (position){
                case 0:
                    fragment = RegistedByIDFragment.newInstance(position+1);
                    break;
                case 1:
                    fragment = RegistedBySearchFragment.newInstance(position+1);
                    break;

                default:
                    fragment = RegistedByIDFragment.newInstance(position+1);
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
