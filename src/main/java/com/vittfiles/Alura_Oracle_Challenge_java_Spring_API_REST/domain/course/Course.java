package com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.course;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name = "courses")
@Entity(name = "Course")
@EqualsAndHashCode(of = "id")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;

    public Course(){
        super();
    }

    public Course(DataCreateCourse course){
        this.name = course.name();
        this.category = course.category();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
