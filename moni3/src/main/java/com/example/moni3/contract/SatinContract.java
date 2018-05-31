package com.example.moni3.contract;

import com.example.moni3.base.BaseContract;
import com.example.moni3.bean.SatinBean;

public interface SatinContract {
    interface View extends BaseContract.BaseView{
        void getSatinSuccess(SatinBean satinBean);
    }
    interface Presenter extends BaseContract.BasePresenter<View>{
        void  getSatin();
    }
}
