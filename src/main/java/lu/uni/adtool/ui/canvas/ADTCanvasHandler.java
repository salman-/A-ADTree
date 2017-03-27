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
package lu.uni.adtool.ui.canvas;

import ee.ut.smarttool.DB.AttackDBService;
import ee.ut.smarttool.DB.AttackTreeDBService;
import ee.ut.smarttool.DB.CountermeasureDBService;
import ee.ut.smarttool.DB.CountermeaureTreeDBService;
import ee.ut.smarttool.tree.dialogbox.Add_AtomicAction;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
//import ee.ut.smarttool.tree.dialogbox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;


import lu.uni.adtool.tools.Options;
import lu.uni.adtool.tree.ADTNode;
import lu.uni.adtool.tree.GuiNode;
import lu.uni.adtool.tree.Node;
import lu.uni.adtool.ui.MultiLineInput;
import org.apache.commons.lang3.ObjectUtils.Null;

/**
 * A handler for ADTreeCanvas.
 *
 * @author Piotr Kordy
 */
public class ADTCanvasHandler extends AbstractCanvasHandler {

  
/**
   * Constructs a new instance.
   *
   * @param canvas
   *          parent canvas
   */
  public ADTCanvasHandler(final ADTreeCanvas<?> canvas) {
    super(canvas);
    initPopupMenu();
    attackDBService=new AttackDBService();
    counterDBService=new CountermeasureDBService();
  }

  /**
   * {@inheritDoc}
   *
   * @see KeyListener#keyPressed(KeyEvent)
   */
  public void keyPressed(final KeyEvent e) {
    boolean consume = true;
    final Node node = this.canvas.getFocused();
    if (e.isControlDown()) {
      if (node != null) {
        switch (e.getKeyCode()) {
        case KeyEvent.VK_LEFT:
          ((ADTreeCanvas<?>) this.canvas).switchSibling(node, true);
          break;
        case KeyEvent.VK_RIGHT:
          ((ADTreeCanvas<?>) this.canvas).switchSibling(node, false);
          break;
        case KeyEvent.VK_J:
          ((ADTreeCanvas<?>) canvas).toggleOp(node);
          break;
        case KeyEvent.VK_I:
          ((ADTreeCanvas<?>) canvas).addCounter(node);
          break;
        case KeyEvent.VK_A:
          ((ADTreeCanvas<?>) canvas).addChild(node);
          break;
        case KeyEvent.VK_L:
          menuNode = node;
          changeLabelActionPerformed();
          break;
        case KeyEvent.VK_R:
          ((ADTreeCanvas<?>) canvas).removeTree(node);
          break;
        case KeyEvent.VK_S:
          ((ADTreeCanvas<?>) canvas).addSibling(node, !e.isShiftDown());
          break;
        default:
          consume = false;
        }
      }
      else {
        consume = false;
      }
    }
    else if (e.isShiftDown()) {
      if (node != null) {
        switch (e.getKeyCode()) {
        case KeyEvent.VK_SPACE:
          if (node != null) {
            menuNode = node;
            canvas.toggleAboveFold(menuNode);
          }
          break;
        case KeyEvent.VK_R:
          if (node != null) {
            menuNode = node;
            ((ADTreeCanvas<?>) canvas).removeChildren(node);
          }
          break;
        default:
          consume = false;
          break;
        }
      }
      else {
        consume = false;
      }
    }
    else {
      switch (e.getKeyCode()) {
      case KeyEvent.VK_ENTER:
        if (node != null) {
          menuNode = node;
          changeLabelActionPerformed();
          canvas.setFocus(menuNode);
        }
        break;
      case KeyEvent.VK_SPACE:
        if (node != null) {
          menuNode = node;
          canvas.toggleFold(menuNode);
        }
        break;
      default:
        consume = false;
      }
    }
    if (!consume) {
      super.keyPressed(e);
    }
  }

  /**
   * {@inheritDoc}
   *
   * @see MouseListener#mouseClicked(MouseEvent)
   */
  public void getNodeType(final MouseEvent e){
	  try{ 
		  selectedNode=  (ADTNode) this.canvas.getNode(e.getX(), e.getY());
		 String[] res = selectedNode.getType().toString().split("_"); 
		 selectedNodeOperation = res[0];
		 selectedNodeType=res[1];
		 selectedNodeId=Integer.toString(selectedNode.getId());
                 System.out.println("ID of Selected Node is: "+selectedNodeId+" Type is: "+selectedNodeType+" Operation: "+selectedNodeOperation);	
                 isSelectedNodeAllowedToBeAtomic=hasChildren(selectedNodeId,selectedNodeType);
               //  new PopupMenu(this, selectedNodeId,isSelectedNodeAllowedToBeAtomic);
	//	 hasChildren=  (selectedNode.getChildren().size()>0) ? true :false;
	  }catch(Exception e1){
                   isSelectedNodeAllowedToBeAtomic=true;
		  System.out.println("Failed to get the ADTree Node");
	  }
  }
  
