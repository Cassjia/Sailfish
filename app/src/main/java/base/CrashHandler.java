package base;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Looper;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Date;

import util.CrashUtil;
import util.DateUtils;

/**
 * 全局未捕获的异常
 *
 * @author coffee<br>
 *         2013-1-11上午11:08:54
 */
public class CrashHandler implements UncaughtExceptionHandler {

    private Context mContext;

    /**
     * @param ctx
     */
    public CrashHandler(Context ctx) {
        mContext = ctx;
    }

    /**
     * 当UncaughtException发生时会转入该函数来处理
     */
    @Override
    public void uncaughtException(Thread thread, final Throwable ex) {
        ex.printStackTrace();
        new Thread() {
            public void run() {
                Looper.prepare();
                String errorTitle = ex.getMessage();
                // 收集设备信息
                String deviceInfo = getDeviceInfo(mContext, errorTitle);
                // 保存错误报告文件
                String errorInfo = getErrorInfo(ex);
                saveErrorLog(deviceInfo + errorInfo);
                android.os.Process.killProcess(android.os.Process.myPid());
                Looper.loop();
            }
        }.start();
    }

    private static final String LINE = System.getProperty("line.separator");

    private static String getAppVersion() {
        try {
            return BaseApplication.getContext().getPackageManager().getPackageInfo(BaseApplication.getContext().getPackageName(), Context.MODE_PRIVATE).versionName;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return "未知";
    }

    /**
     * 收集程序崩溃的设备信息
     *
     * @param ctx
     */
    public String getDeviceInfo(Context ctx, String title) {
        StringBuilder sb = new StringBuilder();
        sb.append(title).append(LINE);
        sb.append("品质365_").append(getAppVersion()).append(LINE);
//        sb.append("username: ").append(username).append(LINE);
        sb.append("CpuAbility: ").append(Build.CPU_ABI).append(LINE);
        sb.append("Brand: ").append(Build.BRAND).append(LINE);
        sb.append("Model: ").append(Build.MODEL).append(LINE);
        sb.append("FingerPrint: ").append(Build.FINGERPRINT).append(LINE);
        sb.append("Version.Release: ").append(Build.VERSION.RELEASE).append(LINE);
        sb.append("SDKInt: ").append(Build.VERSION.SDK_INT).append(LINE);
        //
        String deviceInfo = sb.toString();
        sb.delete(0, sb.length());
        return deviceInfo;
    }

    /**
     * 异常信息
     */
    public String getErrorInfo(Throwable ex) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        ex.printStackTrace(ps);
        final String errorMsg = new String(baos.toByteArray());
        return errorMsg;
    }

    public static void saveErrorLog(String info) {
        try {
            String time = DateUtils.format(new Date());
            time = time.replace(" ", "_");
            String fileName = getAppVersion() + "_" + time + ".log";
            File dir = new File(CrashUtil.getCrashDir());
            if (!dir.exists()) {
                dir.mkdirs();
            }
            FileOutputStream fos = new FileOutputStream(new File(dir, fileName));
            fos.write(info.getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
