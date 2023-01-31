package com.zv.geochat.model;

public class ChatMessage {
    private String id;
    private String userName;
    private String body;
    private String chatMessageDate;
    public ChatMessage() {
    }

    public ChatMessage(String userName, String body, String chatMessageDate) {
        this.userName = userName;
        this.body = body;
        this.chatMessageDate = chatMessageDate;
    }

    public ChatMessage(String id, String userName, String body, String chatMessageDate) {
        this.id = id;
        this.userName = userName;
        this.body = body;
        this.chatMessageDate = chatMessageDate;
    }


    public String getUserName() {
        return userName;
    }

    public String getBody() {
        return body;
    }

    public String getId() {
        return id;
    }

    public String getMessageDate() {
        return chatMessageDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setMessageDate(String messageDate) {
        this.chatMessageDate = messageDate;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", body='" + body + '\'' +
                ", messageDate='" + chatMessageDate + '\'' +
                '}';
    }
}
