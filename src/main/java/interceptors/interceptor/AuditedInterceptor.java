package interceptors.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import interceptors.interceptor.enumeration.LogLevel;

@Audited
@Interceptor
public class AuditedInterceptor {
	public static boolean calledBefore = false;
	public static boolean calledAfter = false;
	static long timeBeforeMethodInvocation;
    static long timeAfterMethodInvocation;

	@AroundInvoke
	public Object auditMethod(InvocationContext ctx) throws Exception {
		calledBefore = true;
		System.out.println("methodname: "+ ctx.getMethod().getName());
		System.out.println("classname: "+ctx.getClass());
		System.out.println("classname: "+ctx.getTimer());
		System.out.println("timestamps: "+ System.currentTimeMillis());
		LogLevel loglevel=ctx.getMethod().getAnnotation(Audited.class).logLevel();
		System.out.println("loglevel "+loglevel);
		String message= ctx.getMethod().getAnnotation(Audited.class).message();
		System.out.println("logmesasge: "+message);
		timeBeforeMethodInvocation = System.currentTimeMillis();
		Object result = ctx.proceed();
		timeAfterMethodInvocation = System.currentTimeMillis();
		calledAfter = true;
		System.out.println("duration: "+(timeAfterMethodInvocation-timeBeforeMethodInvocation));
		return result;
	}
}
