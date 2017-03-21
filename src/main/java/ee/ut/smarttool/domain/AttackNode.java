package ee.ut.smarttool.domain;

import java.util.ArrayList;


import lombok.Data;

@Data

public class AttackNode extends Node {

	int id;
	Asset asset;
	
	ThreatAgent threatAgent;
	
	Vulnerability vulnerability; 
	
	CountermeasureNode counterNode;
	
	ArrayList<AttackNode> attackChildren;
	
}
