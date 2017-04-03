/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lu.uni.adtool.tree;

import static java.lang.System.in;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;


/**
 *
 * @author Salman
 */
public class TreeSchema {

   // public static HashMap<String,ArrayList<SimpleNode>> tree=new HashMap<String,ArrayList<SimpleNode>>();
    
  static TreeMap<String,ArrayList<SimpleNode>> tree = new TreeMap<String,ArrayList<SimpleNode>>();

    public static Stack findChildrenToDelete(SimpleNode parentNode){
        Stack nodesToDelete = new Stack();
        nodesToDelete.add(parentNode);
        String key=keyMaker(parentNode.getId(), parentNode.getType());
        ArrayList<SimpleNode> children=tree.get(key);
        if(children!=null)
            for(int i=0;i<children.size();i++){
                // add recursive children to the result
                nodesToDelete.addAll(findChildrenToDelete(children.get(i)));
            }
        return nodesToDelete;  
    }
    
    public static void deleteNode(SimpleNode parentNode){
      Stack nodes = findChildrenToDelete(parentNode);
      while(!nodes.isEmpty()){
          SimpleNode node =(SimpleNode) nodes.peek();
          
          nodes.pop();
         // if(nodes.size()==1)
          //    break;
          System.out.println("ID is: "+node.getId());
      }
      
    }
    
    
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
