package com.dailycodebuffer.springsecurityclient.service;

import com.dailycodebuffer.springsecurityclient.entity.User;
import com.dailycodebuffer.springsecurityclient.entity.VerificationToken;
import com.dailycodebuffer.springsecurityclient.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface UserService {
     void changePassword(User user, String newPassword) ;


    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);

    String validateVerification(String token);

    VerificationToken generateNewVerificationToken(String oldtoken);


    User findUserByEmail(String email);

    void createPasswordRestTokenForUser(User user, String token);

    String validatePasswordResetToken(String token);

    Optional<User> getUserByPasswordResetToken(String token);

    boolean checkIfValidOldPassword(User user, String oldPassword);
}
