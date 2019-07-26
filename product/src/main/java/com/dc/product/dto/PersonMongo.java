package com.dc.product.dto;

import com.dc.api.domain.User;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Document
@Data
public class PersonMongo {

    @Id
    private String id;
    private String name;
    private Integer age;
    @Field("user")
    private List<User> list =  new ArrayList<>();

    public PersonMongo(String id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
