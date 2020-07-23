package com.example.day13;

import android.os.Bundle;
import android.widget.Toast;

import com.example.day13.adapter.RcyAdapter;
import com.example.day13.base.BaseActivity;
import com.example.day13.bean.JavaBean;
import com.example.day13.presenter.MainPresenter;
import com.example.day13.view.MainView;

import java.util.ArrayList;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {

    @BindView(R.id.rcy)
    RecyclerView rcy;
    private ArrayList<JavaBean.DataBean.DatasBean> datasBeans;
    private RcyAdapter rcyAdapter;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);
//    }

    @Override
    protected void initPresenter() {
        mPresenter=new MainPresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        rcy.setLayoutManager(new LinearLayoutManager(this));
        rcy.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        datasBeans = new ArrayList<>();
        rcyAdapter = new RcyAdapter(datasBeans, this);
        rcy.setAdapter(rcyAdapter);
    }

    @Override
    protected void initData() {
        mPresenter.getDatap();
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void setData(JavaBean bean) {
        if (bean!=null && bean.getData().getDatas()!=null){
            datasBeans.addAll(bean.getData().getDatas());
            rcyAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void showToast(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }
}
