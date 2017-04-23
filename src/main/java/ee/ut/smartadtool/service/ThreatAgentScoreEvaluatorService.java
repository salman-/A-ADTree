package ee.ut.smartadtool.service;

public class ThreatAgentScoreEvaluatorService {
    double motive;
    double capabilities;
    double opportunities;
    double means;
    double score;
    public ThreatAgentScoreEvaluatorService(){
        means=0.0;
        score=0.0;
        motive=3.0;
        opportunities=0.0;
        capabilities=2.0;
    }
    
    public void motivationSetter(String motive){
      
      switch(motive){
       
          case "Personal Fame":
              this.motive= 3.0;
              break;
          case "Personal Gain":
              this.motive= 5.0;
              break;
          case "Revenge":
              this.motive= 7.0;
              break;
          case "National Interest":
              this.motive= 9.0;
              break;
          case "Ideology":
              this.motive= 11.0;
              break;
           default: 
              this.motive= 1.0;
              break;
      }
      System.out.println("|"+motive+" | "+this.motive);
    }
    
    public void capabilitiesSetter(String capabilities){
        
      switch(capabilities){
       
          case "Undergraduate":
              this.capabilities= 4.0;
              break;
          case "Specialist":
              this.capabilities= 10.0;
              break;
          case "Master":
              this.capabilities= 7.0;
              break;
          default:
              this.capabilities= 1.0;
              break;
      } 
      System.out.println("|"+capabilities+" | "+this.capabilities);
    }
    public void opportunitiesSetter(String opportunities){
        
        switch(opportunities){
            case "1":
                this.opportunities= 1.0;
                break;
            case "Finite":
                this.opportunities= 4.0; 
                break;
            case "Infinite":
                this.opportunities= 10.0;
                break;
            case "0":
                this.opportunities= 0.0;
                break;

        }
        System.out.println("|"+opportunities+" | "+this.opportunities);

      }
    
    public void meansSetter(String ins){
       if(ins=="add")
            means=means+5.0;
        else 
            means=means-5.0;
         scoreEvaluator(); 
        System.out.println("means: "+means);
      }
    
    public String scoreEvaluator(){
           
              score=((capabilities+means+motive)*opportunities)/(4.0*115.0);
              System.out.println("capabilities: "+capabilities+" means: "+means+" motive: "+motive+" Score: "+score);
              return Double.toString(score);
    }
}
