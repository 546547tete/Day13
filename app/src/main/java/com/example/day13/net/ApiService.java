package com.example.day13.net;

import com.example.day13.bean.JavaBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    String BASE_URL="https://www.wanandroid.com/";

    @GET("project/list/1/json?cid=294")
    Observable<JavaBean> getJson();
}
