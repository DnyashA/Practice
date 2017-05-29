import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public class JDBC {
    static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/JDBC";
    static final String USER = "DnyashA";
    static final String PASS = "";
    static Connection connection = null;

    public static BigDecimal id;
    public static String artist;
    public static String title;
    public static Date releaseDate;
    public static double listPrice;
    public static double price;
    public static int version;

    public static void print(){
        System.out.println("ID = " + id);
        System.out.println("Artist = " + artist);
        System.out.println("Title = " + title);
        System.out.println("Release date = " + releaseDate.toString());
        System.out.println("List price = " + listPrice);
        System.out.println("Price = "  + price);
        System.out.println("Version = " + version);
    }

    public static void create(BigDecimal id, String title, String artist, Date releaseDate, Double listPrice, Double price, Integer version) throws SQLException{
        String sql = "INSERT INTO \"Item\" VALUES (ITEM_ID, Title, Artist, ReleaseDate, ListPrice, Price, Version)";
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.executeUpdate();
            connection.commit();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            if (pstmt != null){
                pstmt.close();
            }
        }
    }
    public static void searchByKeyword(String keyword) throws SQLException{
        String sql = "SELECT * FROM \"Item\" WHERE \"Title\" LIKE  '%" + keyword + "%'";
        PreparedStatement pstmt = null;
        ArrayList<ResultSet> res = new ArrayList<>();
        try {
            pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                System.out.println("id = " + rs.getBigDecimal(1));
                System.out.println("artist = " + rs.getString(3));
                System.out.println("title = " + rs.getString(2));
                System.out.println("releaseDate = " + rs.getDate(4));
                System.out.println("listPrice = " + rs.getDouble(5));
                System.out.println("price = " + rs.getDouble(6));
                System.out.println("version = " + rs.getInt(7));
                System.out.println();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            if (pstmt != null) {
                pstmt.close();
            }
        }
    }

    public static void getByID(int n) throws SQLException{
        String sql = "SELECT * FROM \"Item\" WHERE \"ITEM_ID\"=" + n;
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                id = rs.getBigDecimal(1);
                artist = rs.getString(3);
                title = rs.getString(2);
                releaseDate = rs.getDate(4);
                listPrice = rs.getDouble(5);
                price = rs.getDouble(6);
                version = rs.getInt(7);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }


    public static void connect(){
        DatabaseMetaData dbmd;
        System.out.println("Testing connection to PostgreSQL JDBC");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
            return;
        }

        System.out.println("PostgreSQL JDBC Driver successfully connected");

        try {
            connection = DriverManager
                    .getConnection(DB_URL, USER, PASS);
            dbmd = connection.getMetaData();
            System.out.println("Connecting to " + dbmd.getURL() + " as " + dbmd.getUserName() + " using " + dbmd.getDriverName() + "..." );
            if (connection != null) {
                System.out.println("You successfully connected to database now");
            }
            else {
                System.out.println("Failed to make connection to database");
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }
    }

    public static void main(String[] argv) throws SQLException {
        connect();
        System.out.println("searchByKeywor results:");
        searchByKeyword("of");
        System.out.println();
        System.out.println("getByID results:");
        getByID(1);
        print();
        //create(BigDecimal.valueOf(1), "test", "test", new Date(2017, 01, 01), 12.50, 12.51, 1);
    }
}
