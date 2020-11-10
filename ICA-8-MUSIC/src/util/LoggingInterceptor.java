package util;

import java.io.Serializable;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.transaction.Transactional;

import business.MusicManagerInterface;

@Interceptor
@Transactional
public class LoggingInterceptor implements Serializable {
	@AroundInvoke 
	public Object methodInterceptor(InvocationContext ctx) throws Exception 
	{ 
	System.out.println("******************* Intercepting call to method: " +  
	ctx.getTarget().getClass() + "." + ctx.getMethod().getName() + "()"); 
	return ctx.proceed(); 
	} 

}
