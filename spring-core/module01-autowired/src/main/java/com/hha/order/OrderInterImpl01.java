package com.hha.order;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Priority;

@Component
//@Order(3)
@Priority(3)
public class OrderInterImpl01 implements OrderInter{
}
