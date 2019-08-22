package com.dc.cloudconsumer.domain;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
public class Order {
    @NotEmpty(message = "name 不能为空")
    private String name;
    @Max(value = 9999L, message = "id 超过最大值(9999)")
    private Long id;
    private LocalDate localDate;
}
