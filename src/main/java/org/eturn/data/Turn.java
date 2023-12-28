package org.eturn.data;

public class Turn {
    private long id;
    private String name;
    private String description;
    private String creator;
    private long userId;
    private int countUsers;

    public Turn(long id, String name, String description, String creator, long userId, int countUsers) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creator = creator;
        this.userId = userId;
        this.countUsers = countUsers;
    }
    public Turn() {

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getCountUsers() {
        return countUsers;
    }

    public void setCountUsers(int countUsers) {
        this.countUsers = countUsers;
    }
}
