package com.jee.aop;

import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.interceptor.AroundConstruct;
import javax.interceptor.InvocationContext;

/**
 * Created by Иван on 02.03.2017.
 */
public class ConstructorInterceptor {
    private final static Logger logger = Logger.getLogger(ConstructorInterceptor.class);

    @AroundConstruct
    public void aroundConstructMethod(InvocationContext ic) throws Exception {
        String name = ic.getConstructor().getName();
        logger.info(String.format("Around construct: %s", name));
        ic.proceed();
    }

    @PreDestroy
    public void preDestroyMethod(InvocationContext ic) throws Exception {
        String target = ic.getTarget().toString();
        logger.info(String.format("Pre destroy: %s", target));
        ic.proceed();
    }

    @PostConstruct
    public void postConstructMethod(InvocationContext ic) throws Exception {
        String target = ic.getTarget().toString();
        logger.info(String.format("Around construct: %s", target));
        ic.proceed();
    }
}
