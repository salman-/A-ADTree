/**
 * Author: Piotr Kordy (piotr.kordy@uni.lu <mailto:piotr.kordy@uni.lu>)
 * Date:   10/12/2015
 * Copyright (c) 2015,2013,2012 University of Luxembourg -- Faculty of Science,
 *     Technology and Communication FSTC
 * All rights reserved.
 * Licensed under GNU Affero General Public License 3.0;
 *    This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU Affero General Public License as
 *    published by the Free Software Foundation, either version 3 of the
 *    License, or (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU Affero General Public License for more details.
 *
 *    You should have received a copy of the GNU Affero General Public License
 *    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package lu.uni.adtool.tree;


import ee.ut.smarttool.DB.AttackDBService;
import ee.ut.smarttool.DB.AttackTreeDBService;
import java.io.Serializable;
import java.util.ArrayList;
import ee.ut.smarttool.DB.IDGenerator;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Node implements Serializable{

  public Node()  {

    AttackTreeDBService attackTreeDBService = new AttackTreeDBService();
    AttackDBService attackDBService=new AttackDBService();
    this.id=IDGenerator.nextId();
    this.name = "root";
    this.parent = null;
      try {
          attackDBService.insertAttack(name+id, "", "0");
          String res = attackDBService.selectIdFromField("attack", "name", "'"+name+id+"'");
          this.id=res;
          attackTreeDBService.insertAttackTree(res, res);
      } catch (Exception ex) {
          Logger.getLogger(Node.class.getName()).log(Level.SEVERE, null, ex);
      } 
    this.operation="And";
    this.description = "";
  }

  public Node(String name) {
    this.id=IDGenerator.nextId();
    this.parent = null;
    this.name = name;
    this.description ="";
  }


  public final boolean isLeaf() {
    if (children == null) return true;
    if (children.size() == 0) return true;
    return false;
  }

  public boolean hasDefault() {return isLeaf();}

  public final Node getParent() { return this.parent;}

  public void addChild(Node child) {
    getNotNullChildren().add(child);
    child.setParent(this);
  }

  public ArrayList<Node> getChildren() {return this.children; }

  public ArrayList<Integer> toPath() {
    if (parent == null ) {
      return new ArrayList<Integer>();
    }
    else {
      ArrayList<Integer> result = parent.toPath();
      final int index = parent.getChildren().indexOf(this);
      result.add(new Integer(index));
      return result;
    }
  }

  public Node fromPath(ArrayList<Integer> path, int index) {
    if (path.size() == 0) {
      return this;
    }
    if (path.size() == index + 1) {
      return children.get(path.get(index));
    }
    else {
      Node child = children.get(path.get(index));
      return child.fromPath(path, index + 1);
    }
  }

  public ArrayList<Node> getNotNullChildren() {
    if (this.children == null) {
      this.children = new ArrayList<Node>();
    }
    return this.getChildren();
  }

  public void setChildren(ArrayList<Node> newChildren) {this.children = newChildren;}

  /**
   * Removes all children of a node.
   *
   * @param node
   *          node of which children should be removed.
   */
  public final void removeAllChildren(final Node node) {
    for (Node n : children) {
      removeAllChildren(n);
    }
    children.clear();
  }

  /**
   * Removes a node and moves children to the current node.
   *
   * @param child
   *          node to be removed from the list of children.
   */
  public final void removeChild(final Node child) {
    if (children == null) {
      System.err.println("Tried to remove child from node with no children");
      return;
    }
    final int index = children.indexOf(child);
    if (index == -1) {
      System.err.println("Tried to remove child from that" + " is not contained in children");
      return;
    }
    final ArrayList<Node> newChildren = ((Node) child).children;
    children.remove(index);
    children.addAll(index, newChildren);
    for (Node c : newChildren) {
      c.setParent(this);
    }
  }

  /**
   * Adds a child at a specified index and assigns to it number of children.
   *
   * @param child
   *          child to be added
   * @param indexAt
   *          index at which we add child (from 0 to number of children parent
   *          has)
   * @param noChildren
   *          number of children to be transfered.
   */

  public final void addChildAt(Node child, final int indexAt) {
    // final Node child = new Node();
    // child.setType(type);
    // child.setName(name);
    this.children.add(indexAt, child);
    child.setParent(this);
//     child.setChildren(newChildren);
  }

  protected ArrayList<Node> children;
  private String            name;
  private String            description;
  private Node              parent;
  private String               id;
  private int               parent_id;
  private String            operation;
  private int               probability;
  private String            Nodetype;
  private String            cost;
  private String            costOfDamage;   //Only for attack Node
  private static final long serialVersionUID = -983678473499189388L;
  
  
  
  
  
  public String getCost() {	return cost;}

  public void setCost(String cost) {this.cost = cost;}

  public String getCostOfDamage() {return costOfDamage;}

  public void setCostOfDamage(String costOfDamage) {this.costOfDamage = costOfDamage;}

  public String getDescription() {return description;}

  public void setDescription(String description) {	this.description = description;}
	
  public int getParent_id() {return parent_id;}
	
  public void setParent_id(int parent_id) {this.parent_id = parent_id;}
	
  public String getOperation() {	return operation;}
	
  public void setOperation(String operation) {	this.operation = operation;}
	
  public int getProbability() {	return probability;}
	
  public void setProbability(int probability) {this.probability = probability;}
	
  public String getNodeType() {	return Nodetype;}
	
  public void setNodeType(String type) {	this.Nodetype = type;} 

  public String getId() {return this.id;}
	  	  
  public abstract String toString();

  public final void setName(final String n) { this.name = n;}

  public String getName() {return this.name;}

  public String getComment() {return this.description;}

  public void setComment(String comment) {this.description = comment; }

  public final void setParent(final Node p) {    this.parent = p;}

}
