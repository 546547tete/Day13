package com.example.day13.model;

import com.example.day13.base.BaseModel;
import com.example.day13.bean.JavaBean;
import com.example.day13.net.ApiService;
import com.example.day13.net.MainCallBack;
import com.example.day13.presenter.MainPresenter;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModel extends BaseModel {

    public void getDatam(MainCallBack callBack) {
        Retrofit build = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = build.create(ApiService.class);
        Observable<JavaBean> json = apiService.getJson();
        json.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JavaBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDispose(d);
                    }

                    @Override
                    public void onNext(JavaBean bean) {
                        callBack.onSuccess(bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFaild(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
