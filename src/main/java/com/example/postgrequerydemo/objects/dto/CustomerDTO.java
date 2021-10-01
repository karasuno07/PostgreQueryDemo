package com.example.postgrequerydemo.objects.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private String fullName;

//    private String firstName;
//
//    private String lastName;

    private String email;

    private List<String> phoneNumbers;
}
