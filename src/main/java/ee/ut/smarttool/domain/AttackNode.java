package ee.ut.smarttool.domain;

import java.util.ArrayList;



public class AttackNode extends Node {

	int id;
	Asset asset;

    public int getId() {
        return id;
    }

    public boolean isIsRoot() {
        return isRoot;
    }

    public String getName() {
        return Name;
    }

    public double getProbability() {
        return probability;
    }

    public NodeType getType() {
        return type;
    }

    public Asset getAsset() {
        return asset;
    }

    public ThreatAgent getThreatAgent() {
        return threatAgent;
    }

    public Vulnerability getVulnerability() {
        return vulnerability;
    }

    public CountermeasureNode getCounterNode() {
        return counterNode;
    }

    public ArrayList<AttackNode> getAttackChildren() {
        return attackChildren;
    }
	
	ThreatAgent threatAgent;
	
	Vulnerability vulnerability; 
	
	CountermeasureNode counterNode;
	
	ArrayList<AttackNode> attackChildren;
	
}
