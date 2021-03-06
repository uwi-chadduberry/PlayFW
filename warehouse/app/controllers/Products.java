package controllers;

/**
 * Created by CHAD on 5/28/14.
 */

import models.Product;
import org.apache.commons.lang3.StringUtils;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.products.list;
import views.html.products.details;
import java.util.List;

public class Products extends Controller
{
   private static final Form<Product> productForm = Form.form( Product.class );

   public static Result index()
   {
      return redirect( controllers.routes.Products.list( 0 ) );
   }

   public static Result list( Integer page )
   {
      List<Product> products = Product.findAll();
      /*if ( request().accepts( "text/plain" ) )
      {
         return ok( StringUtils.join( products, "\n" ) );
      }*/
      return ok( list.render( products ) );
   }

   public static Result newProduct()
   {
      return ok( details.render( productForm ) );
   }

   public static Result details( String ean )
   {
      final Product product = Product.findByEan( ean );
      if ( product == null )
      {
         return notFound( String.format( "Product %s does not exist.", ean ) );
      }
      Form<Product> filledForm = productForm.fill( product );
      return ok( details.render( filledForm ) );
   }


   public static Result save()
   {
      Form<Product> boundForm = productForm.bindFromRequest();
      if ( boundForm.hasErrors() )
      {
         flash( "error", "Please correct the form below" );
         return badRequest( details.render( boundForm ) );
      }

      Product product = boundForm.get();
      product.save();
      flash( "success", String.format( "Successfully added product %s", product ) );
      return redirect( controllers.routes.Products.list( 1 ) );
   }

   public static Result delete( String ean )
   {
      final Product product = Product.findByEan( ean );
      if ( product == null )
      {
         return notFound( String.format( "Product %s does not exist.", ean ) );
      }

      Product.remove( product );
      return redirect( controllers.routes.Products.list( 1 ) );
   }
}
