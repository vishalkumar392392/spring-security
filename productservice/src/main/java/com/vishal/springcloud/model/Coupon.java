package com.vishal.springcloud.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Coupon {

	private Long id;

	private String code;

	private BigDecimal discount;

	private String expDate;

}
