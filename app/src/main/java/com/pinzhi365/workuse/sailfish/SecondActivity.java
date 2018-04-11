package com.pinzhi365.workuse.sailfish;

import android.os.Bundle;
import android.support.annotation.Nullable;

public class SecondActivity extends BaseActivity {
    private final static String url="https://m2.pinzhi365.com/app/phone/104/execute.do?&username=%E6%B5%8B%E8%AF%95%E8%B4%A6%E6%88%B7106&source=android&orderType=33&pageSize=5&currentPage=1&type=0&version=3.5.2";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
