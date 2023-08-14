package com.mikul.androidfragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class CountryDetailFragment extends Fragment {
    private static final String ARG_COUNTRY_INDEX = "country_index";

    public static CountryDetailFragment newInstance(int countryIndex) {
        CountryDetailFragment fragment = new CountryDetailFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COUNTRY_INDEX, countryIndex);
        fragment.setArguments(args);
        return fragment;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_country_detail, container, false);

        TextView countryDetailsTextView = view.findViewById(R.id.country_details);
        TextView countryNameTextView = view.findViewById(R.id.country_name);
        TextView countryPopulationTextView = view.findViewById(R.id.country_population);
        TextView countryLanguageTextView = view.findViewById(R.id.country_language);
        TextView countryStatesTextView = view.findViewById(R.id.country_states);
        TextView countryGdpTextView = view.findViewById(R.id.country_gdp);

        assert getArguments() != null;
        int countryIndex = getArguments().getInt(ARG_COUNTRY_INDEX);
        String[] countries = getResources().getStringArray(R.array.african_countries);
        String[] countryDetails = getResources().getStringArray(R.array.country_details);
        String[] countryPopulations = getResources().getStringArray(R.array.country_populations);
        String[] countryLanguages = getResources().getStringArray(R.array.country_languages);
        String[] countryStates = getResources().getStringArray(R.array.country_states);
        String[] countryGdps = getResources().getStringArray(R.array.country_gdps);

        countryNameTextView.setText(countries[countryIndex]);
        countryDetailsTextView.setText(countryDetails[countryIndex]);
        countryPopulationTextView.setText(countryPopulations[countryIndex]);
        countryLanguageTextView.setText(countryLanguages[countryIndex]);
        countryStatesTextView.setText(countryStates[countryIndex]);
        countryGdpTextView.setText(countryGdps[countryIndex]);

        return view;
    }
}
