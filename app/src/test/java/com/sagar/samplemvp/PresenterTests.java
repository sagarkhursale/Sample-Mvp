package com.sagar.samplemvp;

import com.sagar.samplemvp.login.LoginActivityMvp;
import com.sagar.samplemvp.login.LoginActivityPresenter;
import com.sagar.samplemvp.login.User;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;


public class PresenterTests {

    LoginActivityMvp.View mockView;
    LoginActivityMvp.Model mockLoginModel;
    LoginActivityMvp.Presenter presenter;
    User user;


    @Before
    public void setup() {

        mockLoginModel = mock(LoginActivityMvp.Model.class);

        user = new User("Fox", "Mulder");

        when(mockLoginModel.getUser()).thenReturn(user);

        mockView = mock(LoginActivityMvp.View.class);

        presenter = new LoginActivityPresenter(mockLoginModel);

        presenter.setView(mockView);
    }


    /*// Test 1
    @Test
    public void noInteractionWithView(){
        presenter.getCurrentUser();

        verifyZeroInteractions(mockView);
    }
    */


    // Test 2
    @Test
    public void loadTheUserFromRepoWhenValidUserIsPresent() {

        when(mockLoginModel.getUser()).thenReturn(user);

        presenter.getCurrentUser();

        // verify model interaction
        verify(mockLoginModel, times(1)).getUser();

        // verify view interactions
        verify(mockView, times(1)).setFirstName("Fox");
        verify(mockView, times(1)).setLastName("Mulder");
        verify(mockView, never()).showUserNotAvailable();
    }


    // END
}
