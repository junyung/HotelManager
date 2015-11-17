/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanager;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Lenovo
 */
public class HotelManagerDBFrame extends javax.swing.JFrame {
    Connection conn=null;
    String gs=null;
    /**
     * Creates new form HotelManagerDBFrame
     */
    public HotelManagerDBFrame() {
        initComponents();
        conn=DBconnection.makeConn();
       addNodestoTree();
      // String ss="Faculty";
     //  showData(ss);
    }
    private String mySeletedNode(){
       DefaultMutableTreeNode node=(DefaultMutableTreeNode) jTree1.getLastSelectedPathComponent();
       String sn=node.getUserObject().toString();
       return sn;       
    }
    
    private void showData(String tn){       
        String sql1="select * from "+tn+"";
        try{
        PreparedStatement pstmt=conn.prepareStatement(sql1);
        ResultSet rs=pstmt.executeQuery();
        jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        jTable1.setRowSelectionInterval(0, 0);        
        }
        
        catch(Exception e){}
        
        
    }
    
       private void showData2(String tn){       
           PreparedStatement pstmt=null;
           ResultSet rs=null;
           String sql=null;
          
           
       
        try{
         sql="select * from "+tn+"";
         pstmt=conn.prepareStatement(sql);
         rs=pstmt.executeQuery();
 
        jTable1.setModel(rstoTable(rs));
        jTable1.setRowSelectionInterval(0, 0);        
        }
        
        catch(Exception e){
        System.err.printf(e.getMessage());
        
        }
        
       finally{
        try{
            pstmt.close();
            rs.close();}
         catch(Exception e){
        System.err.printf(e.getMessage());}
        }
        
    } 
    
    private TableModel rstoTable(ResultSet rs){
     try{
     ResultSetMetaData md=rs.getMetaData();
     int noc=md.getColumnCount();
     Vector cNames=new Vector();
     //get column name
     for(int c=0; c<noc; c++){
     cNames.addElement(md.getColumnLabel(c+1));
     }        
     //Get rows of data from rs
     
     Vector rows=new Vector();
     while(rs.next()){
     Vector newrow=new Vector();
      for(int c=1; c<noc; c++){     //noc= number of columns
      newrow.addElement(rs.getObject(c));
     }   
      
     rows.addElement(newrow);
      
     }

     return new DefaultTableModel(rows,cNames);
     
     } 
     catch(Exception e){
     return null;
     }
    
    }
     
    
    private void showFaculty(){
     int selectedrow =jTable1.getSelectedRow();
     jTextField1.setText(jTable1.getValueAt(selectedrow, 0).toString());
     jTextField2.setText(jTable1.getValueAt(selectedrow, 1).toString());
     jTextField3.setText(jTable1.getValueAt(selectedrow, 2).toString());
     jTextField4.setText(jTable1.getValueAt(selectedrow, 3).toString());
     jTextField5.setText(jTable1.getValueAt(selectedrow, 4).toString());
     jTextField6.setText(jTable1.getValueAt(selectedrow, 5).toString());
     jTextField7.setText(jTable1.getValueAt(selectedrow, 6).toString());
         
     jTextField8.setVisible(false);
     jTextField9.setVisible(false);
     jTextField10.setVisible(false);
     
     jLabel1.setText(jTable1.getModel().getColumnName(0));
     jLabel2.setText(jTable1.getModel().getColumnName(1));
     jLabel3.setText(jTable1.getModel().getColumnName(2));
     jLabel4.setText(jTable1.getModel().getColumnName(3));
     jLabel5.setText(jTable1.getModel().getColumnName(4));
     jLabel6.setText(jTable1.getModel().getColumnName(6));
     jLabel7.setText(jTable1.getModel().getColumnName(7));
     
     jLabel8.setVisible(false);
     jLabel9.setVisible(false);
     jLabel10.setVisible(false);
     }
       
