package com.nav.anothernavigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ResultFragment extends Fragment {

    public ResultFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_result, container, false);
        TextView textView = view.findViewById(R.id.result_tv);
        ResultFragmentArgs args = ResultFragmentArgs.fromBundle(getArguments());
        int value = args.getMyArg();
        textView.append(String.valueOf(value));
        return view;
    }
}
