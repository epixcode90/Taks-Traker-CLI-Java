package com.tutorial;

import java.time.LocalDateTime;

public class Task {
    private int id;
    private String description;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public Task(int id, String description) {
        this.id = id;
        this.description = description;
        this.status = Status.TODO;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        this.updatedAt = LocalDateTime.now();
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
        this.updatedAt = LocalDateTime.now();

    }



    @Override
    public String toString() {
        String statusColor;

        if (status == Status.TODO) {
            statusColor = "\u001B[31m" + status + "\u001B[0m";
        } else {
            statusColor = "\u001B[32m" + status + "\u001B[0m";
        }
        return "\nID          : " + id +
                "\nDescription : " + description +
                "\nStatus      : " + statusColor +
                "\nCreated At  : " +
                createdAt.getYear() + "-" +
                createdAt.getMonthValue() + "-" +
                createdAt.getDayOfMonth() + " " +
                createdAt.getHour() + ":" +
                updatedAt.getMinute()+
                "\nUpdated At  : " +
                updatedAt.getYear() + "-" +
                updatedAt.getMonthValue() + "-" +
                updatedAt.getDayOfMonth() + " " +
                updatedAt.getHour() + ":" +
                updatedAt.getMinute();
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }


    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}

