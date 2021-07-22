package frontcontroller;

import io.javalin.Javalin;
import io.javalin.http.Context;

// the front controller is the initial contact point from client
public class FrontController {
	Javalin app;
	Dispatcher dispatcher;
	
	public FrontController(Javalin app) {
		this.app = app;
		
		/*
		 * all of middleware routes would go here
		 * :: checkall will be implementation for the functional interface method
		 * 
		 */
		
		this.app.before("/api/", FrontController::checkAllRequests); //context lambda syntax
		
		this.dispatcher = new Dispatcher(app);
	
}	
	public static void checkAllRequests(Context context) {
		System.out.println("middleware has been hit");
	}
}