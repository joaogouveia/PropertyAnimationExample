package com.github.joaogouveia.propertyanimationexample.fragment;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Fragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.joaogouveia.propertyanimationexample.R;
import com.github.joaogouveia.propertyanimationexample.util.SimpleAnimatorListener;

import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ColorFragment extends Fragment {

    @Bind(R.id.view)
    View view;

    public static ColorFragment newInstance() {
        ColorFragment fragment = new ColorFragment();
        return fragment;
    }

    public ColorFragment() {
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
        animateColorChange(getRandomColor());
    }


    private void animateColorChange(int newColor) {
        Integer colorFrom = ((ColorDrawable) view.getBackground()).getColor();
        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, newColor);
        colorAnimation.setDuration(300);
        colorAnimation.setInterpolator(new FastOutSlowInInterpolator());
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                view.setBackgroundColor((Integer) animator.getAnimatedValue());
            }

        });
        colorAnimation.start();
    }

    private int getRandomColor(){
        int R = (int)(Math.random()*256);
        int G = (int)(Math.random()*256);
        int B= (int)(Math.random()*256);
        return Color.rgb(R, G, B); //random color, but can be bright or dull
    }

}
