package com.dailycodebuffer.springsecurityclient.eventpackage;

import com.dailycodebuffer.springsecurityclient.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;
@Getter
@Setter
public class RegistationCompleteEvent extends ApplicationEvent {
    private User user;
    private String applicationUrl;
    public RegistationCompleteEvent(User user, String applicationUrl) {
        super(user);
        this.user=user;
        this.applicationUrl=applicationUrl;
    }
}
