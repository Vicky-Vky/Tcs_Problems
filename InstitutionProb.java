import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class  Institution{
    private int institutionId;
    private String institutionName;
    private String noOfStudentsPlaced;
    private int noOfStudentsCleared;
    private String location;

    private String grade;

    public int getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(int institutionId) {
        this.institutionId = institutionId;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getNoOfStudentsPlaced() {
        return noOfStudentsPlaced;
    }

    public void setNoOfStudentsPlaced(String noOfStudentsPlaced) {
        this.noOfStudentsPlaced = noOfStudentsPlaced;
    }

    public int getNoOfStudentsCleared() {
        return noOfStudentsCleared;
    }

    public void setNoOfStudentsCleared(int noOfStudentsCleared) {
        this.noOfStudentsCleared = noOfStudentsCleared;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public  Institution(int institutionId, String institutionName, String noOfStudentsPlaced, int noOfStudentsCleared, String location){
        this.institutionId =institutionId;
        this.institutionName = institutionName;
        this.noOfStudentsPlaced =noOfStudentsPlaced;
        this.noOfStudentsCleared = noOfStudentsCleared;
        this.location = location;
    }
}
class SolutionIns{
    public static int findNumClearancedByLoc(Institution institutionobj[],String location){
        int sumnoOfStudentsCleared = 0;
        boolean found = false;
        for(Institution x: institutionobj){
            if(location.equals(x.getLocation())){
                sumnoOfStudentsCleared += x.getNoOfStudentsCleared();
                found = true;
            }
        }
        if(found){
            return sumnoOfStudentsCleared;
        }else
            return 0;
    }
    public static Institution updateInstitutionGrade(String institutionName,Institution institutiononj[]){
        for (Institution x:institutiononj){
            if(institutionName.equals(x.getInstitutionName())){

                int noOfStudentPlacedCon = Integer.parseInt(x.getNoOfStudentsPlaced());
                int rating = (noOfStudentPlacedCon*100)/x.getNoOfStudentsCleared();
                if (rating<=80){
                    x.setGrade("A");
                }else
                    x.setGrade("B");
                return x;
            }
        }
        return null;
        }

    }

public class InstitutionProb {
    public static void main(String[] args)throws IOException {
        Institution institutionobj[]= new Institution[4];
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        for(int i=0;i<4;i++){
            System.out.println("Enter Details");
            int institutionId = Integer.parseInt(br.readLine());
            String institutionName = br.readLine();
            String noOfStudentsPlaced = br.readLine();
            int noOfStudnetsCleared = Integer.parseInt(br.readLine());
            String location = br.readLine();
            Institution obj = new Institution(institutionId,institutionName,noOfStudentsPlaced,noOfStudnetsCleared,location);
            institutionobj[i] = obj;
        }
        String searchLocation = br.readLine();
        String searchInstitutionName = br.readLine();
        int resClearance = SolutionIns.findNumClearancedByLoc(institutionobj,searchLocation);
        if(resClearance<=0){
            System.out.println("There are no students cleared in particular location..!");
        }else
            System.out.println(resClearance);
        Institution resIns = SolutionIns.updateInstitutionGrade(searchInstitutionName,institutionobj);
        System.out.println(resIns.getInstitutionName()+"::"+resIns.getGrade());
    }

}