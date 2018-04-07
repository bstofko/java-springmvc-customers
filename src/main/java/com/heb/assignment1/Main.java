/**
 * @author Bob Stofko
 * @version $1.0$
 */
 
package com.heb.assignment1;

import com.heb.assignment1.dao.CustomerDao;
import com.heb.assignment1.service.CustomerService;
import com.heb.assignment1.util.DatabaseConnection;
import org.apache.log4j.PropertyConfigurator;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException{
        PropertyConfigurator.configure("C:/Users/s718138/IntelliJ/Customers/src/main/resources/log4j.properties");

        CustomerService customerService = new CustomerService();
    }
}
