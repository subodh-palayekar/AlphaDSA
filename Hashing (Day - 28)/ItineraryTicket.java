import java.util.*;

public class ItineraryTicket {
    
    public static void main(String[] args) {
        HashMap<String,String> ticket = new HashMap<>();
        ticket.put("Chennai", "Bengaluru");
        ticket.put("Mumbai", "Delhi");
        ticket.put("Goa","Chennai");
        ticket.put("Delhi", "Goa");

        String start = getStart(ticket);
        System.out.print(start);

        for(String key : ticket.keySet()){
            System.out.print(" --> " + ticket.get(start));
            start=ticket.get(start);
        }



    }

    public static String getStart(HashMap<String,String> ticket){

        HashMap<String,String> revMap = new HashMap<>();

        for(String key : ticket.keySet()){
            revMap.put(ticket.get(key), key);
        }

        for(String key : ticket.keySet()){
            if(!revMap.containsKey(key)){
                return key; // starting point
            }
        }
        return null;
    }
}
