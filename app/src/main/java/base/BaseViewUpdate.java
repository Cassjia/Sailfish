package base;

public interface BaseViewUpdate {
    void statLoading();

    void onLoadSucess(String data);

    void onLoadFalid(String reason);
}
