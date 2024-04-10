package com.example.first.app.model;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level =  AccessLevel.PRIVATE)
public class Book {
    private int id;
    private String title;
    private String author;
    private int year;
}
