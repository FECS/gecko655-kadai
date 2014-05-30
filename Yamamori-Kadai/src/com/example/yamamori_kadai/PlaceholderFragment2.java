package com.example.yamamori_kadai;

import java.util.Locale;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PlaceholderFragment2 extends ListFragment {
    final private String defaultAlphabets="abcdefghijklmnopqrstuvwxyz";

    public PlaceholderFragment2() {
    }

    @SuppressLint("DefaultLocale")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.scroll_fragment, container,
                false);
        ListView listView = (ListView) rootView.findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);
        char[] alphabets = defaultAlphabets.toCharArray();
        for(char alph: alphabets){
            adapter.add(String.valueOf(alph));
        }
        for(char alph: alphabets){
            adapter.add(String.valueOf(alph).toUpperCase(Locale.JAPAN));
        }
        return rootView;
    }
}
