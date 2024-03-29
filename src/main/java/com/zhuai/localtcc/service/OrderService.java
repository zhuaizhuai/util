package com.zhuai.localtcc.service;

import com.zhuai.localtcc.annotation.BizRollback;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderService {

    @Autowired
    private ItemStockService itemStockService;

    @Resource
    private DiscountService discountService;

    // 使用方式
    @BizRollback
    public void creatOrder() {
        // 扣库存
        itemStockService.process();
        // 使用优惠券
        discountService.process();
        // 创建订单，如果异常需要回滚前两部的操作
        this.insert();
    }

    private void insert() {
        System.out.println("insert order");
        // 过程中发生异常了。。
        throw new RuntimeException("test");
    }
}
