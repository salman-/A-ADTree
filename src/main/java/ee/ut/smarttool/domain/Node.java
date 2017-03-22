package ee.ut.smarttool.domain;



public class Node {
	
	int id;
	boolean isRoot;
	
	String Name;
	
	double probability;

    public void setId(int id) {
        this.id = id;
    }

    public void setIsRoot(boolean isRoot) {
        this.isRoot = isRoot;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public void setType(NodeType type) {
        this.type = type;
    }

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

	NodeType type;

}
