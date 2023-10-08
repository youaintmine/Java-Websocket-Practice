package com.ash.websocket.starter.cicada.practice.service;

import com.ash.websocket.starter.cicada.practice.dto.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;

public class NotificationService {
    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public NotificationService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate =messagingTemplate;
    }

    public void sendGlobalNotification() {
        ResponseMessage message = new ResponseMessage("Global Notification");
        messagingTemplate.convertAndSend("/topic/global-notification", message);
    }

    public void sendPrivateNotification(final String userId) {
        ResponseMessage message = new ResponseMessage("Private Notification");
        messagingTemplate.convertAndSendToUser(userId,"/topic/private-notification", message);
    }
}
