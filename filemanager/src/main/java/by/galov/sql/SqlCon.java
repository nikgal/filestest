package by.galov.sql;

import java.sql.*;

public class SqlCon {

    private static String connectionURL = "jdbc:mysql://localhost:3306/test";
    private static String user = "root";
    private static String pass = "123";
            
        public static void getSqlCon() {
            try{
                Class.forName("com.mysql.jdbc.Driver");

                Connection conn = DriverManager.getConnection(connectionURL,user,pass);

                Statement stm = conn.createStatement();

                ResultSet resultSet = stm.executeQuery("SELECT*FROM shop");

                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String price = resultSet.getString("price");

                    System.out.println(id + " " + name + " " + price);
                }


                resultSet.close();
                conn.close();

           
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        
        }

}
