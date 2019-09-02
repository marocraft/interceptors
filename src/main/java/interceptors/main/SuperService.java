package interceptors.main;

import interceptors.interceptor.Audited;
import interceptors.interceptor.enumeration.LogLevel;

public class SuperService {
    @Audited( message = "here i am", logLevel = LogLevel.DEBUG)
    public String deliverService(String uid) {
    	for (int i = 0; i < 10000; i++) {
//			System.out.println("loop");
		}
        return uid;
    }
}