# Azure Queue Service - Spring Boot API

This project is a Spring Boot application that provides a REST API for interacting with an Azure Storage Queue. It allows users to send, receive, and delete messages from an Azure queue using simple HTTP endpoints.

## Features

- Send messages to an Azure Storage Queue
- Retrieve messages from the queue
- Delete all messages from the queue

## Prerequisites

Before running this application, ensure you have:

- An **Azure Storage Account**
- An **Azure Storage Queue** created in your storage account
- A valid **Connection String** for your Azure Storage

## Configuration

Set the following properties in your `application.properties` or `application.yml` file:

```
azure.storage.connection-string=<your-azure-storage-connection-string>
azure.storage.queue-name=<your-queue-name>
```

## API Endpoints

### 1. Send a Message

**Endpoint:** `POST /api/queue/send`

**Query Parameter:** `message` (String)

**Example Request:**

```
curl -X POST "http://localhost:8080/api/queue/send?message=HelloAzure"
```

**Response:**

```
"Message sent successfully: HelloAzure"
```

### 2. Receive Messages

**Endpoint:** `GET /api/queue/receive`

**Example Request:**

```
curl -X GET "http://localhost:8080/api/queue/receive"
```

**Response:**

```
["HelloAzure", "AnotherMessage"]
```

### 3. Delete All Messages

**Endpoint:** `DELETE /api/queue/deleteAll`

**Example Request:**

```
curl -X DELETE "http://localhost:8080/api/queue/deleteAll"
```

**Response:**

```
"All messages have been deleted."
```

## Project Structure

```
src/
├── main/java/com/example/azurequeue
│   ├── controller/AzureQueueController.java  # REST API Controller
│   ├── service/AzureQueueService.java        # Service Layer
│   ├── config/AzureQueueConfig.java          # Azure Queue Configuration
```

## Running the Application

1. Clone the repository

```
git clone <repository-url>
cd <repository-folder>
```

1. Update `application.properties` with your Azure Storage details.
2. Build and run the application using Maven:

```
mvn spring-boot:run
```

1. The application will start on `http://localhost:8080`.

## Dependencies

- Spring Boot
- Azure Storage Queue SDK