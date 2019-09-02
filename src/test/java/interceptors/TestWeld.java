package interceptors;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import interceptors.interceptor.AuditedInterceptor;
import interceptors.main.SuperService;

public class TestWeld {
    Weld weld;
    WeldContainer container;
 
    @Before
    public void init() {
        weld = new Weld();
        container = weld.initialize();
    }
 
    @After
    public void shutdown() {
        weld.shutdown();
    }
 
    @Test
    public void givenTheService_whenMethodAndInterceptorExecuted_thenOK() {
        SuperService superService = container.select(SuperService.class).get();
        String code = "123456";
        superService.deliverService(code);
         
        Assert.assertTrue(AuditedInterceptor.calledBefore);
        Assert.assertTrue(AuditedInterceptor.calledAfter);
    }

}
