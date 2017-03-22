package ee.ut.smarttool.domain;

import java.util.ArrayList;

public class ThreatAgent {
	int id;	
	String motives;
	ArrayList<String>  means;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMotives(String motives) {
        this.motives = motives;
    }

    public void setMeans(ArrayList<String> means) {
        this.means = means;
    }

    public void setCapabilities(String capabilities) {
        this.capabilities = capabilities;
    }

    public void setOpportunities(String opportunities) {
        this.opportunities = opportunities;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getMotives() {
        return motives;
    }

    public ArrayList<String> getMeans() {
        return means;
    }

    public String getCapabilities() {
        return capabilities;
    }

    public String getOpportunities() {
        return opportunities;
    }

    public double getScore() {
        return score;
    }
	String capabilities;
	String opportunities;
	
	double score;
	
}
