package com.zhuai.localtcc.handler;

import com.google.common.collect.Lists;

import java.util.List;

public abstract class BizServiceHandler {

    public static final ThreadLocal<List<BizServiceHandler>> serviceDoneHandlers = ThreadLocal.withInitial(Lists::newArrayList);

    public void process(){}

    public void rollback(){}
}
