package com.hha.order;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Priority;

@Component
//@Order(2)
@Priority(2)
public class OrderInterImpl02 implements OrderInter{
}
