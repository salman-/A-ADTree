package ee.ut.smarttool.domain;

import java.util.ArrayList;


public class CountermeasureNode extends Node {
	int id;
	AttackNode  counterNode;

    public int getId() {
        return id;
    }

    public AttackNode getCounterNode() {
        return counterNode;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCounterNode(AttackNode counterNode) {
        this.counterNode = counterNode;
    }

    public void setAttackChildren(ArrayList<CountermeasureNode> attackChildren) {
        this.attackChildren = attackChildren;
    }

    public ArrayList<CountermeasureNode> getAttackChildren() {
        return attackChildren;
    }
	ArrayList<CountermeasureNode> attackChildren;
}
