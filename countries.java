import org.json.*;
public class countries {

   private JSONArray Database;
   private JSONObject Last;
   
   public countries(JSONArray db) {
      Database = db;
   }
   
   public boolean AddCountry(String Name, String Capital, String Population) {
      if (Database.length() < 5) {
         JSONObject Object = new JSONObject();
         Object.put("Name", Name);
         Object.put("Capital", Capital);
         Object.put("Population", Population);
         Database.put(Object);
         return false;
      } else {
         return true;
      }
   }
   
   public boolean RemoveCountry(String Name) {
      boolean Value = false;
      for (int i = 0; i < Database.length(); i++) {
         JSONObject JSON = Database.getJSONObject(i);
         if (JSON.getString("Name").equals(Name)) {
            Last = JSON;
            Database.remove(i);
            Value = true;
         }
      }
      return Value;
   }
   
   public boolean InsertMiddle(String Name, String Capital, String Population) {
      if (Database.length() < 5) {
         JSONArray Temporarily = new JSONArray();
         for (int i = 0; i < Database.length(); i++) {
            JSONObject JSON = Database.getJSONObject(i);
            System.out.println(Database.length() + " | " + i);
            if (Database.length() / 2 == i) {
               System.out.println("HERE");
               JSONObject Object = new JSONObject();
               Object.put("Name", Name);
               Object.put("Capital", Capital);
               Object.put("Population", Population);
               Temporarily.put(Object);
               Temporarily.put(JSON);
            } else {
               Temporarily.put(JSON);
            }
         }
         Database = Temporarily;
         return true;
      } else {
         return false;
      }
   }
   
   public boolean ChangeLast() {
      boolean Value = false;
      if (Last != null) {
         JSONObject Object = new JSONObject();
         Database.remove(Database.length());
         Database.put(Last);
         Last = null;
         Value = true;
      }
      return Value;
   }
   
   public boolean ViewCountries() {
      for (int i = 0; i < Database.length(); i++) {
         JSONObject JSON = Database.getJSONObject(i);
         if (i + 1 == Database.length()) {
            System.out.println("Country: " + JSON.getString("Name") + "\nCapital: " + JSON.getString("Capital") + "\nPopulation: " + JSON.getString("Population"));
         } else {
            System.out.println("Country: " + JSON.getString("Name") + "\nCapital: " + JSON.getString("Capital") + "\nPopulation: " + JSON.getString("Population") + "\n------------------------------");
         }
      }
      return true;
   }
}