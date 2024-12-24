package com.project.Chat.Application.Using.WebSocket.chat;

import java.time.LocalDateTime;

public class ChatMessage {

    private String content;     // Content will give message
    private String sender;      // Who sends this message
    private MessageType type;
//    private LocalDateTime timestamp;

//    public LocalDateTime getTimestamp() {
//        return timestamp;
//    }
//
//    public void setTimestamp(LocalDateTime timestamp) {
//        this.timestamp = timestamp;
//    }

    // No-args constructor
    public ChatMessage() {}

    // All-args constructor
    public ChatMessage(String content, String sender, MessageType type) {
        this.content = content;
        this.sender = sender;
        this.type = type;
//        this.timestamp = timestamp  ;
    }

    // Getter and Setter methods
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    // toString method


    @Override
    public String toString() {
        return "ChatMessage{" +
                "content='" + content + '\'' +
                ", sender='" + sender + '\'' +
                ", type=" + type +
//                ", timestamp=" + timestamp +
                '}';
    }

    // equals and hashCode (optional, but good practice)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChatMessage that = (ChatMessage) o;

        if (!content.equals(that.content)) return false;
        if (!sender.equals(that.sender)) return false;
        return type == that.type;
    }

    @Override
    public int hashCode() {
        int result = content.hashCode();
        result = 31 * result + sender.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }
}
