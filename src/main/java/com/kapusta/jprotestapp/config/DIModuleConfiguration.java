package com.kapusta.jprotestapp.config;

import com.google.inject.AbstractModule;
import com.google.inject.Scope;
import com.google.inject.Scopes;
import com.kapusta.jprotestapp.controller.HelpSceneController;
import com.kapusta.jprotestapp.service.Counter;
import com.kapusta.jprotestapp.service.CounterImpl;

public class DIModuleConfiguration extends AbstractModule {

    @Override
    protected void configure() {
        bind(Counter.class).to(CounterImpl.class).in(Scopes.SINGLETON);
    }
}
