package com.mikul.androidfragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class CountryListFragment extends Fragment {
    public interface OnItemSelectedListener {
        void onItemSelected(int position);
    }

    private OnItemSelectedListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnItemSelectedListener) {
            listener = (OnItemSelectedListener) context;
        } else {
            throw new ClassCastException(context.toString() + " must implement OnItemSelectedListener");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_country_list, container, false);

        String[] countries = getResources().getStringArray(R.array.african_countries);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, countries);

        ListView listView = view.findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view1, position, id) -> {

            if (listener != null) {
                listener.onItemSelected(position);
            }

        });
        return view;
    }
}
