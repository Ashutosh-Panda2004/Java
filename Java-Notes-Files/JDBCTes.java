package world;
import java.sql.*;
public class JDBCTest {
    public static void f1() throws SQLException{
        Connection con=null;
        String url="jdbc:mysql://localhost:3306/db1";

        con=DriverManager.getConnection(url,"root","admin@2023");
        if(con!=null)
            System.out.println("Connection Established");
        String q="select * from Book where price > ?";
        PreparedStatement ps=con.prepareStatement(q);
        ps.setDouble(1,500.0);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            System.out.print(rs.getInt(1)+" ");
            System.out.print(rs.getString(2)+" ");
            System.out.print(rs.getDouble(3)+" ");
            System.out.println();
        }

    }
}
