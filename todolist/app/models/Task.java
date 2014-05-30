package models;

/**
 * Created by CHAD on 5/30/14.
 */

import java.util.ArrayList;
import java.util.List;
import play.db.ebean.*;
import play.data.validation.Constraints.*;
import play.db.ebean.Model;

import javax.persistence.*;

@Entity
public class Task extends Model
{
    @Id
    public Long id;
    @Required
    public String label;

    public static Model.Finder<Long,Task> find = new Finder( Long.class, Task.class );
    public static List<Task> all()
    {
        return new ArrayList<Task>();
    }

    public static void create( Task task )
    {

    }

    public static void delete( Long id )
    {

    }

}
