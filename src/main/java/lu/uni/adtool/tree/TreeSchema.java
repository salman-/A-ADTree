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
/*
public class TreeSchema {

   // public static HashMap<String,ArrayList<SimpleNode>> tree=new HashMap<String,ArrayList<SimpleNode>>();
    
 // public static TreeMap<String,ArrayList<SimpleNode>> tree = new TreeMap<String,ArrayList<SimpleNode>>();

    public static Stack findChildrenToDelete(SimpleNode parentNode){
        Stack nodesToDelete = new Stack();
        nodesToDelete.add(parentNode);
        String key=keyMaker(parentNode.getId(), parentNode.getType());
        ArrayList<SimpleNode> children=treeS.get(key);
        if(children!=null)
            for(int i=0;i<children.size();i++){
                // add recursive children to the result
                nodesToDelete.addAll(findChildrenToDelete( tree,children.get(i)));
            }
        return nodesToDelete;  
    }
    
    public static TreeMap<String, ArrayList<SimpleNode>> deleteNode(SimpleNode parentNode){
      
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
                }
           } catch (Exception ex) {
                  Logger.getLogger(TreeSchema.class.getName()).log(Level.SEVERE, null, ex);
            }

          
      }
      return tree;
    }
    
    public static boolean hasChildren(TreeMap<String,ArrayList<SimpleNode>> tree,SimpleNode node){
        try{
            String id= keyMaker(node.getId(),node.getType());
            ArrayList<SimpleNode> children = tree.get(id);
            boolean res = (children==null) ? false :true;
            return res;
        }catch(Exception e){
            return false;
        }
    }
    
    public static String keyMaker(String id,String type){
        return id+"|"+type;
    }
    
    public static TreeMap<String, ArrayList<SimpleNode>> addChild(TreeMap<String,ArrayList<SimpleNode>> tree,String parent,String childId,String nodeType){
        ArrayList<SimpleNode> childrenList= new ArrayList<SimpleNode>();
        tree.put(keyMaker(childId,nodeType),childrenList);
        
      //  if(children==null)
      //      children=new ArrayList<SimpleNode>();
        ArrayList<SimpleNode> children = tree.get(parent);
        children.add(new SimpleNode(childId, nodeType)); 
        tree.put(parent,children);
       return tree;
    }
    public static TreeMap<String, ArrayList<SimpleNode>> addRoot(TreeMap<String,ArrayList<SimpleNode>> tree,SimpleNode parent){
        
        String key=keyMaker(parent.getId(),parent.getType());
        ArrayList<SimpleNode> childrenList= new ArrayList<SimpleNode>();
        tree.put(key, childrenList);  
        return tree;
    }
    
     public static void printTree(TreeMap<String,ArrayList<SimpleNode>> tree){
        for (String key : tree.keySet()) {
                System.out.println("Parent is: "+key);
                
        }
    }
    
}*/
