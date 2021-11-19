package me.reb4ck.rest.model;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.util.Date;
import java.util.TimeZone;

@Entity(name = "user")
@Table(name = "users")
public final class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private String phone;
    @Column
    private String email;
    @Column
    private String date;

    public User() {
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

    @PrePersist
    public void setDate() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date = Date.from(Instant.now(Clock.systemUTC()));
        formato.applyPattern("dd-MM-yyyy");
        this.date = formato.format(date);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
