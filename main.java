import java.util.Scanner;
import org.json.*;
public class main {
   public static void main(String[] args) {
      try {
         Scanner Strings = new Scanner(System.in);
         JSONArray Array = new JSONArray();
         for (int i = 0; i < 3; i++) {
            System.out.println("Adding Country [" + (i + 1) + "]\nCountry Name: ");
            String Name = Strings.nextLine().toUpperCase();
            System.out.println("Country Capital: ");
            String Capital = Strings.nextLine().toUpperCase();
            System.out.println("Population: ");
            long Population = Long.parseLong(Strings.nextLine());
            JSONObject Object = new JSONObject();
            Object.put("Name", Name);
            Object.put("Capital", Capital);
            Object.put("Population", Long.toString(Population));
            Array.put(Object);
         }
         countries API = new countries(Array);
         boolean Value = true;
         String Last = "";
         while (Value) {
            System.out.println("---------------------[Dashboard]---------------------\n1. Add Country\n2. Remove Country\n3. Insert Middle\n4. Change Last\n5. Exit");
            int Number = Integer.parseInt(Strings.nextLine());
            if (Number == 1) {
               System.out.println("Country Name: ");
               String Name = Strings.nextLine();
               System.out.println("Country Capital: ");
               String Capital = Strings.nextLine();
               System.out.println("Population: ");
               long Population = Long.parseLong(Strings.nextLine());
               if (API.AddCountry(Name.toUpperCase(), Capital.toUpperCase(), Long.toString(Population)) == true) {
                  System.out.println("Cant have more then 5");
               } else {
                  System.out.println("Successfully added country");   
                  API.ViewCountries();  
               }
            } else if (Number == 2) {
               System.out.println("Country Name: ");
               String Name = Strings.nextLine().toUpperCase();
               if (API.RemoveCountry(Name) == true) {
                  System.out.println("Successfully removed country");
                  API.ViewCountries();
               } else {
                  System.out.println("Failed to remove country " + Name);
               }
            } else if (Number == 3) {
               System.out.println("Country Name: ");
               String Name = Strings.nextLine();
               System.out.println("Country Capital: ");
               String Capital = Strings.nextLine();
               System.out.println("Population: ");
               long Population = Long.parseLong(Strings.nextLine());
               if (API.InsertMiddle(Name.toUpperCase(), Capital.toUpperCase(), Long.toString(Population)) == true) {
                  System.out.println("Successfully added country to the middle of the array.");
                  API.ViewCountries();
               } else {
                  System.out.println("Failed to added country to the middle.");
               }
            } else if (Number == 4) {
               if (API.ChangeLast() == true) {
                  System.out.println("Successfully changed countries.");
                  API.ViewCountries();
               } else {
                  System.out.println("You havent removed a country.");
               }
            } else if (Number == 5) {
               Value = false;
            }
         }
      } catch (Exception error) {
         System.out.println("---------------------[ Error ]---------------------\n" + error);
      }
   }
}