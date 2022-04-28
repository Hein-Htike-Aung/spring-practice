package com.hha.service;

import com.hha.bean.Inter;
import com.hha.bean.InterImpl;
import com.hha.noimpl.NoImpl01;
import com.hha.noimpl.NoImpl02;
import com.hha.noimpl.NoImpl03;
import com.hha.order.OrderInterImpl01;
import com.hha.order.OrderInterImpl02;
import com.hha.order.OrderInterImpl03;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.Optional;

//@Service
public class Service03 {

    @Autowired
    public Service03(
            OrderInterImpl01 orderInterImpl01,
            OrderInterImpl02 orderInterImpl02,
            OrderInterImpl03 orderInterImpl03

    ) {
        System.out.println("In Constructor ==================");
        System.out.println("OrderInterImpl01 = " + orderInterImpl01);
        System.out.println("OrderInterImpl02 = " + orderInterImpl02);
        System.out.println("OrderInterImpl03 = " + orderInterImpl03);

    }

    public Service03(
            Inter inter,
            InterImpl interImpl,
            @Nullable NoImpl01 noImpl01,
            @Autowired(required = false) NoImpl02 noImpl02,
            @Autowired Optional<NoImpl03> noImpl03

    ) {
        System.out.println("In Constructor ==================");
        System.out.println("InterImpl = " + inter);
        System.out.println("InterImpl = " + interImpl);
        System.out.println("NoImpl01 = " + noImpl01);
        System.out.println("NoImpl02 = " + noImpl02);
        System.out.println("NoImpl03 = " + noImpl03);
    }

}
