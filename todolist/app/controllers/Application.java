package controllers;

import models.Task;
import play.*;
import play.data.Form;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    static Form<Task> taskForm = Form.form(Task.class);

    public static Result index()
    {
        return redirect( controllers.routes.Application.task() );
    }

    public static Result task()
    {
        return ok( views.html.index.render( Task.all(), taskForm ) );
    }

    public static Result newTask()
    {
        Form<Task> filledForm = taskForm.bindFromRequest();
        if ( filledForm.hasErrors() )
        {
            return badRequest( views.html.index.render( Task.all(), filledForm ) );
        }
        else
        {
            Task.create( filledForm.get() );
            return redirect( controllers.routes.Application.task() );
        }
    }

    public static Result deleteTask( Long id )
    {
        return TODO;
    }

}
