package com.example.day13.presenter;

import com.example.day13.base.BasePresenter;
import com.example.day13.bean.JavaBean;
import com.example.day13.model.MainModel;
import com.example.day13.net.MainCallBack;
import com.example.day13.view.MainView;

public class MainPresenter extends BasePresenter<MainView> implements MainCallBack {

    private MainModel mainModel;

    @Override
    protected void initModel() {
        mainModel = new MainModel();
        addModel(mainModel);
    }

    @Override
    public void onSuccess(JavaBean bean) {
        mView.setData(bean);
    }

    @Override
    public void onFaild(String string) {
        mView.showToast(string);
    }

    public void getDatap() {
        mainModel.getDatam(this);
    }
}
