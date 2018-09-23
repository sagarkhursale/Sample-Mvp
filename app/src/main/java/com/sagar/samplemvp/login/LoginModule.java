package com.sagar.samplemvp.login;

import dagger.Module;
import dagger.Provides;


@Module
public class LoginModule {


    @Provides
    public LoginActivityMvp.Presenter provideLoginActivityPresenter(LoginActivityMvp.Model model) {
        return new LoginActivityPresenter(model);
    }


    @Provides
    public LoginActivityMvp.Model provideLoginActivityModel(LoginRepository repository) {
        return new LoginModel(repository);
    }


    @Provides
    public LoginRepository provideLoginRepository() {
        return new MemoryRepository();
    }


    // END
}
