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

public class TranslationFragment extends Fragment {

    @Bind(R.id.view)
    View view;

    @Bind(R.id.button)
    Button button;


    public static TranslationFragment newInstance() {
        TranslationFragment fragment = new TranslationFragment();
        return fragment;
    }

    public TranslationFragment() {
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
        ObjectAnimator animTranslationXIn = ObjectAnimator.ofFloat(view, "translationX", 200);
        ObjectAnimator animTranslationXOut = ObjectAnimator.ofFloat(view, "translationX", 0);
        animatorSet.playSequentially(animTranslationXIn, animTranslationXOut);
        ObjectAnimator animTranslationYIn = ObjectAnimator.ofFloat(view, "translationY", 200);
        ObjectAnimator animTranslationYOut = ObjectAnimator.ofFloat(view, "translationY", 0);
        animatorSet.playSequentially(animTranslationYIn, animTranslationYOut);
        animatorSet.setDuration(1000);
        animatorSet.setInterpolator(new FastOutSlowInInterpolator());
        animatorSet.start();
    }


}
