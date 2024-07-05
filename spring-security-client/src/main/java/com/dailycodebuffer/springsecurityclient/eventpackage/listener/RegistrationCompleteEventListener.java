package com.dailycodebuffer.springsecurityclient.eventpackage.listener;

import com.dailycodebuffer.springsecurityclient.entity.User;
import com.dailycodebuffer.springsecurityclient.eventpackage.RegistationCompleteEvent;
import com.dailycodebuffer.springsecurityclient.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Slf4j
@Component
public class RegistrationCompleteEventListener implements ApplicationListener<RegistationCompleteEvent> {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
   private UserService userService;
    @Override
    public void onApplicationEvent(RegistationCompleteEvent event) {
      User user =event.getUser();
      String token= UUID.randomUUID().toString();
      userService.saveVerificationTokenForUser(token,user);
      String url=event.getApplicationUrl()+"/verifyRegistration?token="+token;
      log.info("Click the link to verify your account: {}",url);

    }
}