     private void addNodestoTree(){
    DefaultTreeModel treeModel= (DefaultTreeModel) jTree1.getModel();  
    DefaultMutableTreeNode root=new DefaultMutableTreeNode("Files");
    DefaultMutableTreeNode tables=new DefaultMutableTreeNode("Tables");
    DefaultMutableTreeNode utilities=new DefaultMutableTreeNode("Utilities");
    DefaultMutableTreeNode reports=new DefaultMutableTreeNode("Reports");
    treeModel.setRoot(root);
    root.add(tables);
    root.add(utilities);
    root.add(reports);
    
    DefaultMutableTreeNode t1=new DefaultMutableTreeNode("Faculty");
    DefaultMutableTreeNode t2=new DefaultMutableTreeNode("Course");
    DefaultMutableTreeNode t3=new DefaultMutableTreeNode("Student");
    tables.add(t1);
    tables.add(t2);
    tables.add(t3);
    
    DefaultMutableTreeNode u1=new DefaultMutableTreeNode("Utility1");
    DefaultMutableTreeNode u2=new DefaultMutableTreeNode("Utility1");
    DefaultMutableTreeNode u3=new DefaultMutableTreeNode("Utility1");
    utilities.add(u1);
    utilities.add(u2);
    utilities.add(u3);
    
    
    
    DefaultMutableTreeNode r1=new DefaultMutableTreeNode("Utility1");
    DefaultMutableTreeNode r2=new DefaultMutableTreeNode("Utility1");
    DefaultMutableTreeNode r3=new DefaultMutableTreeNode("Utility1");
    reports.add(r1);
    reports.add(r2);
    reports.add(r3);
    
    treeModel.reload();
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        slabel1 = new javax.swing.JLabel();
        stext1 = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTree1.addTreeExpansionListener(new javax.swing.event.TreeExpansionListener() {
            public void treeCollapsed(javax.swing.event.TreeExpansionEvent evt) {
            }
            public void treeExpanded(javax.swing.event.TreeExpansionEvent evt) {
                jTree1TreeExpanded(evt);
            }
        });
        jTree1.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTree1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTree1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jButton5.setText("Update");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        jButton4.setText("Delete");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jButton6.setText("Print");

        slabel1.setText("Faculty ID");

        stext1.setText("jTextField11");
        stext1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stext1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(btnSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNew)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton6))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 744, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(slabel1)
                        .addGap(18, 18, 18)
                        .addComponent(stext1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 203, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSearch)
                            .addComponent(btnNew)
                            .addComponent(btnAdd)
                            .addComponent(jButton4)
                            .addComponent(jButton5)
                            .addComponent(jButton6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(slabel1)
                            .addComponent(stext1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        jTextField1.setText("jTextField1");

        jTextField2.setText("jTextField2");

        jTextField3.setText("jTextField3");

        jTextField4.setText("jTextField4");

        jTextField5.setText("jTextField5");

        jTextField6.setText("jTextField6");
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jTextField7.setText("jTextField7");

        jTextField8.setText("jTextField8");

        jTextField9.setText("jTextField9");

        jTextField10.setText("jTextField10");

        jLabel3.setText("jLabel3");

        jLabel4.setText("jLabel4");

        jLabel5.setText("jLabel5");

        jLabel6.setText("jLabel6");

        jLabel7.setText("jLabel7");

        jLabel8.setText("jLabel8");

        jLabel9.setText("jLabel9");

        jLabel10.setText("jLabel10");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(36, 36, 36)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField10, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                    .addComponent(jTextField9)
                    .addComponent(jTextField8)
                    .addComponent(jTextField6)
                    .addComponent(jTextField5)
                    .addComponent(jTextField4)
                    .addComponent(jTextField3)
                    .addComponent(jTextField1)
                    .addComponent(jTextField2)
                    .addComponent(jTextField7))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
            if(gs=="Faculty")
                  searchFaculty();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTree1ValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTree1ValueChanged
        gs=mySeletedNode();
        showData2(gs);        
        if(gs=="Faculty")
            showFaculty();
    }//GEN-LAST:event_jTree1ValueChanged

    private void jTree1TreeExpanded(javax.swing.event.TreeExpansionEvent evt) {//GEN-FIRST:event_jTree1TreeExpanded
        // TODO add your handling code here:
    }//GEN-LAST:event_jTree1TreeExpanded

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        showFaculty();
    }//GEN-LAST:event_jTable1MouseClicked

    private void stext1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stext1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stext1ActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if(gs=="Faculty")
            addFaculty3();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        if(gs=="Faculty")
            clearFaculty();
    }//GEN-LAST:event_btnNewActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if(gs=="Faculty")
            deleteFaculty2();
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
        public static void main(String args[]) {
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
             * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
             */
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(HotelManagerDBFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(HotelManagerDBFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(HotelManagerDBFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(HotelManagerDBFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new HotelManagerDBFrame.setVisible();
                }
            });
        }
        /*
        private void serchFaculty(){
           PreparedStatement pstmt=null;
           ResultSet rs=null;
           String sql=null;
          slabel1.setText("Faculty ID");
           
       
        try{
            if(stext1.getText().equals("")){
                 sql="select * from "+gs+"";
                 pstmt=conn.prepareStatement(sql);
            }
            else
            {
                    sql="select * from "+gs+"where faculty_id=?";
                    pstmt=conn.prepareStatement(sql);
                    pstmt.setString(1,stext1.getText());
                }            
            rs=pstmt.executeQuery();
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            
        jTable1.setModel(rstoTable(rs));
        jTable1.setRowSelectionInterval(0, 0);    
   
        }
        
        catch(Exception e){
        System.err.printf(e.getMessage());
        
        }
        
       finally{
        try{
            pstmt.close();
            rs.close();}
         catch(Exception e){
        System.err.printf(e.getMessage());}
        }
        }
       */ 
    private void searchFaculty()
    {
          PreparedStatement pstmt=null;
      ResultSet rs =null;
      String sql =null;
      slabel1.setText("Faculty ID");
       
       try{
           if(stext1.getText()==""){
               sql="select * from "+gs+"";}
           else 
           {
               sql="select * from "+gs+" where faculty_id=?";
               pstmt=conn.prepareStatement(sql);
               pstmt.setString(1, stext1.getText());
           }
            
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
          
          //jTable1.setModel(DbUtils.resultSetToTableModel(rs)); //import net.proteanit.sql.DbUtils; 임포트 해줘야함
           jTable1.setModel(rstoTable(rs)); //import net.proteanit.sql.DbUtils; 임포트 해줘야함
           jTable1.setRowSelectionInterval(0, 0);
           showFaculty();
           
       }
    
       
   catch(Exception e){
       System.err.printf(e.getMessage());
       }
       finally
       {
           try
           {
           pstmt.close();
           rs.close();
           }
            catch(Exception e)
             {
                System.err.printf(e.getMessage());
             }
       }
    }
        
private void clearFaculty(){
    jTextField1.setText("");
    jTextField2.setText("");
    jTextField3.setText("");
    jTextField4.setText("");
    jTextField5.setText("");
    jTextField6.setText("");
    jTextField7.setText("");
    
}
private void addFaculty1(){
    PreparedStatement pstmt=null;
           String sql=null;
           int num=0;
           
       
        try{           
          sql="insert into Faculty(faculty_id, faculty_name, office, phone, college, title, email) values(?,?,?,?,?,?,?)";
          pstmt=conn.prepareStatement(sql);
          pstmt.setString(1,jTextField1.getText());
          pstmt.setString(2,jTextField2.getText());
          pstmt.setString(3,jTextField3.getText());
          pstmt.setString(4,jTextField4.getText());
          pstmt.setString(5,jTextField5.getText());
          pstmt.setString(6,jTextField6.getText());
          pstmt.setString(7,jTextField7.getText());
                  
        num=pstmt.executeUpdate();
        JOptionPane.showMessageDialog(null,"Record Added");
        showData(gs);
        showFaculty();
        }
        
        catch(Exception e){
        System.err.printf(e.getMessage());
        
        }
        
       finally{
        try{
            pstmt.close();
        }
         catch(Exception e){
        System.err.printf(e.getMessage());}
        }
}
      
private void addFaculty2(){
    CallableStatement cst=null;
      String sql=null;
      int num=0;
           
       
        try{           
          sql="{call addFaculty(?,?,?,?,?,?,?)}";
          cst=conn.prepareCall(sql);
          cst.setString(1,jTextField1.getText());
          cst.setString(2,jTextField2.getText());
          cst.setString(3,jTextField3.getText());
          cst.setString(4,jTextField4.getText());
          cst.setString(5,jTextField5.getText());
          cst.setString(6,jTextField6.getText());
          cst.setString(7,jTextField7.getText());
          
          cst.execute();
       
        JOptionPane.showMessageDialog(null,"Record Added");
        showData(gs);
        showFaculty();
        }
        
        catch(Exception e){
        JOptionPane.showMessageDialog(null,"Record Added");
        System.err.printf(e.getMessage());
        
        }
        
       finally{
        try{
            cst.close();
        }
         catch(Exception e){
        System.err.printf(e.getMessage());}
        }
}
private void addFaculty3(){
    PreparedStatement pstmt=null;
    String sql=null;
    ResultSet rs = null;
           
       
    try{
        sql="select * from "+ gs + "";
          
        pstmt=conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        rs = pstmt.executeQuery();
        rs.moveToInsertRow();
        rs.updateString(1,jTextField1.getText());
        rs.updateString(2,jTextField2.getText());
        rs.updateString(3,jTextField3.getText());
        rs.updateString(4,jTextField4.getText());
        rs.updateString(5,jTextField5.getText());
        rs.updateString(6,jTextField6.getText());
        rs.updateString(7,jTextField7.getText());
        rs.insertRow();
        JOptionPane.showMessageDialog(null,"Record Added");
        showData(gs);
        showFaculty();
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null,"Record not Added");
    }
    finally{
        try{
            pstmt.close();
        }
        catch(Exception e){
            System.err.printf(e.getMessage());
        }
    }
}

