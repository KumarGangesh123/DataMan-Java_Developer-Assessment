import java.awt.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument.BlockElement;

class methods {

    public int num(String val){
        return Integer.parseInt(val);
    }

    public int getAge(String DOB){
        String[] dobs = DOB.split("-",3);

            if( (num(dobs[2]) >= 8) && (num(dobs[1]) >= 6) ){
                return 2023-num(dobs[0]);
                //field3.setText(String.valueOf(2023 - num(dobs[2])));
            }else{
                return 2023-num(dobs[0])-1;
                //field3.setText(String.valueOf(2023 - num(dobs[2]) -1));
            }

                    // String data2 = field4.getText();
                    // String[] dob = data2.split("/",3);
                    // if(num(dob[2]) - num(dobs[2]) < 20 ){
                    //     JOptionPane.showMessageDialog(new JFrame(),"Invalid Joining date");
                    //     field4.setText("");
                    // }
    }

    public float getPercentage(String obtaining,String obtained){
        float one = Float.parseFloat(obtained);
        float two = Float.parseFloat(obtaining);
        return (one/two)*100;
    }

    public float getPercentageAll(String first,String second,String third){
        float one = Float.parseFloat(first);
        float two = Float.parseFloat(second);
        float three = Float.parseFloat(third);
        return (one+two+three)/3;
    }

    public boolean checkAge(String DOB,String DOJ){
        String[] dob = DOB.split("-",3);
        String[] doj = DOJ.split("-",3);
        if(num(doj[0]) - num(dob[0]) < 20 ){
            return  false;
        }return true;
    }

    public float percent(String obtain,String obtained){
        float num1=Float.parseFloat(obtained);
        float num2=Float.parseFloat(obtain);
        return (float)(num1/num2)*100;
    }

    public boolean isRightAge(String DOB){
        String[] dob = DOB.split("-",3);

        if(DOB.length() > 10 || DOB.length() < 10){
            return false;
        }else if(Integer.parseInt(dob[1]) < 1 || Integer.parseInt(dob[1]) > 12){
            return false;
        }else if(Integer.parseInt(dob[2]) < 1 || Integer.parseInt(dob[2]) > 31){
            return false;
        }return true;
    }
    
    public Connection getDBConnection(String tableName){
        try{
            // com.microsoft.sqlserver.jdbc.SQLServerDriver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // System.out.print("\nDriver loaded");

            // "jdbc:sqlserver://GANGESH_KUMAR\\SQLEXPRESS;databaseName=test;integratedSecurity=true;encrypt=false"

            Connection con = DriverManager.getConnection("jdbc:sqlserver://GANGESH_KUMAR\\SQLEXPRESS;databaseName=testing;integratedSecurity=true;encrypt=false");

            // System.out.print("\nconnected");

            return con;

        }catch(Exception e){
            System.out.print("\n"+e.getMessage());
            return null;
        }
    }

    public JFrame getFrame(){
        JFrame frame = new JFrame();
        frame.setBounds(0,50,2000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }

    public JLabel getLabel(String name,int x,int y,int width,int height){
        JLabel label = new JLabel(name);
        label.setBounds(x,y,width,height);
        label.setFont(new Font("Arial",Font.BOLD,30));
        return label;
    }

    public JButton getButton(String name,int x,int y,int width,int height){
        JButton button = new JButton(name);
        button.setBounds(x,y,width,height);
        button.setFont(new Font("Arial",Font.BOLD,30));
        return button;
    }

    public JTextField getTextField(int x,int y,int width,int height){
        JTextField field = new JTextField();
        field.setBounds(x,y,width,height);
        field.setFont(new Font("Arial",Font.BOLD,20));
        return field;
    }

    public java.sql.Date getDBDate(String date){

        Date date1 = Date.valueOf(date);

        return new java.sql.Date(date1.getTime());

    }

    public boolean isEmpty(JTextField field){
        if(field.getText().equals("")){
            return true;
        }return false;
    }

    public ResultSet getDBData(Connection con, int ID){

        try{

            Statement stmt = con.createStatement();
            ResultSet rset = stmt.executeQuery(" SELECT * FROM checking WHERE ID = "+ID);
            return rset;
        }catch(Exception e){
            System.out.print("\n"+e.getMessage());
            return null;
        }


    }

    public String toConvert(String value){
        return "'"+value+"'";
    }

}
