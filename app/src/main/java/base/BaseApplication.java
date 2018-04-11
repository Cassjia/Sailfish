package base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.util.LinkedList;

public class BaseApplication extends Application {
    private static Context context;
    private static String TAG;
    private static LinkedList<Activity> activityLinkedList;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        TAG = context.getClass().getSimpleName();
        Thread.setDefaultUncaughtExceptionHandler(new CrashHandler(this));
        activityLinkedList = new LinkedList<>();

        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle bundle) {
                activityLinkedList.add(activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                activityLinkedList.remove(activity);
            }
        });


    }

    /**
     * 显示正在运行的app
     */
    public static void showList() {
        for (Activity activity : activityLinkedList) {
            Log.d(TAG, "showList" + activity.getLocalClassName());
        }
    }

    /**
     * 退出App
     */
    public static void exitAppList() {
        for (Activity activity : activityLinkedList) {
            activity.finish();
        }
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    /**
     * 做一些内存回收工作
     *
     * @param level 不同等级
     */
    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }

    public static Context getContext() {
        return context;
    }


}
