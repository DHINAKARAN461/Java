import java.net.Proxy;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void read(String database,String table){
        String url="jdbc:mysql://localhost:3306/"+database;
        String user="root";
        String pwd="8870";
        String query ="select * from "+table;
        try {
            Connection con =DriverManager.getConnection(url,user,pwd);
            Statement st = con.createStatement();
            ResultSet rt = st.executeQuery(query);
            Scanner scan=new Scanner(System.in);
            System.out.println("Select the right option to read your table values");
            System.out.println("press 1 for String ");
            System.out.println("Press 2 for Integer ");
            int choice =scan.nextInt();
            System.out.println("choose the column by index value ");
            int index =scan.nextInt();
            switch (choice){
                case 1:
                    while (rt.next()) {
                        System.out.println(rt.getString(index));
                    }
                    break;
                case 2:
                    while (rt.next()) {
                        System.out.println(rt.getInt(index));
                    }
                    break;
                default:
                    System.out.println("wrong option");
            }

            con.close();
        }
        catch (SQLException e){
            System.out.println("Error in sql "+e.getErrorCode());
        }
    }
    public static void insert(){
        String url="jdbc:mysql://localhost:3306/jdbc";
        String user ="root";
        String pwd ="8870";
        String query ="insert into brand values(?,?)";
        int id  =7;
        String value="India";
        try {
            Connection con=DriverManager.getConnection(url,user,pwd);
            PreparedStatement psd =con.prepareStatement(query);
            psd.setInt(1,id);
            psd.setString(2,value);
            int rows=psd.executeUpdate();
            System.out.println("no of row"+rows);
            con.close();
        }
        catch (SQLException e){
            System.out.println("Sql error "+e.getErrorCode());
        }

    }
    public static void delete(){
        String url="jdbc:mysql://localhost:3306/jdbc";
        String user ="root";
        String pwd="8870";
        String query="delete from brand where to_id = 1";
        try{
            Connection con=DriverManager.getConnection(url,user,pwd);
            Statement st = con.createStatement();
            int rows = st.executeUpdate(query);
            System.out.println("no of row "+rows);
            con.close();
        }catch (SQLException e){
            System.out.println(e.getErrorCode());
        }
    }
    public static void update(){
        String url="jdbc:mysql://localhost:3306/jdbc";
        String user ="root";
        String pwd="8870";
        String query="update brand set town ='seoul' where town='city' ";
        try{
            Connection con =DriverManager.getConnection(url,user,pwd);
            Statement st = con.createStatement();
            int rows =st.executeUpdate(query);
            System.out.println("no of row "+rows);
        }catch (SQLException e){
            System.out.println("Error "+e.getErrorCode());
        }
    }
    public  static void Batch(){
        String url ="jdbc:mysql://localhost:3306/jdbc";
        String user="root";
        String pwd ="8870";
        String query1="update brand set town ='rode' where to_id =1";
        String query2="update brand set town ='okyo' where to_id =2";
        String query3="update brand set town ='saka' where to_id =4";
        String query4="update brand set town ='kerala' where to_id =7";
        try{
            Connection con=DriverManager.getConnection(url,user,pwd);
            con.setAutoCommit(false);
            Statement st=con.createStatement();
            st.addBatch(query1);
            st.addBatch(query2);
            st.addBatch(query3);
            st.addBatch(query4);
            int [] bat=st.executeBatch();
            for(int b:bat){
                if(b>0);
//                    continue;
                else{
                    con.rollback();
                }
            }
            con.commit();
            con.close();
        }catch (SQLException e){
            System.out.println(e.getErrorCode());
        }
    }

    public static void main(String[] args) throws Exception {
//    String url="jdbc:mysql://localhost:3306/jdbc";
//    String user="root";
//    String pwd="8870";
//    int id =4;
//    String query1="update brand set town ='city' where town ='seoul'";
//    String query2 ="update brand set town ='tokyo' where to_id =4";
//    Connection con= DriverManager.getConnection(url,user,pwd);
//    Statement st =con.createStatement();
//    int rows1 =st.executeUpdate(query1);
//    int rows2 =st.executeUpdate(query2);
//        System.out.println("no of rows "+rows1);
//        System.out.println("no of rows "+rows2);
//    con.setAutoCommit(false);
//    if (rows1>0 && rows2>0){
//        con.setAutoCommit(true);
//    }
//    con.close();
    Batch();
    }
}