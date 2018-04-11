package base;

public interface BaseProxy {
    void sendHttp(String url);

    void createView();

    void resumeView();

    void pauseView();

    void destoryView();
}
