import java.io.*;
import java.util.*;
public class DataSetProject{
    public static void main(String[] args) throws FileNotFoundException{
        //calls method using data set
        countryMostPop("/Users/aliersch/Downloads/artists2.csv");
    }
    public static void countryMostPop(String pathname) throws FileNotFoundException, NumberFormatException{
        File f = new File(pathname);
        Scanner sc = new Scanner(f);
        //the index of the artists country
        int country_idx = 4;
        //the index of the number of listeners for that artist
        int listeners_inx = 7;
        //number of us artist listeners to be counted in loop
        int usArtistListeners = 0;
        //number of non us artist listeners to be counted in loop
        int nonUSArtistListeners = 0;
        while(sc.hasNextLine()){
            //splits the data set and put into array list - each element is separated by ,
            ArrayList<String> line = new ArrayList<>(Arrays.asList(sc.nextLine().split(",")));
            //if artist is from the us add their number of listeners to us artist listeners number
            if(line.get(country_idx).equals("United States")){
                if(isParseable(line.get(listeners_inx))){
                    usArtistListeners += (Integer.parseInt(line.get(listeners_inx)));
                }
            //if artist is not from the us add their number of listeners to non us listeners number
            }else{
                if(isParseable(line.get(listeners_inx))){
                    nonUSArtistListeners += (Integer.parseInt(line.get(listeners_inx)));
                }
            }
        }
        //determines which is greater and prints our results
        if(usArtistListeners>nonUSArtistListeners){
            System.out.println("Artists from the US are more popular than combined artists everywhere else.");
        }
        else{
            System.out.println("Artists from other countries combined are overall more popular than all artists in the US.");
        }
    }
    //helps with issues in the data set - if there are extra commas or empty elements
    public static boolean isParseable(String s){
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}