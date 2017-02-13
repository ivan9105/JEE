package com.jee.bean;

import javax.annotation.Resource;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.Method;

/**
 * Created by ���� on 12.02.2017.
 */
@Stateless(name = "TransactionCaller")
@TransactionManagement(value = TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class TransactionCaller {
    @PersistenceContext(unitName = "DEV_MODE")
    private EntityManager em;

    @Resource
    private EJBContext context;

    public Object call(Class cls, String methodName, Object... params) throws Exception {
        Class[] paramTypes = null;
        if (params != null) {
            paramTypes = new Class[params.length];
            for (int i = 0; i < params.length; i++) {
                paramTypes[i] = params[i].getClass();
            }
        }
        Method method;
        if (paramTypes != null && paramTypes.length > 0) {
            method = cls.getDeclaredMethod(methodName, paramTypes);
        } else {
            method = cls.getDeclaredMethod(methodName);
        }
        Object bean = context.lookup("java:global/JEE/" + cls.getSimpleName());
        return method.invoke(bean, params);
    }
}
