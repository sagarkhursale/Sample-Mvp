package com.sagar.samplemvp.login;



public interface LoginActivityMvp {


    interface View {

        String getFirstName();
        String getLastName();

        void showUserNotAvailable();
        void showInputError();
        void showUserSavedMessage();

        void setFirstName(String firstName);
        void setLastName(String lastName);

    }


    interface Presenter {

        void setView(LoginActivityMvp.View view);

        void loginButtonClicked();

        void getCurrentUser();
    }


    interface Model {

        void creatUser(String fname,String lname);

        User getUser();

    }


    // END
}
