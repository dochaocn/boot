package com.dc.api.domain;

import lombok.Data;

import java.io.Serializable;

//import org.springframework.data.elasticsearch.annotations.Document;

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