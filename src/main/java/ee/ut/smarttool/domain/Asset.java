package ee.ut.smarttool.domain;


import lombok.Data;

@Data
public class Asset {
	int id;
	String assetName;
	
	double assetValue;
	
	int attackedNumber;
	
	
}
