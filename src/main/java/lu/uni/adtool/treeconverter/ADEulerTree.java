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
package lu.uni.adtool.treeconverter;

import lu.uni.adtool.tree.Node;
import lu.uni.adtool.tree.ADTNode;

import java.util.Collections;
import java.util.Vector;

/**
 * A tree node to calculate approximate minimal tree edit distance in n^2 time
 *
 * @author Piotr Kordy
 */
public class ADEulerTree {

  public ADEulerTree() {
    init();
  }

  public enum Operation {
    NONE, ADD, DEL, CHANGE
  };

  /**
   * Initialization method.
   *
   */
  private void init() {
    ld = new LabelDictionary();
    // store the nodes types without the labels - we will add -(first time)
    // and +(second time) at the start of each label to differentiate

    ld.store("op+");
    ld.store("ap+");
    ld.store("oo+");
    ld.store("ao+");
    ld.store("op-");
    ld.store("ap-");
    ld.store("oo-");
    ld.store("ao-");
  }

  public Vector<Operation> levenshteinPath(Vector<Integer> v1, Vector<Integer> v2) {
    // todo: http://www.berghel.net/publications/asm/asm.php ukkonen algorith is
    // faster
    int[][] costs = new int[v1.size() + 1][v2.size() + 1];
    int i, j;
    // initialize cost table
    for (i = 0; i <= v1.size(); i++) {
      costs[i][0] = i;
    }
    for (j = 1; j <= v2.size(); j++) {
      costs[0][j] = j;
    }
    // calculate cost table
    for (j = 0; j < v2.size(); j++) {
      for (i = 0; i < v1.size(); i++) {
        if (v1.elementAt(i).intValue() == v2.elementAt(j).intValue()) {
          costs[i + 1][j + 1] = costs[i][j];
        }
        else {
          costs[i + 1][j + 1] =
              Math.min(Math.min(costs[i + 1][j], costs[i][j + 1]), costs[i][j]) + 1;
        }
      }
    }
    // construct the path from cost table
    Vector<Operation> result = new Vector<Operation>();
    i = v1.size();
    j = v2.size();
    Operation lastOp;
    int lastValue;
    while (i != 0 && j != 0) {
      lastValue = costs[i - 1][j - 1];
      lastOp = Operation.NONE;
      if (costs[i][j] > lastValue) {
        lastOp = Operation.CHANGE;
      }
      if (costs[i][j - 1] < lastValue) {
        lastOp = Operation.ADD;
        lastValue = costs[i][j - 1];
      }
      if (costs[i - 1][j] < lastValue) {
        lastOp = Operation.DEL;
        lastValue = costs[i - 1][j];
      }
      switch (lastOp) {
      case ADD:
        j--;
        break;
      case DEL:
        i--;
        break;
      default:
        i--;
        j--;
        break;
      }
      result.add(lastOp);
    }
    for (int a = j; a > 0; a--) {
      result.add(Operation.ADD);
    }
    for (int a = i; a > 0; a--) {
      result.add(Operation.DEL);
    }
    // for (j = 0; j <= v2.size(); j++) {
    // for (i = 0; i <= v1.size(); i++) {
    // System.out.print(" "+costs[i][j]);
    // }
    // Debug.log("]");
    // }
    Collections.reverse(result);
    // Debug.log(result);
    return result;
  }

  /**
   * Return an euler string for the tree as an array of integers which can be
   * translated to strings using LabelDictionary
   *
   * @param root
   *          of the tree
   */
  public Vector<Integer> eulerString(ADTNode root) {
    Vector<Integer> result = new Vector<Integer>();
    return eulerSubstring(root, result);
  }

  private Vector<Integer> eulerSubstring(ADTNode node, Vector<Integer> result) {
    result.add(node2Int(node, true));
    if (!node.isLeaf()) {
      for (Node child : node.getChildren()) {
        result = eulerSubstring((ADTNode) child, result);
      }
    }
    result.add(node2Int(node, false));
    return result;
  }

  private Integer node2Int(ADTNode node, boolean down) {
    String ch = "-";
    if (down) {
      ch = "+";
    }
    switch (node.getType()) {
    case OR_OPP:
      return new Integer(ld.store("oo" + ch));
    case AND_OPP:
      return new Integer(ld.store("ao" + ch));
    case OR_PRO:
      return new Integer(ld.store("op" + ch));
    case AND_PRO:
      return new Integer(ld.store("ap" + ch));
    }
    return null;
  }

  public void transferLabels(final ADTNode oldTree, final ADTNode newTree) {
    Vector<Integer> vOld = eulerString(oldTree);
    Vector<Integer> vNew = eulerString(newTree);
    Vector<Operation> lP = levenshteinPath(vOld, vNew);
    Vector<ADTNode> index2Node1 = getEulerOrdering(oldTree);
    Vector<ADTNode> index2Node2 = getEulerOrdering(newTree);
    int index = 0;
    int iL = 0;
    int iR = 0;
    while (index < lP.size()) {
      switch (lP.elementAt(index)) {
      case NONE:
      case CHANGE:
        ADTNode leftNode = index2Node1.elementAt(iL);
        ADTNode rightNode = index2Node2.elementAt(iR);
        if (!leftNode.isLeaf()) {
          leftNode.setName(rightNode.getName());
        }
        iL++;
        iR++;
        break;
      case ADD:
        iR++;
        break;
      case DEL:
        iL++;
        break;
      }
      index++;
    }
  }

  private Vector<ADTNode> getEulerOrdering(ADTNode t1) {
    Vector<ADTNode> v = new Vector<ADTNode>();
    getEulerOrdering(t1, v);
    return v;
  }

  private void getEulerOrdering(ADTNode t, Vector<ADTNode> v) {
    v.add(t);
    if (t.getChildren() != null) {
      for (int childrenCount = 0; childrenCount < t.getChildren().size(); ++childrenCount) {
        getEulerOrdering((ADTNode) t.getChildren().get(childrenCount), v);
      }
    }
    v.add(t);
  }

  protected LabelDictionary ld;
}
