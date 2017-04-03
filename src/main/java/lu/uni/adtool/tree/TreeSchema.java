/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lu.uni.adtool.tree;

import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author Salman
 */
public class TreeSchema {
    
    public static HashMap<String,ArrayList<SimpleNode>> tree=new HashMap<String,ArrayList<SimpleNode>>();
    
    public static String keyMaker(String id,String type){
        return id+"|"+type;
    }
    
    public static void addChild(String parent,String childId,String nodeType){
        tree.put(keyMaker(childId,nodeType), null);
        ArrayList<SimpleNode> children = tree.get(parent);
        if(children==null)
            children=new ArrayList<SimpleNode>();
        children.add(new SimpleNode(childId, nodeType)); 
        tree.put(parent,children);
      //  printTree();
    }
    public static void addRoot(SimpleNode parent){
        String key=keyMaker(parent.getId(),parent.getType());
        tree.put(key, null);  
    }
    
     public static void printTree(){
        for (String key : tree.keySet()) {
                System.out.println("Parent is: "+key);
                
        }
    }
    
}