  public final void mouseClicked(final MouseEvent e) {
	try{  
    canvas.requestFocusInWindow();
    final Node node = this.canvas.getNode(e.getX(), e.getY());
    getNodeType(e);
   // System.out.println("ID of Selected Node is: "+node.getId()+" Type is: "+node.getType());
    if (node != null) {
      if (e.getModifiers() == InputEvent.BUTTON3_MASK || e.getModifiers() == InputEvent.CTRL_MASK) {
        menuNode = node;
        this.pmenu.show(e.getComponent(), e.getX(), e.getY());
        setFocus(node);
      }
      else {
        if (node.equals(canvas.getFocused())) {
          menuNode = node;
          changeLabelActionPerformed();
          // canvas.toggleExpandNode(node);
          // this.canvas.repaint();
        }
        else {
          setFocus(node);
        }
      }
    }
   }catch(Exception e1){}
  }

  /**
   * Set new focus and update context menu visibility.
   *
   * @param node
   *          node to which we set focus.
   */
  public void setFocus(final Node node) {
    if (node != null) {
      final Node parent = canvas.getParentNode(node);
      boolean canAddSibling;
      if (parent == null || ((ADTNode)parent).getType() != ((ADTNode) node).getType()) {
        canAddSibling = false;
      }
      else {
        canAddSibling = true;
      }
      boolean canFold;
      boolean canFoldAbove;
      if (((GuiNode) node).isFolded()) {
        toggleFold.setText(Options.getMsg("handler.expandbelow.txt"));
        canFold = true;
      }
      else {
        toggleFold.setText(Options.getMsg("handler.foldbelow.txt"));
        canFold = (node.getChildren().size() > 0);
      }
      if (((GuiNode) node).isAboveFolded()) {
        toggleAboveFold.setText(Options.getMsg("handler.expandabove.txt"));
        canFoldAbove = true;
      }
      else {
        toggleAboveFold.setText(Options.getMsg("handler.foldabove.txt"));
        canFoldAbove = (node.getParent() != null);
      }
      switchLeft.setVisible(((GuiNode) node).getLeftSibling() != null
          && ((GuiNode) node).getLeftSibling() != node
          && ((ADTNode) ((GuiNode) node).getLeftSibling()).getRole() == ((ADTNode) node).getRole());
      switchRight.setVisible(
          ((GuiNode) node).getRightSibling() != null && ((GuiNode) node).getRightSibling() != node
              && ((ADTNode) ((GuiNode) node).getRightSibling()).getRole() == ((ADTNode) node)
                  .getRole());
      toggleAboveFold.setVisible(canFoldAbove);
      toggleFold.setVisible(canFold);
      addCounter.setVisible(!((ADTNode) node).isCountered());
      addLeft.setVisible(canAddSibling);
      addRight.setVisible(canAddSibling);
      removeTree.setVisible(parent != null);
      removeChildren.setVisible(canvas.getMiddleChild(node) != null);
      // removeNode.setVisible(parent!=null);
      this.pmenu.pack();
    }
    super.setFocus(node);
  }

