import javax.swing.*;
import javax.swing.plaf.synth.SynthOptionPaneUI;

import javafx.embed.swing.JFXPanel;
import oracle.jrockit.jfr.openmbean.JFRStatsType;

import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import java.sql.Date.*;

public class dataman{

    public static JComboBox combo;

    public static JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9;

    public static JTextField field1,field2,field3,field4,field5,field6,field7,field8;

    public static JLabel lable11,lable12,lable13,lable14,lable15,lable16;

    public static JTextField field11,field12,field13,field14,field15,field16,field17,field18,field19,field20,field21,field22,field23,field24,field25,field26,comboField;

    public static Container cr;

    public static void showForm(){

        methods mth = new methods();

        // ----------------------------- JLabel----------------------------------

        label1 = mth.getLabel("Name", 300, 150, 150, 40);
        label2 = mth.getLabel("Date Of Birth", 300, 220, 200, 40);
        label3 = mth.getLabel("Age", 1000, 220, 150, 40);
        label4 = mth.getLabel("Date Of Joining", 300, 290, 250, 40);
        label5 = mth.getLabel("Mobile", 1000, 290, 150, 40);
        label6 = mth.getLabel("Address", 300, 360, 150, 40);
        label7 = mth.getLabel("City", 300, 430, 150, 40);
        label8 = mth.getLabel("State", 300, 500, 150, 40);
        label9 = mth.getLabel("Country", 1000, 500, 150, 40);

        lable11 = mth.getLabel("Class", 300, 580, 200, 40);
        lable12 = mth.getLabel("Collage", 500, 580, 200, 40);
        lable13 = mth.getLabel("Obtaining", 700, 580, 200, 40);
        lable14 = mth.getLabel("Obtained", 900, 580, 200, 40);
        lable15 = mth.getLabel("Percentage", 1100, 580, 200, 40);
        lable16 = mth.getLabel("OverAll %", 900, 780, 200, 40);

        // ----------------------------- JTextField------------------------------

        field1 = mth.getTextField(530, 150, 250, 50);
        field2 = mth.getTextField(530, 220, 250, 50);
        field3 = mth.getTextField(1230, 220, 250, 50);  
            field3.setEditable(false);
        field4 = mth.getTextField(530, 290, 250, 50);
        field5 = mth.getTextField(1230, 290, 250, 50);
        field6 = mth.getTextField(530, 360, 600, 50);
        field7 = mth.getTextField(530, 500, 250, 50);
            field7.setEditable(false);
        field8 = mth.getTextField(1230, 500, 250, 50);
            field8.setEditable(false);

            
        field11 = mth.getTextField(300, 630, 200, 50);
        field12 = mth.getTextField(500, 630, 200, 50);
        field13 = mth.getTextField(700, 630, 200, 50);
        field14 = mth.getTextField(900, 630, 200, 50);
        field15 = mth.getTextField(1100, 630, 200, 50);
            field15.setEditable(false);

        field16 = mth.getTextField(300, 680, 200, 50);
        field17= mth.getTextField(500, 680, 200, 50);
        field18 = mth.getTextField(700, 680, 200, 50);
        field19 = mth.getTextField(900, 680, 200, 50);
        field20 = mth.getTextField(1100, 680, 200, 50);
            field20.setEditable(false);

        field21 = mth.getTextField(300, 730, 200, 50);
        field22 = mth.getTextField(500, 730, 200, 50);
        field23 = mth.getTextField(700, 730, 200, 50);
        field24 = mth.getTextField(900, 730, 200, 50);
        field25 = mth.getTextField(1100, 730, 200, 50);
            field25.setEditable(false);
        field26 = mth.getTextField(1100, 780, 200, 50);
            field26.setEditable(false);


         // ----------------------------- JComboBox-------------------------------

         combo = new JComboBox(new String[] {"Kanpur","Agra","Surat","Jhansi"});
         combo.setBounds(530,430,250,50);
         combo.setFont(new Font("Arial",Font.BOLD,30));
         cr.add(combo);

         comboField = mth.getTextField(530,430,250,50);
         cr.add(comboField);
         comboField.setVisible(false);
        
        // ----------------------------- Listener-------------------------------

        field2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(mth.isRightAge(field2.getText()) == true){
                    field3.setText(String.valueOf(mth.getAge(field2.getText())));
                }else{
                    JOptionPane.showMessageDialog(new JFrame(), "Please correct the DOB format");
                }
            }
        });

        field4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(mth.isRightAge(field4.getText()) == false){
                    JOptionPane.showMessageDialog(new JFrame(), "Please correct the DOB format");
                }
                if(mth.checkAge(field2.getText(), field4.getText()) == false){
                    JOptionPane.showMessageDialog(new JFrame(), "Invalid DOJ Date");
                }
            }
        });

        field14.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(mth.isEmpty(field13)==false || mth.isEmpty(field14)==false){
                    field15.setText(String.valueOf(mth.getPercentage(field13.getText(), field14.getText())));
                }else{
                    JOptionPane.showMessageDialog(new JFrame(), "Please Fill the obtaining or obtainied fields");
                }
            }
        });

        field19.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(mth.isEmpty(field18)==false || mth.isEmpty(field19)==false){
                    field20.setText(String.valueOf(mth.getPercentage(field18.getText(), field19.getText())));
                }else{
                    JOptionPane.showMessageDialog(new JFrame(), "Please Fill the obtaining or obtainied fields");
                }
                
            }
        });

        field24.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(mth.isEmpty(field23)==false || mth.isEmpty(field24)==false){
                    field25.setText(String.valueOf(mth.getPercentage(field23.getText(), field24.getText())));
                    field26.setText(String.valueOf(mth.getPercentageAll(field15.getText(),field20.getText(),field25.getText())));
                }else{
                    JOptionPane.showMessageDialog(new JFrame(), "Please Fill the obtaining or obtainied fields");
                }
                
            }
        });

        combo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                try{

                    String city = "'"+combo.getSelectedItem().toString()+"'";

                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    Connection con = DriverManager.getConnection("jdbc:sqlserver://GANGESH_KUMAR\\SQLEXPRESS;databaseName=testing;integratedSecurity=true;encrypt=false");

                    String query = " SELECT city.CityName, State.StateName, Country.CountryName FROM city "+
                            " INNER JOIN State ON city.StateCode = State.CODE "+
                            " INNER JOIN Country ON city.CountryCode = Country.CODE "+
                            " WHERE city.CityName =  "+city;

                    Statement stmt = con.createStatement();
                    ResultSet rset = stmt.executeQuery(query);

                    while(rset.next()){
                        field7.setText(rset.getString("StateName"));
                        field8.setText(rset.getString("CountryName"));
                    }

                    con.close();

                }catch(Exception ex){
                    System.out.print("\n"+ex.getMessage());
                }


            }
        });

        

        // ----------------------------- JLabel----------------------------------
        cr.add(label1);
        cr.add(label2);
        cr.add(label3);
        cr.add(label4);
        cr.add(label5);
        cr.add(label6);
        cr.add(label7);
        cr.add(label8);
        cr.add(label9);

        cr.add(lable11);
        cr.add(lable12);
        cr.add(lable13);
        cr.add(lable14);
        cr.add(lable15);
        cr.add(lable16);

        // ----------------------------- JTextField------------------------------
        cr.add(field1);
        cr.add(field2);
        cr.add(field3);
        cr.add(field4);
        cr.add(field5);
        cr.add(field6);
        cr.add(field7);
        cr.add(field8);


        cr.add(field11);
        cr.add(field12);
        cr.add(field13);
        cr.add(field14);
        cr.add(field15);

        cr.add(field16);
        cr.add(field17);
        cr.add(field18);
        cr.add(field19);
        cr.add(field20);

        cr.add(field21);
        cr.add(field22);
        cr.add(field23);
        cr.add(field24);
        cr.add(field25);
        cr.add(field26);

    }

    public static void viewForm(){

        field1.setEditable(false);
        field2.setEditable(false);
        field3.setEditable(false);
        field4.setEditable(false);
        field5.setEditable(false);
        field6.setEditable(false);
        field7.setEditable(false);
        field8.setEditable(false);


        field11.setEditable(false);
        field12.setEditable(false);
        field13.setEditable(false);
        field14.setEditable(false);
        field15.setEditable(false);

        field16.setEditable(false);
        field17.setEditable(false);
        field18.setEditable(false);
        field19.setEditable(false);
        field20.setEditable(false);

        comboField.setVisible(true);
        comboField.setEditable(false);

        field21.setEditable(false);
        field22.setEditable(false);
        field23.setEditable(false);
        field24.setEditable(false);
        field25.setEditable(false);
        field26.setEditable(false);
    }

    public static void clearForm(){
        label1.setVisible(false);
        label2.setVisible(false);
        label3.setVisible(false);
        label4.setVisible(false);
        label5.setVisible(false);
        label6.setVisible(false);
        label7.setVisible(false);
        label8.setVisible(false);
        label9.setVisible(false);

        lable11.setVisible(false);
        lable12.setVisible(false);
        lable13.setVisible(false);
        lable14.setVisible(false);
        lable15.setVisible(false);
        lable16.setVisible(false);


        field1.setVisible(false);
        field2.setVisible(false);
        field3.setVisible(false);
        field4.setVisible(false);
        field5.setVisible(false);
        field6.setVisible(false);
        field7.setVisible(false);
        field8.setVisible(false);


        field11.setVisible(false);
        field12.setVisible(false);
        field13.setVisible(false);
        field14.setVisible(false);
        field15.setVisible(false);

        field16.setVisible(false);
        field17.setVisible(false);
        field18.setVisible(false);
        field19.setVisible(false);
        field20.setVisible(false);

        field21.setVisible(false);
        field22.setVisible(false);
        field23.setVisible(false);
        field24.setVisible(false);
        field25.setVisible(false);
        field26.setVisible(false);


    }

    public static void main(String[] args) {
        
        methods mth = new methods();

        JFrame frame = mth.getFrame();

        cr = frame.getContentPane();
        cr.setLayout(null);

        // ----------------------------- JButton----------------------------------
        JButton btn1 = mth.getButton("ADD", 50, 20, 250,50 );
        JButton btn2 = mth.getButton("EDIT", 400, 20, 250,50 );
        JButton btn3 = mth.getButton("DELETE", 750, 20, 250,50 );
        JButton btn4 = mth.getButton("FIND", 1100, 20, 250,50 );
        JButton btn5 = mth.getButton("SAVE", 1450, 20, 250,50 );

         // ----------------------------- JButton----------------------------------
         cr.add(btn1);
         cr.add(btn2);
         cr.add(btn3);
         cr.add(btn4);
         cr.add(btn5);

         showForm();

         btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                if(mth.isEmpty(field1)==false || mth.isEmpty(field2)==false || mth.isEmpty(field3)==false || mth.isEmpty(field4)==false || mth.isEmpty(field5)==false || mth.isEmpty(field6)==false || mth.isEmpty(field7)==false || mth.isEmpty(field8)==false 
                ||
                mth.isEmpty(field11)==false || mth.isEmpty(field12)==false || mth.isEmpty(field13)==false || mth.isEmpty(field14)==false || mth.isEmpty(field15)==false || mth.isEmpty(field16)==false || mth.isEmpty(field17)==false || mth.isEmpty(field18)==false || mth.isEmpty(field19)==false || mth.isEmpty(field20)==false || mth.isEmpty(field21)==false || mth.isEmpty(field21)==false || mth.isEmpty(field22)==false || mth.isEmpty(field23)==false || mth.isEmpty(field24)==false || mth.isEmpty(field25)==false || mth.isEmpty(field26)==false
                ){
                    try{

                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        Connection con = DriverManager.getConnection("jdbc:sqlserver://GANGESH_KUMAR\\SQLEXPRESS;databaseName=testing;integratedSecurity=true;encrypt=false");
    
                        String query = " INSERT INTO info (Name,DOB,Age,DOJ,Mobile,Address,City,State,Country,Class1,Collage1,Obtaining1,Obtained1,Percentage1,Class2,Collage2,Obtaining2,Obtained2,Percentage2,Class3,Collage3,Obtaining3,Obtained3,Percentage3,TotalPercente) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
    
                        PreparedStatement pstate = con.prepareStatement(query);
    
                        pstate.setString(1, field1.getText());
                        pstate.setDate(2, mth.getDBDate(field2.getText()));
                        pstate.setInt(3, Integer.parseInt(field3.getText()));
                        pstate.setDate(4, mth.getDBDate(field4.getText()));
                        pstate.setString(5, field5.getText());
                        pstate.setString(6, field6.getText());
                        pstate.setString(7, combo.getSelectedItem().toString());
                        pstate.setString(8, field7.getText());
                        pstate.setString(9, field8.getText());
    
                        pstate.setString(10, field11.getText());
                        pstate.setString(11, field12.getText());
                        pstate.setFloat(12, Float.parseFloat(field13.getText()));
                        pstate.setFloat(13, Float.parseFloat(field14.getText()));
                        pstate.setFloat(14, Float.parseFloat(field15.getText()));
    
                        pstate.setString(15, field16.getText());
                        pstate.setString(16, field17.getText());
                        pstate.setFloat(17, Float.parseFloat(field18.getText()));
                        pstate.setFloat(18, Float.parseFloat(field19.getText()));
                        pstate.setFloat(19, Float.parseFloat(field20.getText()));
    
                        pstate.setString(20, field21.getText());
                        pstate.setString(21, field22.getText());
                        pstate.setFloat(22, Float.parseFloat(field23.getText()));
                        pstate.setFloat(23, Float.parseFloat(field24.getText()));
                        pstate.setFloat(24, Float.parseFloat(field25.getText()));
    
                        pstate.setFloat(25, Float.parseFloat(field26.getText()));
    
                        pstate.executeUpdate();
    
                        JOptionPane.showMessageDialog(frame, "Data inserted");
    
                    }catch(Exception ex){
                        System.out.print("\n"+ex.getMessage());
                        JOptionPane.showMessageDialog(frame, "Database Error, please fill the form carefully");
                    }
                }else{
                    JOptionPane.showMessageDialog(frame,"Please Fill All the fields");
                }

            }
         });

         btn4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                String DOB = JOptionPane.showInputDialog(frame, "Enter The Date-Of-Birth");
                String name = JOptionPane.showInputDialog(frame, "Enter The User-Name");

                name = "'"+name+"'";

                try{

                    Connection con = mth.getDBConnection("info");
                    
                    String query = " SELECT * FROM info WHERE DOB = "+"'"+mth.getDBDate(DOB)+"'"+
                                    " AND Name = "+name;

                    Statement stmt = con.createStatement();
                    ResultSet rset = stmt.executeQuery(query);

                    viewForm();

                    while(rset.next()){
                        field1.setText(rset.getString("Name"));
                        field2.setText(String.valueOf(rset.getDate("DOB")));
                        field3.setText(String.valueOf(rset.getInt("Age")));
                        field4.setText(String.valueOf(rset.getDate("DOJ")));
                        field5.setText(String.valueOf(rset.getString("Mobile")));
                        field6.setText(String.valueOf(rset.getString("Address")));
                        comboField.setText(String.valueOf(rset.getString("City")));
                        comboField.setVisible(true);
                        combo.setVisible(false);
                        field7.setText(String.valueOf(rset.getString("State")));
                        field8.setText(String.valueOf(rset.getString("Country")));

                        field11.setText(String.valueOf(rset.getString("Class1")));
                        field12.setText(String.valueOf(rset.getString("Collage1")));
                        field13.setText(String.valueOf(rset.getString("Obtaining1")));
                        field14.setText(String.valueOf(rset.getString("Obtained1")));
                        field15.setText(String.valueOf(rset.getFloat("Percentage1")));

                        field16.setText(String.valueOf(rset.getString("Class2")));
                        field17.setText(String.valueOf(rset.getString("Collage2")));
                        field18.setText(String.valueOf(rset.getString("Obtaining2")));
                        field19.setText(String.valueOf(rset.getString("Obtained2")));
                        field20.setText(String.valueOf(rset.getFloat("Percentage2")));

                        field21.setText(String.valueOf(rset.getString("Class3")));
                        field22.setText(String.valueOf(rset.getString("Collage3")));
                        field23.setText(String.valueOf(rset.getString("Obtaining3")));
                        field24.setText(String.valueOf(rset.getString("Obtained3")));
                        field25.setText(String.valueOf(rset.getFloat("Percentage3")));

                        field26.setText(String.valueOf(rset.getFloat("TotalPercente")));
                    }

                    con.close();

                }catch(Exception ex){
                    System.out.print("\n"+ex.getMessage());
                }

                

            }
         });

         btn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                clearForm();
                showForm();

                String DOB = JOptionPane.showInputDialog(frame, "Enter The Date-Of-Birth");
                String name = JOptionPane.showInputDialog(frame, "Enter The User-Name");

                name = "'"+name+"'";

                try{

                    Connection con = mth.getDBConnection("info");
                    
                    String query = " SELECT * FROM info WHERE DOB = "+"'"+mth.getDBDate(DOB)+"'"+
                                    " AND Name = "+name;

                    Statement stmt = con.createStatement();
                    ResultSet rset = stmt.executeQuery(query);

                    field1.setEditable(false);
                    field2.setEditable(false);
                    field3.setEditable(false);
                    field4.setEditable(false);
                    field5.setEditable(false);
                    field6.setEditable(false);
                    field7.setEditable(false);
                    field8.setEditable(false);


                    field11.setEditable(false);
                    field12.setEditable(false);
                    field13.setEditable(false);
                    field14.setEditable(false);
                    field15.setEditable(false);

                    field16.setEditable(false);
                    field17.setEditable(false);
                    field18.setEditable(false);
                    field19.setEditable(false);
                    field20.setEditable(false);

                    field21.setEditable(false);
                    field22.setEditable(false);
                    field23.setEditable(false);
                    field24.setEditable(false);
                    field25.setEditable(false);
                    field26.setEditable(false);

                    while(rset.next()){
                        field1.setText(rset.getString("Name"));
                        field2.setText(String.valueOf(rset.getDate("DOB")));
                        field3.setText(String.valueOf(rset.getInt("Age")));
                        field4.setText(String.valueOf(rset.getDate("DOJ")));
                        field5.setText(String.valueOf(rset.getString("Mobile")));
                            field5.setEditable(true);
                        field6.setText(String.valueOf(rset.getString("Address")));
                            field6.setEditable(true);
                        combo.setVisible(false);
                        comboField.setVisible(true);
                        comboField.setEditable(false);
                        comboField.setText(rset.getString("City"));
                        field7.setText(String.valueOf(rset.getString("State")));
                        field8.setText(String.valueOf(rset.getString("Country")));

                        field11.setText(String.valueOf(rset.getString("Class1")));
                        field12.setText(String.valueOf(rset.getString("Collage1")));
                        field13.setText(String.valueOf(rset.getString("Obtaining1")));
                        field14.setText(String.valueOf(rset.getString("Obtained1")));
                        field15.setText(String.valueOf(rset.getFloat("Percentage1")));

                        field16.setText(String.valueOf(rset.getString("Class2")));
                        field17.setText(String.valueOf(rset.getString("Collage2")));
                        field18.setText(String.valueOf(rset.getString("Obtaining2")));
                        field19.setText(String.valueOf(rset.getString("Obtained2")));
                        field20.setText(String.valueOf(rset.getFloat("Percentage2")));

                        field21.setText(String.valueOf(rset.getString("Class3")));
                        field22.setText(String.valueOf(rset.getString("Collage3")));
                        field23.setText(String.valueOf(rset.getString("Obtaining3")));
                        field24.setText(String.valueOf(rset.getString("Obtained3")));
                        field25.setText(String.valueOf(rset.getFloat("Percentage3")));

                        field26.setText(String.valueOf(rset.getFloat("TotalPercente")));
                    }

                    con.close();

                }catch(Exception ex){
                    System.out.print("\n"+ex.getMessage());
                }

            }
         });

         btn3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                clearForm();
                showForm();

                String DOB = JOptionPane.showInputDialog(frame, "Enter The Date-Of-Birth To Delete User");
                String name = JOptionPane.showInputDialog(frame, "Enter The User-Name to Delete User");

                try{

                    Connection con = mth.getDBConnection("info");

                    String query = " DELETE FROM info WHERE DOB = "+"'"+mth.getDBDate(DOB)+"'"+
                                    " AND Name = "+"'"+name+"'";
                                    
                    PreparedStatement pstate = con.prepareStatement(query);
                    pstate.executeUpdate();

                    JOptionPane.showMessageDialog(frame, "User Deleted Successfully");

                }catch(Exception ex){
                    System.out.print("\n"+ex.getMessage());
                }   

            }
         });

         btn5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                String DOB = JOptionPane.showInputDialog(frame, "Enter The Date-Of-Birth To Update User-Info");
                String name = JOptionPane.showInputDialog(frame, "Enter The User-Name to Update User-Info");

                try{

                    Connection con = mth.getDBConnection("info");

                    String query = " UPDATE info SET Mobile =  "+"'"+field5.getText()+"'"+
                                    " , Address = "+"'"+field6.getText()+"'" +
                                    " WHERE DOB =  "+"'"+mth.getDBDate(DOB)+"'"+
                                    " AND Name = "+"'"+name+"'";
                                    
                    PreparedStatement pstate = con.prepareStatement(query);
                    pstate.executeUpdate();

                    JOptionPane.showMessageDialog(new JFrame(), "User-Details Updated Successfully");

                }catch(Exception ex){
                    System.out.print("\n"+ex.getMessage());
                }
            }
         });

         frame.setVisible(true);

    }
}