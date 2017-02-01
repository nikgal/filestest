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
                ResultSetMetaData rsmd = resultSet.getMetaData();

                int columnsNumber = rsmd.getColumnCount();

                while (resultSet.next()){
                    for(int i = 1 ; i <= columnsNumber; i++){

                        System.out.print(resultSet.getString(i) + "\t"); 

                  }

                    System.out.println();
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
