package com.kpsharp.omdbsearch.modules;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = EspressoTestModule.class)
public interface EspressoTestComponent extends ApplicationComponent {
}
