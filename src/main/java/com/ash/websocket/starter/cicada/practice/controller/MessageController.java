package com.ash.websocket.starter.cicada.practice.controller;

import com.ash.websocket.starter.cicada.practice.dto.Messages;
import com.ash.websocket.starter.cicada.practice.dto.ResponseMessage;
import com.ash.websocket.starter.cicada.practice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.security.Principal;

@Controller
public class MessageController {

    @Autowired
    private NotificationService notificationService;


    @MessageMapping("/message")
    @SendTo("/topic/messages")
    public ResponseMessage getMessage(final Messages messages) throws InterruptedException{
        Thread.sleep(1000);
        notificationService.sendGlobalNotification();
        return new ResponseMessage(HtmlUtils.htmlEscape(messages.getMessageContent()));
    }

    @MessageMapping("/private-message")
    @SendToUser("/topic/private-messages")
    public ResponseMessage getPrivateMessageUser(final Messages messages,
                                                 final Principal principal) throws InterruptedException {
        Thread.sleep(1000);
        notificationService.sendPrivateNotification(principal.getName());
        return new ResponseMessage(HtmlUtils.htmlEscape(messages.getMessageContent()));
    }
}
