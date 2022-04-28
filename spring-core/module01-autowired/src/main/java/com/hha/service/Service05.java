package com.hha.service;

import com.hha.bean.Inter;
import com.hha.bean.InterImpl;
import com.hha.noimpl.NoImpl01;
import com.hha.noimpl.NoImpl02;
import com.hha.noimpl.NoImpl03;
import com.hha.order.OrderInter;
import com.hha.order.OrderInterImpl01;
import com.hha.order.OrderInterImpl02;
import com.hha.order.OrderInterImpl03;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Service05 {

    @Autowired
    public void setter01(
            List<OrderInter> orderInterList
    ) {

        orderInterList.stream()
                .map(orderInter -> orderInter.getClass().getSimpleName())
                .forEach(System.out::println);

    }


}
