/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lu.uni.adtool.tree;

import ee.ut.smarttool.DB.AttackDBService;
import ee.ut.smarttool.DB.CountermeasureDBService;
import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Salman
 */
public class TreeSchema {

   // public static HashMap<String,ArrayList<SimpleNode>> tree=new HashMap<String,ArrayList<SimpleNode>>();
    
  public static TreeMap<String,ArrayList<SimpleNode>> tree = new TreeMap<String,ArrayList<SimpleNode>>();

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
      
      AttackDBService attack=new AttackDBService();
      CountermeasureDBService counter=new CountermeasureDBService();
      Stack nodes = findChildrenToDelete(parentNode);
      while(nodes.size()>0){
          SimpleNode node =(SimpleNode) nodes.peek();
          
          nodes.pop();
        
          System.out.println("ID is: "+node.getId()+" Type: "+node.getType());
         
          try {
             //  int res1=0;
             //   int res2=0;
                if(node.getType().contains("PRO")){
                    
                    tree.remove(keyMaker(node.getId(), node.getType()));
               /*   res1= gdb.deleteParentId("'"+"attack-counterTree"+"'",node.getId());
                  res2= gdb.deleteParentId("'"+"attackTree"+"'",node.getId());
                }else{  
                   res1=gdb.deleteParentId("'"+"counter-attackTree"+"'",node.getId());
                   res2=gdb.deleteParentId("'"+"countermeaureTree"+"'",node.getId());
               */ }
           } catch (Exception ex) {
                  Logger.getLogger(TreeSchema.class.getName()).log(Level.SEVERE, null, ex);
            }

          
      }
      
    }
    
    public static boolean hasChildren(SimpleNode node){
        try{
            String id= keyMaker(node.getId(),node.getType());
            ArrayList<SimpleNode> children = TreeSchema.tree.get(id);
            boolean res = (children==null) ? false :true;
            return res;
        }catch(Exception e){
            return false;
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
