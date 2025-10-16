import java.util.*;
public class Tally{
    private ArrayList<Ballot> ballot;
    private int[] counter;
    private String[] eliminated;
    private String winner;
    private double percent;
    private int rounds;

    public Tally(ArrayList<Ballot> ballot){
        this.ballot = ballot;
        counter = new int[4];
        eliminated = new String[4];
        countNext();
    }

    public void countNext(){
        for(int j = 0; j <counter.length; j++){
            rounds++;
            for(int i = 0; i<ballot.size(); i++){
                String choice = ballot.get(i).getVoteList()[j];
                if(choice.equals(ballot.get(i).getCandidateList()[0])&&eliminated[j]==null){
                    counter[0]++;
                }
                else if(choice.equals(ballot.get(i).getCandidateList()[1])&&eliminated[j]==null){
                    counter[1]++;
                }
                else if(choice.equals(ballot.get(i).getCandidateList()[2])&&eliminated[j]==null){
                    counter[2]++;
                }
                else if(choice.equals(ballot.get(i).getCandidateList()[3])&&eliminated[j]==null){
                    counter[3]++;
                }
            }
            if(isMajority()==true){
                break;
            }
        }
    }

    public boolean isMajority(){
        boolean is = false;
        int max = counter[0];
        int maxIndex = 0;
        int min = counter[0];
        int minIndex = 0;
        double sum = 0.0;
        for(int i = 0; i<counter.length; i++){
            if(counter[i]>max){
                max = counter[i];
                maxIndex = i;
            }
            if(counter[i]<min){
                min = counter[i];
                minIndex = i;
            }
            sum+=counter[i];
        }
        percent = ((double)(max)/(sum))*100;
        if(percent>=50){
            is = true;
            winner = ballot.get(0).getCandidateList()[maxIndex];
        }
        else{
            counter[minIndex] = 0;
            eliminated[minIndex] = "eliminated";
        }
        return is;
    }

    public String toString(){
        if(counter[0]==0&&counter[1]==0&&counter[2]==0&&counter[3]==0){
            return "The votes have not been counted yet.";
        }
        else{
            return "The winner is "+winner+"! There were "+rounds+" rounds, and the winner was "+percent+"% of the votes.";
        }
    }
}