package com.pinzhi365.workuse.sailfish2;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.pinzhi365.workuse.sailfish2.databinding.ActivityMainBinding;


public class MainActivity extends BaseActivity {
    private ActivityMainBinding mainBinding;


//

//    public final ProgressBar loading_progressBar=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout
                .activity_main);

        mainBinding.setFirstName("开始");
    }

    /**
     * 点击事件
     */
    public void onClickFristName(View view) {
        baseProxy.sendHttp("https://m2.pinzhi365.com/app/phone/154/execute" +
                ".do?source=android&username=%E6%B5%8B%E8%AF%95%E8%B4%A6%E6%88%B7106" +
                "&version=3.5.2&");
    }

    @Override
    public void onLoadSucess(String data) {
        super.onLoadSucess(data);

//        (mainBinding.loadingProgressBar).setVisibility(View.GONE);
        mainBinding.setFirstName(data);
        mainBinding.setFlag(0);
        startActivity(new Intent(this, SecondActivity.class));
    }

    @Override
    public void statLoading() {
        super.statLoading();

//        (mainBinding.loadingProgressBar).setVisibility(View.VISIBLE);
        mainBinding.setFlag(1);
    }
}
