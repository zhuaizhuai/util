package com.zhuai.localtcc.service;

import com.zhuai.localtcc.annotation.BizProcess;
import com.zhuai.localtcc.handler.BizServiceHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DiscountService extends BizServiceHandler {

    @Override
    @BizProcess
    public void process() {
        // 使用优惠券
        log.info("DiscountService begin process");
        log.info("DiscountService end process");
    }

    @Override
    public void rollback() {
        // 恢复优惠券
        log.info("DiscountService rollback");
    }
}
