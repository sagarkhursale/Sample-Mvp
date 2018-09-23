package com.sagar.samplemvp.root;

import com.sagar.samplemvp.login.LoginActivity;
import com.sagar.samplemvp.login.LoginModule;

import javax.inject.Singleton;
import dagger.Component;



@Singleton
@Component(modules = {ApplicationModule.class, LoginModule.class})
public interface ApplicationComponent {

    void inject(LoginActivity target);

}
