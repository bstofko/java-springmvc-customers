/**
 * @author Bob Stofko
 * @version $1.0$
 */

package com.heb.assignment1.service;

import com.heb.assignment1.dao.CustomerDao;
import com.heb.assignment1.model.Customer;
import com.heb.assignment1.util.DatabaseConnection;
import com.heb.assignment1.util.EmailSender;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.List;

//singletons have static methods
//connection activity must be in service layer
//each method its own connection and closing with a finally
//The finally block always executes when the try block exits. This ensures that the finally block is executed even if an unexpected exception occurs. But finally is useful for more than just exception handling — it allows the programmer to avoid having cleanup code accidentally bypassed by a return, continue, or break. Putting cleanup code in a finally block is always a good practice, even when no exceptions are anticipated.

public class CustomerService {
    private static final Logger logger = Logger.getLogger(CustomerService.class);
    private String emailMessage;

    public List<Customer> updateAndGenerateReport(String recipient, String sender, String subject, String smtpHost) throws SQLException {
        try {
            //deleteAllCustomers();
            //resetAutoIncrement();
            updateCustomersFromFile();
            getAllCustomers();
        } catch (Exception e) {
            logger.error("ERROR Error updating database and generating report...");
            e.printStackTrace();
        }
        return null;
    }

    public String getAllCustomers() throws SQLException {
        Connection connection = null;
        StringBuilder stringBuilder = new StringBuilder();

        try {
            connection = DatabaseConnection.getConnection();
            List<Customer> customers = CustomerDao.getAllCustomers(connection);
            Customer customer;

            stringBuilder.append("\n\n === Texas Customers ===\n\n");

            for (int i = 0; i < customers.size(); i++) {
                customer = customers.get(i);
                if (customer.getState().equals("TX")) {
                    stringBuilder.append(customer);
                    stringBuilder.append(System.getProperty("line.separator"));
                }
            }

            stringBuilder.append("\n === Out of State Customers ===\n\n");

            for (int i = 0; i < customers.size(); i++) {
                customer = customers.get(i);
                if (!customer.getState().equals("TX")) {
                    stringBuilder.append(customer);
                    stringBuilder.append(System.getProperty("line.separator"));
                }
            }

            String reportOutput = stringBuilder.toString();
            logger.info(reportOutput);
            this.emailMessage = reportOutput;

            updateTimeStamp();

            return reportOutput;

        } catch (Exception e) {
            logger.error("ERROR retrieving customer data...");
            e.printStackTrace();
            return null;

        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }
    }

    public Customer getCustomer(int customerId) throws SQLException {
        Connection connection = null;
        StringBuilder stringBuilder = new StringBuilder();

        try {
            connection = DatabaseConnection.getConnection();
            Customer customer = CustomerDao.getCustomer(customerId, connection);
            stringBuilder.append(customer);
            String result = stringBuilder.toString();
            logger.info(result);
            return customer;

        } catch (Exception e) {
            logger.error("ERROR retrieving customer data...");
            e.printStackTrace();
            return null;

        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }
    }

    public boolean addCustomer(String lastName, String firstName, String email, String address, String city,
                               String state, String zip) throws SQLException {
        Connection connection = null;

        try {
            connection = DatabaseConnection.getConnection();
            CustomerDao.addCustomer(lastName, firstName, email, address, city, state, zip, connection);
            logger.info("New customer added...");
            return true;

        } catch (Exception e) {
            logger.error("ERROR deleting customer data...");
            e.printStackTrace();
            return false;

        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }

    }

    public boolean deleteAllCustomers() throws SQLException {
        Connection connection = null;

        try {
            connection = DatabaseConnection.getConnection();
            CustomerDao.deleteAllCustomers(connection);
            logger.info("Customer data deleted...");
            return true;

        } catch (Exception e) {
            logger.error("ERROR deleting customer data...");
            e.printStackTrace();
            return false;

        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }
    }

    public boolean resetAutoIncrement() throws SQLException {
        Connection connection = null;

        try {
            connection = DatabaseConnection.getConnection();
            CustomerDao.resetAutoIncrement(connection);
            logger.info("Auto increment value reset to 0...");
            return true;

        } catch (Exception e) {
            logger.error("ERROR resetting auto increment...");
            e.printStackTrace();
            return false;

        } finally {
            if (connection != null) {

                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }
    }

    public void updateCustomersFromFile() throws SQLException {
        Connection connection = null;

        try {
            connection = DatabaseConnection.getConnection();
            CustomerDao.updateDataFromFile(connection);
            logger.info("Database updated...");

        } catch (Exception e) {
            logger.error("ERROR updating database...");
            e.printStackTrace();

        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }
    }

    public void updateTimeStamp() throws SQLException {
        Connection connection = null;

        try {
            connection = DatabaseConnection.getConnection();
            CustomerDao.updateTimeStamp(connection);
            logger.info("Database updated...");

        } catch (Exception e) {
            logger.error("ERROR updating database...");
            e.printStackTrace();

        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }
    }
}
