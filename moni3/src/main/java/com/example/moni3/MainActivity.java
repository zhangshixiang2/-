package com.example.moni3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.moni3.adapter.SatinAdapter;
import com.example.moni3.base.BaseActivity;
import com.example.moni3.bean.SatinBean;
import com.example.moni3.contract.SatinContract;
import com.example.moni3.module.DaggerHttpComponent;
import com.example.moni3.module.HttpModule;
import com.example.moni3.presenter.SatinPresenter;

import java.util.List;

public class MainActivity extends BaseActivity<SatinPresenter> implements SatinContract.View, View.OnClickListener {

    private RecyclerView mRcv;
    /**
     * 跳转
     */
    private Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httpModule(new HttpModule())
                .build()
                .inject(this);


    }

    @Override
    public void getSatinSuccess(SatinBean satinBean) {
        List<SatinBean.DataBean> data = satinBean.getData();
        SatinAdapter satinAdapter = new SatinAdapter(MainActivity.this, data);
        mRcv.setAdapter(satinAdapter);


    }

    private void initView() {
        mRcv = (RecyclerView) findViewById(R.id.rcv);

        mRcv.setLayoutManager(new LinearLayoutManager(this));

        mPresenter.getSatin();
        mBtn = (Button) findViewById(R.id.btn);
        mBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn:
                Intent intent = new Intent(MainActivity.this,ListActivity.class );
                startActivity(intent);
                break;
        }
    }
}
