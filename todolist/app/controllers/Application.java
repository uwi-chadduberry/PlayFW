package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index()
    {
        return redirect( routes.Application.task() );
    }

    public static Result task()
    {
        return TODO;
    }

    public static Result newTask()
    {
        return TODO;
    }

    public static Result deleteTask( Long id)
    {
        return TODO;
    }

}
