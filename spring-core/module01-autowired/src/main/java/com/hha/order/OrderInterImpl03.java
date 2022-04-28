package com.hha.order;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Priority;

@Component
//@Order(1)
@Priority(1)
public class OrderInterImpl03 implements OrderInter{
}
