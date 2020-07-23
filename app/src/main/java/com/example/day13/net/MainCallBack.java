package com.example.day13.net;

import com.example.day13.bean.JavaBean;

public interface MainCallBack {
    void onSuccess(JavaBean bean);
    void onFaild(String string);
}
