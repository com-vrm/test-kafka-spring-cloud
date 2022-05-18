package com.vrm.test.kafka.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author taaviv @ 18.05.22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stock {

    private String symbol;
    private double price;
    private long timestamp;

}
