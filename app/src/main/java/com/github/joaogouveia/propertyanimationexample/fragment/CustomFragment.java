package com.github.joaogouveia.propertyanimationexample.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Fragment;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.joaogouveia.propertyanimationexample.R;
import com.github.joaogouveia.propertyanimationexample.util.SimpleAnimatorListener;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CustomFragment extends Fragment {

    @Bind(R.id.view)
    View view;
    private int color;


    public static CustomFragment newInstance() {
        CustomFragment fragment = new CustomFragment();
        return fragment;
    }

    public CustomFragment() {
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

    @Override
    public void onResume() {
        super.onResume();
        ColorDrawable colorDrawable = (ColorDrawable) view.getBackground();
        color = colorDrawable.getColor();
        view.setScaleX(2f);
    }

    @OnClick(R.id.button)
    void run() {
        AnimatorSet set = new AnimatorSet();
        GradientDrawable newbackground = new GradientDrawable();
        newbackground.setColor(color);
        view.setBackgroundDrawable(newbackground);
        ObjectAnimator radiusAnimation = ObjectAnimator.ofFloat(newbackground, "cornerRadius", view.getHeight() / 2);
        ObjectAnimator viewScale = ObjectAnimator.ofFloat(view, "scaleX", 1f);
        set.playTogether(radiusAnimation, viewScale);

        set.setDuration(10000);
        set.setInterpolator(new FastOutSlowInInterpolator());
        set.start();
    }


}
