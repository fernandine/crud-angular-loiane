package com.github.com.crudjean.dto;

import com.github.com.crudjean.model.Course;
import java.io.Serializable;

public class CourseDto implements Serializable {

    private String id;
    private String name;
    private String category;

    public CourseDto() {
    }

    public CourseDto(Course entity) {
        id = entity.getId();
        name = entity.getName();
        category = entity.getCategory();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}