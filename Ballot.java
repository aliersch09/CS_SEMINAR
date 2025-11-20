import java.util.*;
public class Ballot {
    private String[] candidates = {"Taylor Swift","Phoebe Bridgers","Billie Eilish","Gracie Abrams"};
    private String[] votes;

    public Ballot(){
        votes = new String[4];
        votes[0] = " ";
        votes[1] = " ";
        votes[2] = " ";
        votes[3] = " ";
        castVote();
    }

    public Ballot(String a, String b, String c, String d){
        votes = new String[4];
        votes[0] = a;
        votes[1] = b;
        votes[2] = c;
        votes[3] = d;
    }

    public String[] getVoteList(){
        return votes;
    }

    public String[] getCandidateList(){
        return candidates;
    }

    public String toString(){
        return votes[0]+", "+votes[1]+", "+votes[2]+", "+votes[3];
    }

    public void castVote(){
        int[] numVotes = new int[4];
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i<4; i++){
            System.out.println("What is your #"+(i+1)+" choice? (A,B,C,D)");
            String vote = scanner.nextLine();
            if(vote.equals("A")&&numVotes[0]==0){
                votes[i] = candidates[0];
                numVotes[0]++;
            }
            else if(vote.equals("B")&&numVotes[1]==0){
                votes[i] = candidates[1];
                numVotes[1]++;
            }
            else if(vote.equals("C")&&numVotes[2]==0){
                votes[i] = candidates[2];
                numVotes[2]++;
            }
            else if(vote.equals("D")&&numVotes[3]==0){
                votes[i] = candidates[3];
                numVotes[3]++;
            }
            else{
                System.out.println("Invalid Vote. Vote again. ");
                i--;
            }
        }
    }
}