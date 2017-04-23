package ee.ut.smartadtool.service;

public class ThreatAgentScoreEvaluatorService {
    int motive;
    int capabilities;
    int opportunities;
    int means;
    double score;
    public ThreatAgentScoreEvaluatorService(){
        means=0;
        score=0;
        motive=3;
        opportunities=0;
        capabilities=2;
    }
    
    public void motivationSetter(String motive){
      
      switch(motive){
       
          case "Personal Fame":
              this.motive= 3;
              break;
          case "Personal Gain":
              this.motive= 5;
              break;
          case "Revenge":
              this.motive= 7;
              break;
          case "National Interest":
              this.motive= 9;
              break;
          case "Ideology":
              this.motive= 11;
              break;
           default: 
              this.motive= 1;
              break;
      }
      System.out.println("|"+motive+" | "+this.motive);
    }
    
    public void capabilitiesSetter(String capabilities){
        
      switch(capabilities){
       
          case "Undergraduate":
              this.capabilities= 4;
              break;
          case "Specialist":
              this.capabilities= 10;
              break;
          case "Master":
              this.capabilities= 7;
              break;
          default:
              this.capabilities= 1;
              break;
      } 
      System.out.println("|"+capabilities+" | "+this.capabilities);
    }
    public void opportunitiesSetter(String opportunities){
        
        switch(opportunities){
            case "1":
                this.opportunities= 1;
                break;
            case "Finite":
                this.opportunities= 4; 
                break;
            case "Infinite":
                this.opportunities= 10;
                break;
            case "0":
                this.opportunities= 0;
                break;

        }
        System.out.println("|"+opportunities+" | "+this.opportunities);

      }
    
    public void meansSetter(String ins){
       if(ins=="add")
            means=means+5;
        else 
            means=means-5;
         scoreEvaluator(); 
        System.out.println("means: "+means);
      }
    
    public String scoreEvaluator(){
           
              score=((capabilities+means+motive)*opportunities)/4;
              System.out.println("Score: "+score);
              return Double.toString(score);
    }
}
