package com.dc.demo.domain;

import lombok.Data;
//import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Data
//@Document(indexName = "demo", type = "people")
public class User implements Serializable {
    private Integer id;
    private String username;
    private String pwd;
    private static final long serialVersionUID = 1L;

    public User() {
    }

    public User(Integer id, String username, String pwd) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
    }
}