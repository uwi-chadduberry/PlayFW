package models;

/**
 * Created by CHAD on 5/28/14.
 */
public class Product
{
   public String ean;
   public String name;
   public String description;

   public Product()
   {

   }

   public Product( String ean, String name, String description )
   {
      this.ean = ean;
      this.name = name;
      this.description = description;
   }

   public String toString()
   {
      return String.format( "%s - %s", ean, name );
   }
}
