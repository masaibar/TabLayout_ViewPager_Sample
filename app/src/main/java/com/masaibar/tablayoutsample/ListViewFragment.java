package com.masaibar.tablayoutsample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by masaibar on 2016/11/03.
 */

public class ListViewFragment extends Fragment {

    public static ListViewFragment newInstance() {

        Bundle args = new Bundle();

        ListViewFragment fragment = new ListViewFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public ListViewFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        List<String> strings = new ArrayList<>();
        strings.add("hoge");
        strings.add("fuge");
        strings.add("fuga");

        ListView listView = (ListView) view.findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, strings);

        listView.setAdapter(adapter);

        return view;
    }
}
