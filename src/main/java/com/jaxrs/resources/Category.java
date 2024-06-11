package com.jaxrs.resources;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Category {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;
}
