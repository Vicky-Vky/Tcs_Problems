import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Player{
    private int id;
    private String name;
    private int iccRank;
    private int matchesPlayed;
    private int runsScored;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIccRank() {
        return iccRank;
    }

    public void setIccRank(int iccRank) {
        this.iccRank = iccRank;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public int getRunsScored() {
        return runsScored;
    }

    public void setRunsScored(int runsScored) {
        this.runsScored = runsScored;
    }
    public Player(int id,String name,int iccRank,int matchesPlayed,int runsScored){
        this.id = id;
        this.name = name;
        this.iccRank = iccRank;
        this.matchesPlayed = matchesPlayed;
        this.runsScored = runsScored;
    }
}
class SolutionsPlayer{
    public static double[] findAverageOfRuns(Player[] playerobj,int target){
        double[] averageArr = new double[0];
        for(Player x:playerobj){
            if(target<= x.getMatchesPlayed()){
                averageArr = Arrays.copyOf(averageArr,averageArr.length+1);
                averageArr[averageArr.length-1]=(double)(x.getRunsScored()/ x.getMatchesPlayed());
            }
        }
        return averageArr;
    }
}
public class PlayersGetAvgProb {
    public static void main(String[] args)throws IOException{
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        Player[] playersobj = new Player[4];
        for(int i=0;i<4;i++){
            int id = Integer.parseInt(br.readLine());
            String name = br.readLine();
            int iccRank = Integer.parseInt(br.readLine());
            int matchesPlayed = Integer.parseInt(br.readLine());
            int runsScored = Integer.parseInt(br.readLine());
            Player obj = new Player(id,name,iccRank,matchesPlayed,runsScored);
            playersobj[i] = obj;
        }
        int searchTarget = Integer.parseInt(br.readLine());
        double[] resArr = SolutionsPlayer.findAverageOfRuns(playersobj,searchTarget);
        for(double x:resArr){
            if(x>=80&&x<=100){
                System.out.println("Grade A");
            }else if(x>=50&&x<=79){
                System.out.println("Grade B");
            }else
                System.out.println("Grade C");
        }
    }
}