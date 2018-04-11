package com.pinzhi365.workuse.sailfish;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.lang.ref.WeakReference;

import base.BaseProxy;
import base.BaseViewUpdate;
import presenter.NetPresenter;

abstract class BaseActivity extends AppCompatActivity implements BaseViewUpdate {

public BaseProxy baseProxy;
    public Handler mHandler;
    private static WeakReference<BaseActivity> weakReference;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHandler = new Handler(getMainLooper());
        baseProxy = new NetPresenter(this.getClass().getSimpleName() + "", mHandler);
        baseProxy.createView();
        weakReference=new WeakReference<>(this);
    }

    public static BaseActivity getView() {
        return weakReference.get();
    }


    @Override
    protected void onResume() {
        super.onResume();
        baseProxy.resumeView();
    }

    @Override
    protected void onPause() {
        super.onPause();
        baseProxy.pauseView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        baseProxy.destoryView();
    }

    @Override
    public void statLoading() {


    }

    @Override
    public void onLoadSucess(String data) {

    }

    @Override
    public void onLoadFalid(String reason) {

    }
}
