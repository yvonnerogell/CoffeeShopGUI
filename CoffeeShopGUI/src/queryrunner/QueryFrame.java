/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queryrunner;

/**
 *
 * @author mckeem
 */
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import javax.swing.*;

public class QueryFrame extends javax.swing.JFrame {

/**
 * This is the constructer for QueryFrame. It will initialize the Combobox with
 * the various queries that are part of the QueryData that has been passed to it.
 * It will also set the default state of the Command Buttons and combo boxes.
 * @param queryrunnerObj 
 */
    public QueryFrame(QueryRunner queryrunnerObj) {
        initComponents();
        m_parmlabels = new JLabel[]{jLabel1, jLabel2, jLabel3, jLabel4, jLabel9, jLabel10, jLabel11, jLabel12};        
        m_textvals = new JTextField[] { jTextField5, jTextField6,jTextField7,jTextField8,jTextField9,jTextField10,jTextField11,jTextField12};
        m_queryrunner = queryrunnerObj;
        // Find out how many queries there are and set up combox box
        // If it is a grid query, then enable jtable
        int nAmt = m_queryrunner.GetTotalQueries();

        for (int i=0; i < nAmt; i++)
        {
            this.jComboBox1.addItem("Query " + (i+1));
        }
        jComboBox1.setEnabled(false);
        jButton2.setEnabled(false);
        
        jLabel14.setText(m_queryrunner.GetProjectTeamApplication());
     }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setNextFocusableComponent(jButton1);
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 120, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 350, 140));

        jTextArea2.setColumns(20);
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 40, 330, 140));

        jTextField2.setNextFocusableComponent(jTextField3);
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 120, -1));

        jTextField3.setNextFocusableComponent(jPasswordField1);
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 120, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 26, 149, -1));
        jPanel1.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 26, 190, -1));
        jPanel1.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(771, 26, 160, -1));
        jPanel1.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 64, 150, -1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("avx");
        jLabel1.setToolTipText("");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 29, 132, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("aaa");
        jLabel2.setToolTipText("");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 29, 120, -1));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("aaa");
        jLabel3.setToolTipText("");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(652, 29, 115, -1));

        jLabel4.setBackground(new java.awt.Color(204, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("aaa");
        jLabel4.setToolTipText("");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 65, 132, 18));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("yyy");
        jLabel9.setToolTipText("");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 67, 110, -1));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("rrr");
        jLabel10.setToolTipText("");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(651, 67, 116, -1));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("iii");
        jLabel11.setToolTipText("");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 102, 123, -1));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("ooo");
        jLabel12.setToolTipText("");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 102, 100, -1));
        jPanel1.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(459, 64, 188, -1));
        jPanel1.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(771, 64, 160, -1));
        jPanel1.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 99, 150, -1));
        jPanel1.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 99, 190, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 980, 130));

        jPanel2.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 980, 240));

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 120, -1));

        jLabel5.setText("Database");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 90, 10));

        jLabel6.setText("Hostname");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 90, -1));

        jLabel7.setText("User");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 100, -1));

        jLabel8.setText("Password");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 80, -1));

        jButton1.setText("Connect");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, -1, -1));

        jButton2.setText("Run Query");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, -1, -1));

        jPasswordField1.setText("jPasswordField1");
        jPasswordField1.setNextFocusableComponent(jTextField1);
        getContentPane().add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 120, -1));

        jLabel13.setText("Output");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 190, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Voter Application");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 280, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    
   /**
    * This button will use the data from the textboxes, and attempt to connect to the MYSQL Server. If it is not connected, it will
    * call the CONNECT function, otherwise it will call the DISCONNECT Function.
    * @param evt 
    */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        boolean  bOK=true; 
        jTextArea2.setText("");      
        
        if (jButton1.getText() == "Connect")
        {            
            bOK = m_queryrunner.Connect(this.jTextField2.getText(), this.jTextField3.getText(), String.valueOf(this.jPasswordField1.getPassword()), this.jTextField1.getText());
           if (bOK == true)
           {
               jButton1.setText("Disconnect");    
               jComboBox1.setEnabled(true);
               jButton2.setEnabled(true);  
           }
        }
        else
        {
           bOK = m_queryrunner.Disconnect();
           if (bOK == true)
           {
               jButton1.setText("Connect");
               jComboBox1.setEnabled(true);
               jButton2.setEnabled(true); 
           }
        }
        
        if (bOK == false)
        {
            this.jTextArea2.setText(m_queryrunner.GetError());
        }       
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * This event handler recognizes when something has changed regarding the 
     * drop down box. It will recognize which one is selected and get the correct
     * Query Data that it will then use to populate the TextArea that display's the
     * query. It will also recognize if it is a "parameter" query. If it is, it will
     * make the PANEL Control which holds the parameter data to be visible, and will
     * put the appropriate parameter labels along with their textboxes.
     * 
     * @param evt 
     */
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        
        jTextArea2.setText("");
        String szChoice = (String)jComboBox1.getSelectedItem();        
        String szStripChoice = szChoice.substring(6);
        m_queryChoice = Integer.parseInt(szStripChoice)-1;        
        String szQuery = m_queryrunner.GetQueryText(m_queryChoice);
        String queryDesc = m_queryrunner.getQueryDesc(m_queryChoice);
        this.jTextArea1.setText(queryDesc);
        System.out.println("choice is " + szChoice);
        this.jPanel2.setVisible(false);        
         
        if (this.m_queryrunner.isParameterQuery(m_queryChoice))
        {           
            this.jPanel1.setVisible(true);                        
            int nAmt = this.m_queryrunner.GetParameterAmtForQuery(m_queryChoice);
            for (int i=0; i< nAmt; i++)
            {
                m_parmlabels[i].setVisible(true);
                m_parmlabels[i].setText(m_queryrunner.GetParamText(m_queryChoice, i));
                m_textvals[i].setVisible(true);
                m_textvals[i].setText("");
            }
            
            for (int i = nAmt; i < 8; i++)
            {
                m_parmlabels[i].setVisible(false);  
                m_textvals[i].setVisible(false);
            }            
        }
        else
        {
            this.jPanel1.setVisible(false);
        }
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    
/**
 * This is the Action handler for the "RUN QUERY" button. It tries to identify
 * If it is an action query first. If it is, it will take the parameter data from
 * the various textboxes and create a parameter array that it will eventually pass
 * to the ExecuteQuery function.
 * 
 * If it is a query that returns a resultset, it will create a JTABLE which is a
 * GUI Control that enables the resultset data to transferred to it.
 * @param evt Java Event Handler
 */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        jTextArea2.setText("");        
        if (this.m_queryrunner.isActionQuery(m_queryChoice) == false)
            jPanel2.setVisible(true);
        
        int nAmt = this.m_queryrunner.GetParameterAmtForQuery(m_queryChoice);
        String [] parmstring={};
        String [] headers;
        String [][] allData;        

        boolean  bOK = true;
        
        if (this.m_queryrunner.isParameterQuery(m_queryChoice))
        {
            parmstring = new String [nAmt];
            for (int i=0; i< nAmt; i++)
            {
                parmstring[i] = this.m_textvals[i].getText();
            }                    
        }
        
        if (this.m_queryrunner.isActionQuery(m_queryChoice))    
        {
            bOK = m_queryrunner.ExecuteUpdate(m_queryChoice, parmstring);
            if (bOK == true)
            {
                this.jTextArea2.setText(("Rows affected = " + m_queryrunner.GetUpdateAmount()));
            }
            else
            {
                this.jTextArea2.setText(m_queryrunner.GetError());
            }
        }
        else
        {
            bOK = m_queryrunner.ExecuteQuery(m_queryChoice, parmstring);
            if (bOK ==true)
            {
                headers = m_queryrunner.GetQueryHeaders();
                allData = m_queryrunner.GetQueryData();
                if (m_scrollPane != null)
                {
                    m_scrollPane.remove(m_jTable);  
                    jPanel2.remove(m_scrollPane);
                }
                m_jTable = new JTable(allData, headers);
                
                m_jTable.setBounds(100, 100, 100, 80);
                Color ivory=new Color(255,255,208);
                m_jTable.setOpaque(false);
                m_jTable.setBackground(ivory);           
                m_scrollPane = new JScrollPane(m_jTable);
                jPanel2.add(m_scrollPane);// add table in panel using add() method                      
                this.setVisible(true);                
            }
            else
            {
                this.jTextArea2.setText(m_queryrunner.GetError());                
            }
        }                
    }//GEN-LAST:event_jButton2ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables


    private final JLabel[] m_parmlabels;
    private JTextField [] m_textvals;
    private QueryRunner m_queryrunner;
    private javax.swing.JTable m_jTable;
    JScrollPane m_scrollPane;
    private int m_queryChoice = 0 ; // This is the default query that was selected 

}
