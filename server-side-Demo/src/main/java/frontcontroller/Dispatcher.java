package frontcontroller;

import java.nio.file.Path;

import controllers.UserController;
import io.javalin.Javalin;
import static io.javalin.apibuilder.ApiBuilder.*;


public class Dispatcher {
	
	public Dispatcher(Javalin app) {
		/*
		 * This is where we are going to delegate where the requests go 
		 * 
		 *
		 */
		
		//get all users /api/user GET
		//app.get("/api/user", UserController::getAllUsers);
		
		//get one user /api/user/:id GET
		//app.get("/api/user/:id", UserController::getOneUser);
		//create one user /api/user POST
		//app.post("/api/user", UserController::createOneUser);
		//delete one user /api/user/:id DELETE
		//app.delete("/api/user/:id", UserController::deleteOneUser);
		
		//better concise way to do it 
		app.routes(() -> {
					path("/api/user", ()  -> {
						get(UserController::getAllUsers);
						post(UserController::createOneUser);
						
						path(":id", ()->{
							get(UserController::getOneUser);
							delete(UserController::deleteOneUser);
						});
					});
				});
		
	}

}
