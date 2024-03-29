package com.zhuai.localtcc.service;

import com.zhuai.localtcc.annotation.BizProcess;
import com.zhuai.localtcc.handler.BizServiceHandler;
import org.springframework.stereotype.Service;

@Service
public class DiscountService extends BizServiceHandler {

    @Override
    @BizProcess
    public void process() {
        // 使用优惠券
        System.out.println("DiscountService begin process");
        System.out.println("DiscountService end process");
    }

    @Override
    public void rollback() {
        // 恢复优惠券
        System.out.println("DiscountService rollback");
    }
}
