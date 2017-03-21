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
       
          case "Personal fame":
              this.motive= 4;
              break;
          case "Personal Gain":
              this.motive= 6;
              break;
          case "Revenge":
              this.motive= 6;
              break;
          case "National interest":
              this.motive= 6;
              break;
          case "Ideology":
              this.motive= 6;
              break;
           default: 
              this.motive= 3;
              break;
      } 
      
        System.out.println("motives:"+this.motive+"capabilities:"+
                            this.capabilities+"opportunities:"
                            +this.opportunities+"means: "+means);
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
              this.capabilities= 6;
              break;
          default:
              this.capabilities= 2;
              break;
      } 
        System.out.println("motives:"+this.motive+"capabilities:"+
                            this.capabilities+"opportunities:"
                            +this.opportunities+"means: "+means);
    }
    public void opportunitiesSetter(String opportunities){
        switch(opportunities){
            case "One":
                this.opportunities= 1;
                break;
            case "Finite":
                this.opportunities= 4; 
                break;
            case "Infinite":
                this.opportunities= 10;
                break;
            case "Zero":
                this.opportunities= 0;
                break;

        } 
            System.out.println("motives:"+this.motive+"capabilities:"+
                            this.capabilities+"opportunities:"
                            +this.opportunities+"means: "+means);
      }
    
    public void meansSetter(String ins){
       if(ins=="add")
            means=means+5;
        else 
            means=means-5;
         scoreEvaluator(); 
        System.out.println("motives:"+this.motive+"capabilities:"+
                            this.capabilities+"opportunities:"
                            +this.opportunities+"means: "+means);
      }
    
    public double scoreEvaluator(){
           
              score=(capabilities+means+motive)*opportunities/4;
              System.out.println("Score: "+score);
              return score;
    }
}
