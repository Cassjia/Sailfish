package presenter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.google.gson.Gson;

import com.pinzhi365.workuse.sailfish.BasePresenter;
import model.CheckInBean;

public class NetPresenter extends BasePresenter {
    private Handler handlers;

    private NetPresenter() {
        super();
    }

    public NetPresenter(String tag) {
        super(tag);
    }

    public NetPresenter(String tag,Handler handler){
        super(tag);


        this.handlers=handler;

    }



    @Override
    public void createView() {
        super.createView();

        Log.i("Presenter", "createView()");


    }

    @Override
    public void sendHttp(String url) {
        baseViewUpdate.statLoading();
        super.sendHttp(url);
    }

    @Override
    public void resumeView() {
        super.resumeView();
        Log.i("Presenter", "resumeView()");

        mHandler = new Handler(handlerThread.getLooper()) {
            @Override
            public void handleMessage(Message msg) {
                if (msg != null) {

                    Bundle bundle = msg.getData();
                    final String response = bundle.getString("arg");
                    Gson gson = new Gson();
                    final CheckInBean checkInBean = gson.fromJson(response, CheckInBean.class);

                    handlers.post(new Runnable() {
                        @Override
                        public void run() {
                            baseViewUpdate.onLoadSucess(response);
                        }
                    });
                }
                super.handleMessage(msg);
            }
        };

    }

    @Override
    public void pauseView() {
        super.pauseView();
        Log.i("Presenter", "pauseView()");
    }

    @Override
    public void destoryView() {
        super.destoryView();
        Log.i("Presenter", "destoryView()");
    }
}
