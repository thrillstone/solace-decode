package com.example.solace.decode.model;

import javax.persistence.*;
import java.lang.String;
import java.util.List;

@Entity
@Table(name = "channel")
public class Channel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String type  = "channel";

//    @OneToMany(mappedBy="channel",  cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval =  true)
//    private List<Message> messages;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
