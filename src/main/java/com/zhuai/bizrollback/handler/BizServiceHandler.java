package com.zhuai.bizrollback.handler;

import com.google.common.collect.Lists;

import java.util.List;

public abstract class BizServiceHandler {

    public static final ThreadLocal<List<BizServiceHandler>> serviceDoneHandlers = ThreadLocal.withInitial(Lists::newArrayList);

    /**
     * 业务处理
     */
    public void process(){}

    /**
     * 业务回滚
     */
    public void rollback(){}
}
