package com.demat.starter;

import java.sql.*;

/**
 * @author TNAJI Khalid
 */
public class Chap21JDBC {
    public static void Demo() {

        //jdbc:postgresql://localhost:5432/phonebook_db
        //protocol:subprotocol:subname

        //jdbc:postgresql://localhost/phonebook_db?user=luka?password=luka123

        String url =    "jdbc:postgresql://localhost/phonebook_db?user=luka&password=luka123";
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) System.out.println("Connected to the database!");
            else System.out.println("Failed to make connection!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        try (Connection conn = DriverManager.getConnection(url, "luka", "luka123")) {
            // make some operations
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }


        String query = "SELECT * FROM contacts";
        try (Connection conn = DriverManager.getConnection(url, "luka", "luka123");
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                System.out.println(id + ": " + firstName + " " + lastName);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        /*
SELECT
ResultSet rs = ps.executeQuery();


INSERT, UPDATE, DELETE
int rowsAffected = ps.executeUpdate();

SELECT, INSERT, UPDATE, DELETE
boolean isResultSet = ps.execute();
if true, then ResultSet exists and one can call ps.getResultSet()
if false, then there is no ResultSet and one can call ps.executeUpdate()
         */

        /*
        String query =
 "INSERT INTO contacts (first_name, last_name, email, phone_number) VALUES (?, ?, ?, ?)";
 ps.setString(1, "John");
 ps.setString(2, "Wayne");
 ps.setString(3, "john@wayne.com");
 ps.setString(4, "555-783-5252");
         */



        String procedureCall = "{call read_phone_by_name(?)}";
        try (Connection conn = DriverManager.getConnection(url, "luka", "luka123");
             CallableStatement cs = conn.prepareCall(procedureCall)) {
            cs.setString(1, "John");
            boolean hasResults = cs.execute();
            if (hasResults) {
                ResultSet rs = cs.getResultSet();
                while (rs.next()) {
                    System.out.println(rs.getString("first_name") + ": " + rs.getString("phone"));
                }
            } else { System.out.println("No results."); }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        String procedureCall2 = "{call read_phone_by_name(?, ?)}";
        try (Connection conn = DriverManager.getConnection(url);
             CallableStatement cs = conn.prepareCall(procedureCall2)) {
            cs.setString(1, "John"); //setting input (IN) parameter
            cs.registerOutParameter(2, Types.VARCHAR); //registering the output (OUT) parameter
            cs.execute();
            String phone = cs.getString(2); // reading output
            System.out.println("Phone number for John: " + phone);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }


        /*
        when closing the resources order is important:
1. ResultSet, e.g. rs.close()
2. PrepararedStatement or CallableStatement, e.g. stmt.close()
3. Connection, e.g. conn.close()
         */
    }
}
