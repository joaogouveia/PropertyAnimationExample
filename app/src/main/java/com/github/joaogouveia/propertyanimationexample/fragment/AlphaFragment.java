package com.github.joaogouveia.propertyanimationexample.fragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.github.joaogouveia.propertyanimationexample.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AlphaFragment extends Fragment {

    @Bind(R.id.view)
    View view;

    @Bind(R.id.button)
    Button button;


    public static AlphaFragment newInstance() {
        AlphaFragment fragment = new AlphaFragment();
        return fragment;
    }

    public AlphaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.button)
    void run(){
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator animAlphaIn = ObjectAnimator.ofFloat(view, "alpha", 1f, 0f);
        ObjectAnimator animAlphaOut = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f);
        animatorSet.playSequentially(animAlphaIn, animAlphaOut);
        animatorSet.setDuration(1000);
        animatorSet.setInterpolator(new FastOutSlowInInterpolator());
        animatorSet.start();
    }


}
