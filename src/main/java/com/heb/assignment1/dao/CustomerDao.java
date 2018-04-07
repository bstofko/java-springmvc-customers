/**
 * @author Bob Stofko
 * @version $1.0$
 */

package com.heb.assignment1.dao;

import com.heb.assignment1.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {

    private static final String GET_ALL_CUSTOMERS = "SELECT last,first,email,address,city,state,zip,id FROM clients.customers;";
    private static final String DELETE_ALL_CUSTOMERS = "DELETE FROM customers;";
    private static final String GET_CUSTOMER = "SELECT last,first,email,address,city,state,zip FROM clients.customers WHERE id = ?";
    private static final String RESET_AUTO_INCREMENT = "ALTER TABLE customers AUTO_INCREMENT = 0;";
    private static final String UPDATE_DATA_FROM_FILE = "LOAD DATA LOCAL INFILE 'C:/customers.txt' INTO TABLE clients.customers " +
            "CHARACTER SET utf8 FIELDS TERMINATED BY ',' ENCLOSED BY '\"' LINES TERMINATED BY '\\r\\n'";
    private static final String UPDATE_TIMESTAMP = "UPDATE clients.customers SET time=(current_timestamp())";
    private static final String ADD_CUSTOMER = "INSERT INTO clients.customers (last, first, email, address, city, state, zip) VALUES (?,?,?,?,?,?,?)";

    //try catch should be in service layer - try/catch/finally(close)

    public static Customer getCustomer(int customerId, Connection connection) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(GET_CUSTOMER);
        stmt.setInt(1, customerId);
        ResultSet results = stmt.executeQuery();
        Customer customer = new Customer();

        while (results.next()) {
            customer.setLastName(results.getString("last"));
            customer.setFirstName(results.getString("first"));
            customer.setEmail(results.getString("email"));
            customer.setAddress(results.getString("address"));
            customer.setCity(results.getString("city"));
            customer.setState(results.getString("state"));
            customer.setZip(results.getString("zip"));
        }
        return customer;
    }

    public static List<Customer> getAllCustomers(Connection connection) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(GET_ALL_CUSTOMERS);
        ResultSet results = stmt.executeQuery();
        List<Customer> customers = new ArrayList<>();

        while (results.next()) {
            Customer customer = new Customer();
            customer.setLastName(results.getString("last"));
            customer.setFirstName(results.getString("first"));
            customer.setEmail(results.getString("email"));
            customer.setAddress(results.getString("address"));
            customer.setCity(results.getString("city"));
            customer.setState(results.getString("state"));
            customer.setZip(results.getString("zip"));
            customer.setId(results.getInt("id"));
            customers.add(customer);
        }
        return customers;
    }

    public static void addCustomer(String lastName, String firstName, String email, String address, String city, String state, String zip, Connection connection) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(ADD_CUSTOMER);
        stmt.setString(1, lastName);
        stmt.setString(2, firstName);
        stmt.setString(3, email);
        stmt.setString(4, address);
        stmt.setString(5, city);
        stmt.setString(6, state);
        stmt.setString(7, zip);
        stmt.executeUpdate();
    }

    public static void deleteAllCustomers(Connection connection) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(DELETE_ALL_CUSTOMERS);
        stmt.executeUpdate();
    }

    public static void resetAutoIncrement(Connection connection) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(RESET_AUTO_INCREMENT);
        stmt.executeUpdate();
    }

    public static void updateDataFromFile(Connection connection) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(UPDATE_DATA_FROM_FILE);
        stmt.executeUpdate();
    }

    public static void updateTimeStamp(Connection connection) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(UPDATE_TIMESTAMP);
        stmt.executeUpdate();
    }
}
