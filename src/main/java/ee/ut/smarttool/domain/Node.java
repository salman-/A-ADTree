package ee.ut.smarttool.domain;

import lombok.Data;

@Data

public class Node {
	
	int id;
	boolean isRoot;
	
	String Name;
	
	double probability;

	NodeType type;

}
