package com.example.moni3.module;

import com.example.moni3.MainActivity;

import dagger.Component;


@Component(modules=HttpModule.class)
public interface HttpComponent {
    void inject(MainActivity mainActivity);
}
