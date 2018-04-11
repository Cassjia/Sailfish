package util;

import android.os.Environment;

import base.BaseApplication;

public class CrashUtil {
    public static String SAILFISH = Environment.getExternalStorageDirectory() + "/salifish";
    /**
     * 应用崩溃日志
     */
    public static String getCrashDir() {
        String dir = "";
        if ( Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState
                ())) {
            dir = SAILFISH + "/crash";
        } else {
            // /data/data/com.pinzhi.activity/app_crash
            dir = BaseApplication.getContext().getDir("crash", 0).getAbsolutePath();
        }
        return dir;
    }
}
