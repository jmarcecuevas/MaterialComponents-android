package com.luckycode.materialcomp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BottomSheetActivity extends AppCompatActivity {
    @BindView(R.id.recycler)
    protected RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet);
        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setAdapter(new GridAdapter());
    }

    @OnClick(R.id.btn_bottom_sheet_dialog)
    public void showBottomSheetDialog(View view){
        BottomSheetFragment bottomSheetFragment = new BottomSheetFragment();
        bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
