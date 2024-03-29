package com.zhuai.localtcc.example;

import com.zhuai.localtcc.annotation.BizProcess;
import com.zhuai.localtcc.handler.BizServiceHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ItemStockService extends BizServiceHandler {

    @Override
    @BizProcess
    public void process() {
        // 扣库存
        log.info("ItemStockService begin process");

        log.info("ItemStockService end process");
    }

    @Override
    public void rollback() {
        // 回滚库存
        log.info("ItemStockService rollback");
    }
}
