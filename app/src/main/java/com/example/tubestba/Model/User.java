package com.example.tubestba.Model;

public class User implements Comparable<User>{
    private String userName;
    private int skor;

    public User() {

    }

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getSkor() {
        return skor;
    }

    public void setSkor(int skor) {
        this.skor = skor;
    }

    @Override
    public int compareTo(User user) {
        return this.skor - user.getSkor();
    }
}
