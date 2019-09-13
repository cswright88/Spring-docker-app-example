package com.example.demo.resources;

import org.hibernate.annotations.Table;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Greeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final long id;

    @NotNull
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }


    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
