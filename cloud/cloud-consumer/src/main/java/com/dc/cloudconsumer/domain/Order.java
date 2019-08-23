package com.dc.cloudconsumer.domain;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
public class Order {
    @NotEmpty
    private String name;
    @Max(value = 9999L)
    private Long id;
    private LocalDate localDate;
}
