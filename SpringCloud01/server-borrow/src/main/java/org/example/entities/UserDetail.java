package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserDetail {


    private MyUser myUser;
    private List<Book> books;

}
