import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Associates{
    private int id;
    private String technology;
    private String name;
    private int experienceInYears;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperienceInYears() {
        return experienceInYears;
    }

    public void setExperienceInYears(int experienceInYears) {
        this.experienceInYears = experienceInYears;
    }

    public Associates(int  id,String technology,String name,int experienceInYears){
        this.id = id;
        this.name=name;
        this.experienceInYears = experienceInYears;
        this.technology =technology;
    }
}

class Solution{
    public static Associates[] assosicateForGivenTechnology(Associates Associateobj[],String searchTechnology){
            Associates Associate1[]=new Associates[0];
            for(Associates x:Associateobj){
                if(searchTechnology.equals(x.getTechnology())&&x.getExperienceInYears()%5==0){
                    Associate1 = Arrays.copyOf(Associate1,Associate1.length+1);
                    Associate1[Associate1.length-1]=x;
                }
        }
            return Associate1;
    }
}
public class Associate{

    public static void main(String args[])throws IOException {
        Associates Associateobj[] =new Associates[5];
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);

        for(int i =0;i<=4;i++){



            int id = Integer.parseInt(br.readLine());
            String name = br.readLine();
            String technology = br.readLine();

            int experienceInYears = Integer.parseInt(br.readLine());

            Associates obj =  new Associates(id,technology,name,experienceInYears);
            Associateobj[i] = obj;

        }

        System.out.println("Enter term to search");

        String searchTechnology = br.readLine();

        Associates result[] = Solution.assosicateForGivenTechnology(Associateobj,searchTechnology);
        for(Associates x : result){
            System.out.println(x.getId());
        }


    }
}