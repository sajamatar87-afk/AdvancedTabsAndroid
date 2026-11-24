package com.example.advancedtabsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TabFragment extends Fragment {

    private static final String ARG_POSITION = "position";
    private static final String[] TITLES = {"First", "Second", "Third"};

    public static TabFragment newInstance(int position) {
        TabFragment fragment = new TabFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab, container, false);
        int position = getArguments() != null
                ? getArguments().getInt(ARG_POSITION, 0) : 0;

        TextView title = view.findViewById(R.id.tabTitle);
        TextView description = view.findViewById(R.id.tabDescription);

        title.setText(TITLES[position] + " Tab");
        description.setText("This is the " + TITLES[position]
                + " tab. Swipe left or right to move between tabs.");

        return view;
    }
}
