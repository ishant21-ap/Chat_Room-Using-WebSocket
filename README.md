
# Chat Room Application Using WebSocket

This project is a real-time chat room application built using **Spring Boot** and **WebSocket**. The application allows users to send messages and join or leave chat rooms in real time. It utilizes the **STOMP protocol** over WebSocket for messaging.

---

## Features

- **Real-Time Messaging**: Users can send and receive messages instantly.
- **User Join/Leave Notifications**: Notifications are broadcast to all users when someone joins or leaves the chat.
- **STOMP Protocol**: Used for WebSocket communication.
- **Lightweight Backend**: Simple and easy-to-extend backend logic.

---

## Project Structure

### Configuration

- **`WebSocketConfig`**: Configures WebSocket endpoints and message brokers for the application.
  - `/ws`: WebSocket endpoint.
  - `/topic`: Public topic for broadcasting messages.
  - `/app`: Application destination prefix for client messages.

### Controller

- **`ChatController`**: Handles chat messages sent by users.
  - `/chat.sendMessage`: Handles user messages and broadcasts them.
  - `/chat.addUser`: Adds a user to the chat session.

### Event Listener

- **`WebSocketEventListener`**: Handles WebSocket events, such as when a user disconnects, and broadcasts notifications to other users.

### Model

- **`ChatMessage`**: Represents a chat message, including the content, sender, and message type.
- **`MessageType`**: Enum defining message types (`CHAT`, `JOIN`, `LEAVE`).

---

## How It Works

1. **Connecting to WebSocket**:
   - The WebSocket endpoint `/ws` is configured for client connections.
   - The application supports fallback to SockJS for browsers that don't support native WebSocket.

2. **Sending Messages**:
   - Messages are sent to `/app/chat.sendMessage` using the STOMP protocol.
   - These messages are broadcast to `/topic/public`, where all clients are subscribed.

3. **User Management**:
   - When a user joins, their username is stored in the WebSocket session and notified to other users.
   - When a user leaves, a `LEAVE` notification is broadcast.

---

## Getting Started

### Prerequisites

- **Java 17+**
- **Maven**
- **Spring Boot** (Latest version)



