package com.example.day13.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseModel {
    private CompositeDisposable mDisposable=null;
    public void addDispose(Disposable disposable){
        if (mDisposable==null){
            synchronized (BaseModel.class){
                if (mDisposable==null){
                    mDisposable=new CompositeDisposable();
                }
            }
        }
        mDisposable.add(disposable);
    }
    public void dispose(){
        if (mDisposable!=null){
            mDisposable.dispose();
        }
    }
    public void removeDispose(Disposable disposable){
        if (mDisposable!=null){
            mDisposable.remove(disposable);
        }
    }
}
