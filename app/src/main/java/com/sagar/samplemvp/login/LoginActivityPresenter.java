package com.sagar.samplemvp.login;


public class LoginActivityPresenter implements LoginActivityMvp.Presenter {

    private LoginActivityMvp.View view;
    private LoginActivityMvp.Model model;


    public LoginActivityPresenter(LoginActivityMvp.Model model) {
        this.model = model;
    }


    @Override
    public void setView(LoginActivityMvp.View view) {
        this.view = view;
    }


    @Override
    public void loginButtonClicked() {
        if (view != null) {

            if (view.getFirstName().isEmpty() || view.getLastName().isEmpty()) {
                view.showInputError();
            } else {
                model.creatUser(view.getFirstName(), view.getLastName());
                view.showUserSavedMessage();
            }

        }
    }


    @Override
    public void getCurrentUser() {
        User user = model.getUser();

        if (user == null) {
            if (view != null) {
                view.showUserNotAvailable();
            }
        } else {
            if (view != null) {
                view.setFirstName(user.getFirstName());
                view.setLastName(user.getLastName());
            }
        }
    }

    // END
}
