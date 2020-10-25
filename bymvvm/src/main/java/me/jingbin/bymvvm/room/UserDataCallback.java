package me.jingbin.bymvvm.room;



public interface UserDataCallback {

    /**
     * 返回数据为null
     */
    void onDataNotAvailable();

    /**
     * @param bean 返回数据
     */
    void getData(User bean);
}
