package me.reb4ck.rest.model.reply;

import me.reb4ck.rest.model.User;

public final class UserReply {
    private Long id;
    private String date;

    public UserReply(User user){
        this.id = user.getId();
        this.date = user.getDate();
    }

    public UserReply(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
