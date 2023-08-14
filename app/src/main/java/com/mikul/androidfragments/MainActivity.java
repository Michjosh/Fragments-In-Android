package com.mikul.androidfragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements CountryListFragment.OnItemSelectedListener {
    private static final String FRAGMENT_TAG_DETAIL = "fragment_detail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container1, new CountryListFragment())
                    .commit();
        }

        if (getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG_DETAIL) == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container2, new DefaultEmptyFragment(), FRAGMENT_TAG_DETAIL)
                    .addToBackStack(null)
                    .commit();
        }
    }

    @Override
    public void onItemSelected(int position) {
        CountryDetailFragment fragment = CountryDetailFragment.newInstance(position);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container2, fragment)
                .addToBackStack(null)
                .commit();
    }
}
