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
