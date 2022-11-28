package com.solomon.cruddemo.Response;

public class EmployeeErrorResponse {
    private int status;
    private String message;
    private long timestamp;

    // Generate the getters and setters


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    // Generate the constructors

    public EmployeeErrorResponse() {
    }

    public EmployeeErrorResponse(int status, String message, long timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    // Generate the toString method

    @Override
    public String toString() {
        return "EmployeeErrorResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
