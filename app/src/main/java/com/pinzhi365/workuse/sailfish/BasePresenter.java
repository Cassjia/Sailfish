package com.pinzhi365.workuse.sailfish;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;

import net.MyHttpClient;

import java.io.IOException;

import base.BaseProxy;
import base.BaseViewUpdate;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class BasePresenter implements BaseProxy {
    public HandlerThread handlerThread;
    public Handler mHandler;
    public BaseViewUpdate baseViewUpdate;

    private String TAG;


    public BasePresenter() {
    }

    public BasePresenter(String TAG) {
        this.TAG = TAG;
    }


    @Override
    public void createView() {
        handlerThread = new HandlerThread(TAG);
        handlerThread.start();

    }

    @Override
    public void destoryView() {

    }

    @Override
    public void resumeView() {
        baseViewUpdate = BaseActivity.getView();
    }

    @Override
    public void pauseView() {

    }

    @Override
    public void sendHttp(final String url) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                OkHttpClient okHttpClient = (MyHttpClient.getInstance());
                Request request = new Request.Builder().url(url).build();
                try {
                    Response response = okHttpClient.newCall(request).execute();
                    String mResponse = response.body().string();
                    Log.i("OKHttp", String.format("Received response for %s response body" +
                            " is %n%s", response.request().url(), mResponse));
                    Message message = Message.obtain();
                    Bundle bundle = new Bundle();
                    bundle.putString("arg", mResponse);
                    message.setData(bundle);
                    mHandler.sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
