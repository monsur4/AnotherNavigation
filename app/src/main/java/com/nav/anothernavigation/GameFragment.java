package com.nav.anothernavigation;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class GameFragment extends Fragment {

    public GameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_game, container, false);
        AppCompatButton button = view.findViewById(R.id.navigate_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GameFragmentDirections.ActionGameFragmentToResultFragment2 actionGameToResult
                        = GameFragmentDirections.actionGameFragmentToResultFragment2();
                //actionGameToResult.setMyArg(356);
                NavHostFragment.findNavController(GameFragment.this).navigate(actionGameToResult);
            }
        });
        return view;
    }
}
