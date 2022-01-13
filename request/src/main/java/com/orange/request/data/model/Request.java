package com.orange.request.data.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false,unique = true)
    Long number;

    @Column(nullable = false)
    String type;
    @Column
    String description;
    @Column(nullable = false)
    String status;
    @Column(nullable = false)
    String username;

}
