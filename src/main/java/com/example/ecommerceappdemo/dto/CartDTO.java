package com.example.ecommerceappdemo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CartDTO {
    @JsonProperty(required = true)
    private int id;
    @JsonProperty(required = true)
    private int userId;
    private Date date;
    private List<ProductDTO> products;

    public CartDTO(int id, int userId){

    }
}