///////////////////////delete 함수////////////
private void deleteFaculty1(){
    PreparedStatement pstmt=null;
           String sql=null;
           int num=0;
           
       
        try{    
           int rownum=jTable1.getSelectedRow();
          String id = jTable1.getModel().getValueAt(rownum, 0).toString();
          
          sql="delete frome Faculty where faculty_Id=?";
          
          pstmt=conn.prepareStatement(sql);
          pstmt.setString(1, id);
          
          num=pstmt.executeUpdate();
          JOptionPane.showMessageDialog(null, "Record is deleted");
          pstmt.setString(1,jTextField1.getText());
          pstmt.setString(2,jTextField2.getText());
          pstmt.setString(3,jTextField3.getText());
          pstmt.setString(4,jTextField4.getText());
          pstmt.setString(5,jTextField5.getText());
          pstmt.setString(6,jTextField6.getText());
          pstmt.setString(7,jTextField7.getText());
                  
        
        showData(gs);
        showFaculty();
        }
        
        catch(Exception e){
        System.err.printf(e.getMessage());
        
        }
        
       finally{
        try{
            pstmt.close();
        }
         catch(Exception e){
        System.err.printf(e.getMessage());}
        }
}
////delete method using stored procedure//
private void deleteFaculty2(){
    CallableStatement cst=null;
      String sql=null;
      int num=0;
           
       
        try{           
            int rownum=jTable1.getSelectedRow();
             String id = jTable1.getModel().getValueAt(rownum, 0).toString();
          
          sql="{call spDeleteFaculty(?)}";
          cst=conn.prepareCall(sql);
          cst.setString(1, id);
          
          cst.execute();

          cst.setString(1,jTextField1.getText());
          cst.setString(2,jTextField2.getText());
          cst.setString(3,jTextField3.getText());
          cst.setString(4,jTextField4.getText());
          cst.setString(5,jTextField5.getText());
          cst.setString(6,jTextField6.getText());
          cst.setString(7,jTextField7.getText());
          
         
       
        JOptionPane.showMessageDialog(null,"Record deleted");
        showData(gs);
        showFaculty();
        }
        
        catch(Exception e){
        JOptionPane.showMessageDialog(null,"Record Added");
        System.err.printf(e.getMessage());
        
        }
        
       finally{
        try{
            cst.close();
        }
         catch(Exception e){
        System.err.printf(e.getMessage());}
        }
}
      

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTree jTree1;
    private javax.swing.JLabel slabel1;
    private javax.swing.JTextField stext1;
    // End of variables declaration//GEN-END:variables
}