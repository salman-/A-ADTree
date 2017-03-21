package ee.ut.smarttool.domain;

import java.util.ArrayList;


import lombok.Data;

@Data

public class CountermeasureNode extends Node {
	int id;
	AttackNode  counterNode;
	ArrayList<CountermeasureNode> attackChildren;
}
