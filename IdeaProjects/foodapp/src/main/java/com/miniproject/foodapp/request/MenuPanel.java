package com.miniproject.foodapp.request;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuPanel
{
    private String category;
    private Integer noOfItems;
    private List<ItemResponse> itemsResponses;
}
