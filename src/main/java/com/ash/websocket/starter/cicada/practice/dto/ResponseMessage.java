package com.ash.websocket.starter.cicada.practice.dto;

public class ResponseMessage {
    private String content;

    public ResponseMessage(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
