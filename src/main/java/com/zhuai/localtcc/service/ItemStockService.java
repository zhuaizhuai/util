package com.zhuai.localtcc.service;

import com.zhuai.localtcc.annotation.BizProcess;
import com.zhuai.localtcc.handler.BizServiceHandler;
import org.springframework.stereotype.Service;

@Service
public class ItemStockService extends BizServiceHandler {

    @Override
    @BizProcess
    public void process() {
        // 扣库存
        System.out.println("ItemStockService begin process");

        System.out.println("ItemStockService end process");
    }

    @Override
    public void rollback() {
        // 回滚库存
        System.out.println("ItemStockService rollback");
    }
}
