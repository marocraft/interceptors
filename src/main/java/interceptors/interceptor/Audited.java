package interceptors.interceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.enterprise.util.Nonbinding;
import javax.interceptor.InterceptorBinding;

import interceptors.interceptor.enumeration.LogLevel;

@InterceptorBinding
@Target( { ElementType.METHOD, ElementType.TYPE } )
@Retention( RetentionPolicy.RUNTIME )
public @interface Audited {
	@Nonbinding public String message() default "";
	@Nonbinding public LogLevel logLevel() default LogLevel.INFO;
	

}
