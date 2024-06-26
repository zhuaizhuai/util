package com.zhuai.bizrollback.example;

import com.zhuai.bizrollback.annotation.BizRollback;
import com.zhuai.bizrollback.service.DiscountService;
import com.zhuai.bizrollback.service.ItemStockService;
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

    /**
     * 使用举例
     */
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
        log.info("insert order");
        // 过程中发生异常了。。
        throw new RuntimeException("test");
    }
}
