package com.github.joaogouveia.propertyanimationexample.fragment;

import android.animation.Animator;
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
import com.github.joaogouveia.propertyanimationexample.util.SimpleAnimatorListener;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PivotRotationFragment extends Fragment {

    @Bind(R.id.view)
    View view;

    public static PivotRotationFragment newInstance() {
        PivotRotationFragment fragment = new PivotRotationFragment();
        return fragment;
    }

    public PivotRotationFragment() {
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

        view.setPivotX(0f);
        view.setPivotY(0f);
        //.withEndAction e .withStartAction podem ser usados em caso de API 16+
        view.animate()
                .setInterpolator(new FastOutSlowInInterpolator())
                .setDuration(1000)
                .rotation(180f)
                .setListener(new SimpleAnimatorListener() {
                    @Override
                    public void onAnimationEnd(Animator animator) {
                        view.animate()
                                .setInterpolator(new FastOutSlowInInterpolator())
                                .setDuration(1000)
                                .rotation(0f);
                    }
                });

    }


}
