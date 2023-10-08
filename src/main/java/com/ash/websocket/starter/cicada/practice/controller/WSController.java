package com.ash.websocket.starter.cicada.practice.controller;

import com.ash.websocket.starter.cicada.practice.dto.Messages;
import com.ash.websocket.starter.cicada.practice.service.WSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WSController {

    @Autowired
    private WSService service;

    @PostMapping("/send-message")
    public void sendMessage(@RequestBody final Messages messages){
        service.pushFrontend(messages.getMessageContent());
    }

    @PostMapping("/send-private-message")
    public void sendPrivateMessage(@PathVariable String id, @RequestBody final Messages messages){
        service.pushFrontendPrivate(id, messages.getMessageContent());
    }
}
