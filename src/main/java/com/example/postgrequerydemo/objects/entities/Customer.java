package com.example.postgrequerydemo.objects.entities;

import com.vladmihalcea.hibernate.type.array.ListArrayType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
@TypeDef(name = "list-array", typeClass = ListArrayType.class)
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;

    private String lastName;

    private String email;

    @Type(type = "list-array")
    @Column(name = "phone_numbers", columnDefinition = "text[]")
    private List<String> phoneNumbers;
}

