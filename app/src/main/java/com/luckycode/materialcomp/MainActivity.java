package com.luckycode.materialcomp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindBitmap;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_bottom_sheet)
    public void goToBottomSheetActivity(View view){
        Intent intent = new Intent(this,BottomSheetActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_feature_highlight)
    public void goToFeatureHighlightActivity(View view){
        Intent intent = new Intent(this,FeatureHighlightActivity.class);
        startActivity(intent);
    }
}
