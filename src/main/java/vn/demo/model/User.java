package vn.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class User implements Serializable {
    private long id;

    private String firstName;


    private String lastName;


    private String dateOfBirth;


    private String  gender;


    private String phone;


    private String email;


    private String username;


    private String password;


    private String address;

    private String language;
}
