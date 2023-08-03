import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class NavalVessel{
    private int vesselId;
    private String vesselName;
    private int noOfVoyagesPlanned;
    private int noOfVoyagesCompleted;
    private String purpose;
    private String classification;

    public int getVesselId() {
        return vesselId;
    }

    public void setVesselId(int vesselId) {
        this.vesselId = vesselId;
    }

    public String getVesselName() {
        return vesselName;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    public int getNoOfVoyagesPlanned() {
        return noOfVoyagesPlanned;
    }

    public void setNoOfVoyagesPlanned(int noOfVoyagesPlanned) {
        this.noOfVoyagesPlanned = noOfVoyagesPlanned;
    }

    public int noOfVoyagesCompleted() {
        return noOfVoyagesCompleted;
    }

    public void setGetNoOfVoyagesCompleted(int noOfVoyagesCompleted) {
        this.noOfVoyagesCompleted = noOfVoyagesCompleted;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public NavalVessel(int vesselId,String vesselName,int noOfVoyagesPlanned,int noOfVoyagesCompleted,String purpose){
        this.vesselId = vesselId;
        this.vesselName = vesselName;
        this.noOfVoyagesPlanned = noOfVoyagesPlanned;
        this.noOfVoyagesCompleted = noOfVoyagesCompleted;
    }
}
class SolutionNav{
    public static int findAvgVoyagesByPct(NavalVessel[] navalobj,int percentage){
        int sum= 0;
        int count = 0;
        for(NavalVessel x:navalobj){
            int testCalc = (x.noOfVoyagesCompleted()*100)/ x.getNoOfVoyagesPlanned();
            if(testCalc >= percentage){
                sum += testCalc;
                count ++;
            }
        }
        return sum/count;
    }
    public static NavalVessel findVesselByGradeMethod(String purpose, NavalVessel[] navalObj){
        for(NavalVessel x : navalObj){
            if (x.getPurpose().equals(purpose)){
                int testCalc = (x.noOfVoyagesCompleted()*100)/ x.getNoOfVoyagesPlanned();
                if(testCalc == 100){
                    x.setClassification("star");
                }
                if(testCalc >= 80 && testCalc <= 99){
                    x.setClassification("Leader");
                }
                if (testCalc<= 79 && testCalc >=55){
                    x.setClassification("Insprier");
                }
                else{
                    x.setClassification("Striver");
                }
            }
            return x;
        }
        return null;
    }
}
public class NavalVesselProb{
    public static void main(String[] args)throws IOException {
        NavalVessel[] navalobj = new NavalVessel[4];
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        for(int i=0;i<4;i++){


            int vesselId = Integer.parseInt(br.readLine());
            String vesselName = br.readLine();
            int noOfVoayagesPlanned = Integer.parseInt(br.readLine());
            int noOfVoayagesCompleted = Integer.parseInt(br.readLine());
            String purpose = br.readLine();

            NavalVessel obj = new NavalVessel(vesselId,vesselName,noOfVoayagesPlanned,noOfVoayagesCompleted,purpose);
            navalobj[i] = obj;

        }
        int percentage  = Integer.parseInt(br.readLine());
        String searchPurpose = br.readLine();

        int resAvg=SolutionNav.findAvgVoyagesByPct(navalobj,percentage);
        System.out.println(resAvg);

        NavalVessel resObj = SolutionNav.findVesselByGradeMethod(searchPurpose,navalobj);
        System.out.println(resObj.getVesselName()+"%"+resObj.getClassification());
    }
}