  /**
   * Initialise context menu.
   *
   */
  private void initPopupMenu() {
    this.pmenu = new JPopupMenu();
    menuNode = null;
    editNode = new JMenuItem(Options.getMsg("handler.changeName.txt"));
    editNode.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent evt) {
    //    new Add_AtomicAction(selectedNodeId).setVisible(true);
    
      }
    });
    pmenu.add(editNode);         
            
    properties = new JMenuItem(Options.getMsg("handler.changelabel.txt"));
    properties.setAccelerator(KeyStroke.getKeyStroke(Options.getMsg("handler.changelabel.key")));
    
    properties.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent evt) {
     //   new Properties().setVisible(true);
      }
    });
    pmenu.add(properties);
    
    assignAnAtomicAction = new JMenuItem(Options.getMsg("handler.assignAnAtomicAction.txt"));
    assignAnAtomicAction.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent evt) {
        if (menuNode != null) {
          ((ADTreeCanvas<?>) canvas).toggleOp(menuNode);
        }
      }
    });
    pmenu.add(assignAnAtomicAction);
    
    toggleAboveFold = new JMenuItem(Options.getMsg("handler.foldabove.txt"));
    toggleAboveFold.setAccelerator(KeyStroke.getKeyStroke(Options.getMsg("handler.foldabove.key")));
    toggleAboveFold.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent evt) {
        if (menuNode != null) {
          canvas.toggleAboveFold(menuNode);
        }
      }
    });
    pmenu.add(toggleAboveFold);
    
    toggleFold = new JMenuItem(Options.getMsg("handler.foldbelow.txt"));
    toggleFold.setAccelerator(KeyStroke.getKeyStroke(Options.getMsg("handler.foldbelow.key")));
    toggleFold.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent evt) {
        if (menuNode != null) {
          canvas.toggleFold(menuNode);
        }
      }
    });
    pmenu.add(toggleFold);
    pmenu.addSeparator();

    addChild = new JMenuItem(Options.getMsg("handler.addchild.txt"));
    addChild.setAccelerator(KeyStroke.getKeyStroke(Options.getMsg("handler.addchild.key")));
    addChild.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent evt) {
        if (menuNode != null) {
        	// new Edit_LabelAtomicAction(selectedNodeId).setVisible(true);
          ((ADTreeCanvas<?>) canvas).addChild(menuNode,selectedNodeId);
        }
      }
    });
    pmenu.add(addChild);

    addCounter = new JMenuItem(Options.getMsg("handler.counter.txt"));
    addCounter.setAccelerator(KeyStroke.getKeyStroke(Options.getMsg("handler.counter.key")));
    addCounter.addActionListener(new ActionListener() {
        private JPanel p;
       
      public void actionPerformed(final ActionEvent evt) {
        if (menuNode != null) {

             
            JPanel panel = createDialogPanel();
            int res=JOptionPane.showConfirmDialog(null, panel, "Create Atomic Action", JOptionPane.OK_CANCEL_OPTION);
            if(res == JOptionPane.OK_OPTION)
            {
                    try {
                        System.out.println("Submit is press Name"+name.getText()+"  "+description.getText());
                        if(selectedNodeType.equals("PRO"))
                            attackDBService.insertAttack(name.getText(), description.getText());
                        else
                            counterDBService.insertCountermeasure(name.getText(), description.getText());

                    } catch (Exception ex) {
                        Logger.getLogger(ADTCanvasHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }else
                System.out.println("Cancel press");

          ((ADTreeCanvas<?>) canvas).addCounter(menuNode);
        }
      }

        
    });
    pmenu.add(addCounter);

    addLeft = new JMenuItem(Options.getMsg("handler.addleftsibling.txt"));
    addLeft.setAccelerator(KeyStroke.getKeyStroke(Options.getMsg("handler.addleftsibling.key")));
    addLeft.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent evt) {
        if (menuNode != null) {
          ((ADTreeCanvas<?>) canvas).addSibling(menuNode, true);
        }
      }
    });
    pmenu.add(addLeft);

    addRight = new JMenuItem(Options.getMsg("handler.addrightsibling.txt"));
    addRight.setAccelerator(KeyStroke.getKeyStroke(Options.getMsg("handler.addrightsibling.key")));
    addRight.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent evt) {
        if (menuNode != null) {
          ((ADTreeCanvas<?>) canvas).addSibling(menuNode, false);
        }
      }
    });
    pmenu.add(addRight);
    pmenu.addSeparator();

    switchLeft = new JMenuItem(Options.getMsg("handler.switchleft.txt"));
    switchLeft.setAccelerator(KeyStroke.getKeyStroke(Options.getMsg("handler.switchleft.key")));
    switchLeft.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent evt) {
        if (menuNode != null) {
          ((ADTreeCanvas<?>) canvas).switchSibling(menuNode, true);
        }
      }
    });
    pmenu.add(switchLeft);

    switchRight = new JMenuItem(Options.getMsg("handler.switchright.txt"));
    switchRight.setAccelerator(KeyStroke.getKeyStroke(Options.getMsg("handler.switchright.key")));
    switchRight.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent evt) {
        if (menuNode != null) {
          ((ADTreeCanvas<?>) canvas).switchSibling(menuNode, false);
        }
      }
    });
    pmenu.add(switchRight);

    removeTree = new JMenuItem(Options.getMsg("handler.removetree.txt"));
    removeTree.setAccelerator(KeyStroke.getKeyStroke(Options.getMsg("handler.removetree.key")));
    removeTree.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent evt) {
        if (menuNode != null) {
          ((ADTreeCanvas<?>) canvas).removeTree(menuNode);
        }
      }
    });
    pmenu.add(removeTree);
    removeChildren = new JMenuItem(Options.getMsg("handler.removechildren.txt"));
    removeChildren
        .setAccelerator(KeyStroke.getKeyStroke(Options.getMsg("handler.removechildren.key")));
    removeChildren.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent evt) {
        if (menuNode != null) {
          ((ADTreeCanvas<?>) canvas).removeChildren(menuNode);
        }
      }
    });
    pmenu.add(removeChildren);
    ///*
    if(isSelectedNodeAllowedToBeAtomic){
        pmenu.addSeparator(); 
        assignAction = new JMenuItem("Assign An Atomic Action");
        assignAction.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_MASK));
        assignAction.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
          //  if(selectedNodeType.equals("PRO"))
            //    new AssignnAnAtomicAttack().setVisible(true);
         //   else
          //      new AssignAnAtomicCountermeasure().setVisible(true);
        }
        });
        pmenu.add(assignAction);
     }
   //  pmenu.addSeparator();

  /*   menuItem = new JMenuItem("Probability");
     menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,
     InputEvent.CTRL_MASK));
     menuItem.addActionListener(new ActionListener() {
     public void actionPerformed(ActionEvent evt) {
     //collapseActionPerformed();
     }
     });
     pmenu.add(menuItem);
     pmenu.addSeparator();

     menuItem = new JMenuItem("Asset");
    menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
     InputEvent.CTRL_MASK));
     menuItem.addActionListener(new ActionListener() {
     public void actionPerformed(ActionEvent evt) {
     //propertiesActionPerformed(evt);
     }  
     });
     pmenu.add(menuItem); */
  }

  /**
   * Checks if a string is a valid label
   *
   * @param s
   * @return
   */
  private JPanel createDialogPanel() {
            
            JPanel p = new JPanel(new BorderLayout(5, 5));
            
            JPanel labels = new JPanel(new BorderLayout());
            labels.add(new JLabel("Name", SwingConstants.RIGHT),BorderLayout.NORTH);
            labels.add(new JLabel("Description", SwingConstants.RIGHT), BorderLayout.CENTER);
            p.add(labels, BorderLayout.WEST);

            JPanel controls = new JPanel(new BorderLayout());
             name = new JTextField();
            controls.add(name, BorderLayout.NORTH);
            JTextArea description = new JTextArea();
            JScrollPane sp = new JScrollPane(description);
            sp.setPreferredSize(new Dimension(250, 100));
            controls.add(sp, BorderLayout.CENTER);
            p.add(controls, BorderLayout.CENTER);
            return p;
        }
  private boolean validLabel(String s) {
    return ((ADTreeCanvas<?>) canvas).validLabel(s);
  }

  /**
   * Displays a dialog to change the label of the node
   *
   */
  private void changeLabelActionPerformed() {
	 // new Properties().setVisible(true);
  }

  private JMenuItem assignAnAtomicAction;
  private JMenuItem properties;
  private JMenuItem editNode;
  
  private JMenuItem assignAction;  
  private JMenuItem toggleAboveFold;
  private JMenuItem toggleFold;
  private JMenuItem addCounter;
  private JMenuItem addChild;
  private JMenuItem addLeft;
  private JMenuItem addRight;
  private JMenuItem removeTree;
  private JMenuItem removeChildren;
  private JMenuItem switchLeft;
  private JMenuItem switchRight;
  
   private JTextField name;
   private JTextArea description;
   
  private final AttackDBService attackDBService;
  private final  CountermeasureDBService counterDBService;
  
  private boolean hasChildren;  
  private String selectedNodeType;
  private String selectedNodeId;
  private String selectedNodeOperation;
  private boolean isSelectedNodeAllowedToBeAtomic;
  
  public static ADTNode selectedNode;
  
  // private Point2D dragStart;
  // private boolean dragScroll;

    private boolean hasChildren(String selectedNodeId, String selectedNodeType) throws Exception {
        String childId=null;
        boolean res=false;
        if(selectedNodeType.equals("PRO")){
            AttackTreeDBService attackTree=new AttackTreeDBService();
            childId=attackTree.selectIdFromField("attackTree", "parent_id", selectedNodeId);
            
        }else{
            CountermeaureTreeDBService counterTree=new CountermeaureTreeDBService();
            childId=counterTree.selectIdFromField("attackTree", "parent_id", selectedNodeId);
        }
        System.out.println("The selected Node hasChildren?"+res);
        res=(childId==null);
        return res;
    }

}
