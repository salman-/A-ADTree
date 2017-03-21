package ee.ut.smarttool.domain;

import java.util.ArrayList;


import lombok.Data;

@Data

public class ThreatAgent {
	int id;	
	String motives;
	ArrayList<String>  means;
	String capabilities;
	String opportunities;
	
	double score;
	
}
