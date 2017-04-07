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
    double probability;
    double cost;

    public boolean isIsAtomic() {
        return isAtomic;
    }

    public String getAtomicId() {
        return atomicId;
    }

    public double getProbability() {
        return probability;
    }

    public double getCost() {
        return cost;
    }

    public void setIsAtomic(boolean isAtomic) {
        this.isAtomic = isAtomic;
    }

    public void setAtomicId(String atomicId) {
        this.atomicId = atomicId;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    
    public void printInfo(){
        System.out.println("Id: "+id+" Type: "+type);
    }
    
    
    public SimpleNode(String id,String type){
        this.id=id;
        this.type=type;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }
    
    
}
