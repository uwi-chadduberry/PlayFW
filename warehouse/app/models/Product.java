package models;

/**
 * Created by CHAD on 5/28/14.
 */

import java.util.List;
import java.util.ArrayList;
import play.data.validation.Constraints;

public class Product
{
   @Constraints.Required
   public String ean;
   @Constraints.Required
   public String name;
   public String description;
   private static List<Product> products;

   public Product()
   {

   }

   public Product( String ean, String name, String description )
   {
      this.ean = ean;
      this.name = name;
      this.description = description;
   }

   static
   {
      products = new ArrayList<Product>();
      products.add( new Product( "F2PMN", "Team Fortress 2 Game Card", "Game card ID" ) );
      products.add( new Product( "D0SPL", "Facebook Customer key", "Billing account key" ) );
      products.add( new Product( "WM908", "Twitter Reset pass", "Twitter data plan pass" ) );
      products.add( new Product( "128GJ", "SoundCloud Monthly Bill", "Bill access code" ) );
      products.add( new Product( "EZ780", "GrooveShark Account", "Account number" ) );
   }

   public static List<Product> findAll()
   {
      return new ArrayList<Product>( products );
   }

   public static Product findByEan( String ean )
   {
      for ( Product candidate : products )
      {
         if ( candidate.ean.equals( ean ) )
         {
            return candidate;
         }
      }
      return null;
   }

   public static List<Product> findByName( String term )
   {
      final List<Product> results = new ArrayList<Product>();

      for ( Product candidate : products )
      {
         if ( candidate.name.toLowerCase().contains( term.toLowerCase() ) )
         {
            results.add( candidate );
         }
      }
      return results;
   }

   public static boolean remove( Product product )
   {
      return products.remove( product );
   }

   public void save()
   {
      products.remove( findByEan( this.ean ) );
      products.add( this );
   }

   public String toString()
   {
      return String.format( "%s - %s", ean, name );
   }
}
