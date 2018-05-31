package com.example.moni3.net;

import com.example.moni3.bean.SatinBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface SatinApiService {
    @GET("satinApi?type=1&page=1")
    Observable<SatinBean> getSatin();
}
