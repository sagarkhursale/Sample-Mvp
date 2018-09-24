package com.sagar.samplemvp.login;


public class LoginModel implements LoginActivityMvp.Model {

    private LoginRepository loginRepository;


    LoginModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }


    @Override
    public void creatUser(String fname, String lname) {
        loginRepository.saveUser(new User(fname, lname));
    }


    @Override
    public User getUser() {
        return loginRepository.getUser();
    }

    // END
}
