package controllers;

/**
 * Created by CHAD on 5/28/14.
 */

import models.Product;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.products.list;
import java.util.List;

public class Products extends Controller
{
   public static Result list()
   {
      List<Product> products = Product.findAll();
      return ok( list.render( products ) );
   }

   public static Result newProduct()
   {
      return TODO;
   }

   public static Result details( String ean )
   {
      return TODO;
   }


   public static Result save()
   {
      return TODO;
   }
}
