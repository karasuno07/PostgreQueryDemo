package com.example.postgrequerydemo.objects.mappers;

import com.example.postgrequerydemo.objects.dto.CustomerDTO;
import com.example.postgrequerydemo.objects.entities.Customer;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(target = "fullName", ignore = true)
    CustomerDTO customerToCustomerDTO(Customer customer);

    @BeforeMapping
    default void setCustomerFullName(@MappingTarget CustomerDTO dto,
                                     Customer customer) {
        dto.setFullName(customer.getFirstName() + " " + customer.getLastName());
    }
}
