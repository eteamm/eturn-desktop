package org.eturn.data;

public class Position {
    private Long id;
    private String name;
    private String group;
    private boolean isStarted;
    private int number;
    private Long userid;
    public Position(Long id, String name, String group, boolean isStarted, int number, Long userid) {
        this.id = id;
        this.name = name;
        this.group = group;
        this.isStarted = isStarted;
        this.number = number;
        this.userid = userid;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public boolean isStarted() {
        return isStarted;
    }

    public void setStarted(boolean started) {
        isStarted = started;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    public Long getUserId() {
        return userid;
    }

    public void UsersetId(Long userid) {
        this.userid = userid;
    }
}
