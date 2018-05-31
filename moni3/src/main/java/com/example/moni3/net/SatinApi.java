package com.example.moni3.net;

import com.example.moni3.bean.SatinBean;

import io.reactivex.Observable;

public class SatinApi {
    private static SatinApi satinApi;
    private SatinApiService satinApiService;

    public SatinApi(SatinApiService satinApiService) {
        this.satinApiService = satinApiService;
    }

    public static SatinApi getSatinApi(SatinApiService satinApiService){
        if (satinApi==null){
            satinApi=new SatinApi(satinApiService);
        }
        return satinApi;
    }
    public Observable<SatinBean> getSatinApi(){
        return satinApiService.getSatin();
    }
}
