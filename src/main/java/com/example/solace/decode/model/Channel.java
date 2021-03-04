package com.example.solace.decode.model;

import javax.persistence.*;
import java.lang.String;

@Entity
public class Channel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false)
    private String name;
}
