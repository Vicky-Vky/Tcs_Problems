import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;

class Player1{
    private int playerId;
    private String skill;
    private String level;
    private int points;

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    public Player1(int playerId,String skill,String level,int points){
        this.playerId = playerId;
        this.skill = skill;
        this.level = level;
        this.points = points;
    }
}
class SolutionsPLayer1{
    public static int findPointsForGivenSkill(Player1[] playerobj,String skill){
        int sumPoints = 0;
        for(Player1 x:playerobj){
            if(skill.equals(x.getSkill())){
                sumPoints +=x.getPoints();
            }
        }
        return sumPoints;
    }
    public static Player1 getPlayerBasedOnLevel(String level,String skill,Player1[] playerobj){
        for(Player1 x:playerobj){
            if((level.equals(x.getLevel())&&skill.equals(x.getSkill()))&&x.getPoints()>=20){
                return x;
            }

        }
        return null;
    }
}
public class PlayerGetLevel{
    public static void main(String[] args)throws IOException{
        Player1[] playerobj = new Player1[4];
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        for(int i=0;i<4;i++){
            int playerId = Integer.parseInt(br.readLine());
            String skill = br.readLine();
            String level = br.readLine();
            int points = Integer.parseInt(br.readLine());

            Player1 obj = new Player1(playerId,skill,level,points);
            playerobj[i] = obj;
        }

        String searchSkill = br.readLine();
        String searchLevel = br.readLine();

        int resPoints = SolutionsPLayer1.findPointsForGivenSkill(playerobj,searchSkill);
        if(resPoints!=0){
            System.out.println(resPoints);
        }else {
            System.out.println("No Skill found..!");
        }

        Player1 resObj = SolutionsPLayer1.getPlayerBasedOnLevel(searchLevel,searchSkill,playerobj);
        if(resObj!=null){
            System.out.println(resObj.getPlayerId());
        }else
            System.out.println("NO Playerfound with given"+searchLevel+searchSkill);
    }
}