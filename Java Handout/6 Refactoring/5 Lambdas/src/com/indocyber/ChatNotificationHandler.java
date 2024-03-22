package com.indocyber;

@FunctionalInterface
public interface ChatNotificationHandler {
    public void sendChatNotification(String name);
}
