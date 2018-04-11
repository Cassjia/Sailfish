package com.pinzhi365.workuse.sailfish2;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class SecondActivity extends BaseActivity {
    private final static String url = "https://m2.pinzhi365.com/app/phone/104/execute" +
            ".do?&username=%E6%B5%8B%E8%AF%95%E8%B4%A6%E6%88%B7106&source=android&orderType=33" +
            "&pageSize=5&currentPage=1&type=0&version=3.5.2";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(new UserAdapter(this));

//        ActivitySecondBinding binding = DataBindingUtil.setContentView(this, R.layout
//                .activity_second);
//
//        RecyclerView recyclerView=binding.recycler_view_test;
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void statLoading() {
        super.statLoading();
    }

    @Override
    public void onLoadSucess(String data) {
        super.onLoadSucess(data);
    }
}
