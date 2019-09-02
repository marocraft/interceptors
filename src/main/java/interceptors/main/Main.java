package interceptors.main;

import javax.inject.Inject;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import interceptors.interceptor.Audited;

public class Main {

	static Weld weld;
	static WeldContainer container;
	@Inject
	static SuperService superService;

	@Inject
	public static void main(String[] args) {

//		weld= new Weld();
//		container=weld.initialize();
		try {
//		SuperService superService= container.select(SuperService.class).get();
			System.out.println(superService.deliverService("housseine"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Audited
	public static String sayMyName(String name) {
		return "your name is " + name;
	}

}
