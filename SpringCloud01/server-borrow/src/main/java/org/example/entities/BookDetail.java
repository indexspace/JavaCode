package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BookDetail {

    private Book book;
    private List<MyUser> users;
}
