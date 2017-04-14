/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lu.uni.adtool.tree;

/**
 *
 * @author Salman
 */
public class SimpleNode {
    String id;
    String type;
    boolean isAtomic;
    String atomicId;
    String probability;
    String costOfDamage;
    String cost;
    
    public void setCostOfDamage(String costOfDamage) {
        this.costOfDamage = costOfDamage;
    }

    public String getCostOfDamage() {
        return costOfDamage;
    }
    
    public boolean isIsAtomic() {
        return isAtomic;
    }

    public String getAtomicId() {
        return atomicId;
    }

    public String getProbability() {
        return probability;
    }

    public String getCost() {
        return cost;
    }

    public void setIsAtomic(boolean isAtomic) {
        this.isAtomic = isAtomic;
    }

    public void setAtomicId(String atomicId) {
        this.atomicId = atomicId;
    }

    public void setProbability(String probability) {
        this.probability = probability;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
    
    public void printInfo(){
        System.out.println("Id: "+id+" Type: "+type);
    }
    
    
    public SimpleNode(String id,String type){
        this.id=id;
        this.type=type;
        atomicId="?";
        probability="?";
        cost="?";
        costOfDamage="?";
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }
    
    
}
