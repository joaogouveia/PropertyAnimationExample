package com.github.joaogouveia.propertyanimationexample.fragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.github.joaogouveia.propertyanimationexample.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ScaleFragment extends Fragment {

    @Bind(R.id.view)
    View view;

    public static ScaleFragment newInstance() {
        ScaleFragment fragment = new ScaleFragment();
        return fragment;
    }

    public ScaleFragment() {
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
    void run() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator animScaleXIn = ObjectAnimator.ofFloat(view, "scaleX", 2f);
        ObjectAnimator animScaleXOut = ObjectAnimator.ofFloat(view, "scaleX", 1f);
        animatorSet.playSequentially(animScaleXIn, animScaleXOut);
        ObjectAnimator animScaleYIn = ObjectAnimator.ofFloat(view, "scaleY", 0.5f);
        ObjectAnimator animScaleYOut = ObjectAnimator.ofFloat(view, "scaleY", 1f);
        animatorSet.playSequentially(animScaleYIn, animScaleYOut);
        animatorSet.setDuration(1000);
        animatorSet.setInterpolator(new FastOutSlowInInterpolator());
        animatorSet.start();
    }


}
