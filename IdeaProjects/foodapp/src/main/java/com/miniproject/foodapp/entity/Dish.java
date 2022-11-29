package com.miniproject.foodapp.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Dish
{
    private int dishId;
    private String dishName;
    private MultipartFile photo;
    private String photoUrl;
    private String cuisines;
    private String category;
}
