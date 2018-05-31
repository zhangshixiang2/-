package com.example.moni3.presenter;

import com.example.moni3.base.BasePresenter;
import com.example.moni3.bean.SatinBean;
import com.example.moni3.contract.SatinContract;
import com.example.moni3.net.SatinApi;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SatinPresenter extends BasePresenter<SatinContract.View> implements SatinContract.Presenter{
   private SatinApi satinApi;

   @Inject
    public SatinPresenter(SatinApi satinApi) {
        this.satinApi = satinApi;
    }



    @Override
    public void getSatin() {
        satinApi.getSatinApi()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<SatinBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SatinBean satinBean) {
                        if (mView != null) {
                            mView.getSatinSuccess(satinBean);
                        }

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
