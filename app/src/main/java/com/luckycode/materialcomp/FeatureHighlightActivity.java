package com.luckycode.materialcomp;

import android.animation.Animator;
import android.content.res.ColorStateList;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FeatureHighlightActivity extends AppCompatActivity {
    @BindView(R.id.fab)
    protected FloatingActionButton fab;

    @BindView(R.id.layoutMain)
    protected RelativeLayout layoutMain;

    @BindView(R.id.layoutButtons)
    protected RelativeLayout layoutButtons;

    @BindView(R.id.layoutContent)
    protected RelativeLayout layoutContent;

    @BindView(R.id.toolbar)
    protected Toolbar toolbar;

    private boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feature_highlight);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);


        fab.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                viewMenu();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void viewMenu() {
        if (!isOpen) {

            int x = layoutContent.getRight();
            int y = layoutContent.getBottom();

            int startRadius = 0;
            int endRadius = (int) Math.hypot(layoutMain.getWidth(), layoutMain.getHeight());

            fab.setBackgroundTintList(ColorStateList.valueOf(ResourcesCompat.getColor(getResources(),android.R.color.white,null)));
            fab.setImageResource(R.drawable.ic_close_grey);

            Animator anim = ViewAnimationUtils.createCircularReveal(layoutButtons, x, y, startRadius, endRadius);

            layoutButtons.setVisibility(View.VISIBLE);
            anim.start();

            isOpen = true;

        } else {

            int x = layoutButtons.getRight();
            int y = layoutButtons.getBottom();

            int startRadius = Math.max(layoutContent.getWidth(), layoutContent.getHeight());
            int endRadius = 0;

            fab.setBackgroundTintList(ColorStateList.valueOf(ResourcesCompat.getColor(getResources(),R.color.colorAccent,null)));
            fab.setImageResource(R.drawable.ic_plus_white);

            Animator anim = ViewAnimationUtils.createCircularReveal(layoutButtons, x, y, startRadius, endRadius);
            anim.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {

                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    layoutButtons.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationCancel(Animator animator) {

                }

                @Override
                public void onAnimationRepeat(Animator animator) {

                }
            });
            anim.start();

            isOpen = false;
        }
    }
}
