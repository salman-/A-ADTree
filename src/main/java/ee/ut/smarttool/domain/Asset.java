package ee.ut.smarttool.domain;



public class Asset {
	int id;
	String assetName;
	
	double assetValue;

    public int getId() {
        return id;
    }

    public String getAssetName() {
        return assetName;
    }

    public double getAssetValue() {
        return assetValue;
    }

    public int getAttackedNumber() {
        return attackedNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public void setAssetValue(double assetValue) {
        this.assetValue = assetValue;
    }

    public void setAttackedNumber(int attackedNumber) {
        this.attackedNumber = attackedNumber;
    }
	
	int attackedNumber;
	
	
}
