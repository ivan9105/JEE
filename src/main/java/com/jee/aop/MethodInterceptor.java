package com.jee.aop;

import org.apache.log4j.Logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 * Created by Иван on 02.03.2017.
 */
public class MethodInterceptor {
    private final static Logger logger = Logger.getLogger(MethodInterceptor.class);

    @AroundInvoke
    public Object interceptorMethod(InvocationContext ic) throws Exception {
        logger.info(String.format("Method: %s", ic.getMethod().getName()));
        return ic;
    }
}
