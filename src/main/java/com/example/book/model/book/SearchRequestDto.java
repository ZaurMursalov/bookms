package com.example.book.model.book;

//import liquibase.change.DatabaseChange;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchRequestDto {
    private Long amount;
    private String description;
    private String title;

}
