import java.util.*;
public class BallotTester{
    public static void main(String[] args) {
        Ballot one = new Ballot();
        Ballot two = new Ballot("Taylor Swift", "Billie Eilish", "Phoebe Bridgers", "Gracie Abrams");
        Ballot three = new Ballot("Phoebe Bridgers","Taylor Swift","Gracie Abrams","Billie Eilish");
        Ballot four = new Ballot("Billie Eilish", "Phoebe Bridgers", "Taylor Swift","Gracie Abrams");
        Ballot five = new Ballot("Gracie Abrams","Taylor Swift","Phoebe Bridgers","Billie Eilish");
        ArrayList<Ballot> list = new ArrayList<>(Arrays.asList(one,two,three,four,five));
        Tally test = new Tally(list);
        System.out.println(test);
    }
}