package com.example.thymeleaftest;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emee {
    private Integer id;
    private String lname;
    private String email;
    private Integer gender;

    private Depart depart;
    private Date birth;
}
