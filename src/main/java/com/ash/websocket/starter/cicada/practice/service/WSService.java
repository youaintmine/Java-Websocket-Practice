package com.ash.websocket.starter.cicada.practice.service;

import com.ash.websocket.starter.cicada.practice.dto.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WSService {

    private final SimpMessagingTemplate messagingTemplate;
    private final NotificationService notificationService;

    @Autowired
    public WSService(SimpMessagingTemplate messagingTemplate, NotificationService notificationService){
        this.messagingTemplate = messagingTemplate;
        this.notificationService = notificationService;
    }

    public void pushFrontend(final String message){
        ResponseMessage responseMessage = new ResponseMessage(message);
        notificationService.sendGlobalNotification();
        messagingTemplate.convertAndSend("/topic/messages", responseMessage);
    }

    public void pushFrontendPrivate(final String id, String messageContent) {
        ResponseMessage responseMessage = new ResponseMessage(messageContent);
        notificationService.sendPrivateNotification(id);
        messagingTemplate.convertAndSendToUser(id,"/topic/private-messages", responseMessage);
    }
}
