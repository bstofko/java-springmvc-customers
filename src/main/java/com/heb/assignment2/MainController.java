/**
 * @author Bob Stofko
 * @version $1.0$
 */

package com.heb.assignment2;

import com.heb.assignment1.model.Customer;
import com.heb.assignment1.model.Email;
import com.heb.assignment1.service.CustomerService;
import com.heb.assignment1.util.EmailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import java.sql.SQLException;

@Controller
public class MainController {

    @RequestMapping(value = "/assignment2", method = RequestMethod.GET)
    public String homePage() {
        return "assignment2";
    }

    @RequestMapping(value = "/customerForm", method = RequestMethod.GET)
    public ModelAndView customerForm(@ModelAttribute Customer customer, Model model) {
        return new ModelAndView("customerForm", "customer", new Customer());
    }

    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public String addCustomer(@ModelAttribute("customer") Customer customer,
                              BindingResult result, ModelMap model) throws SQLException {
        if(result.hasErrors()){
            return "customerForm";
        }

        CustomerService customerService = new CustomerService();

        String lastName = customer.getLastName();
        String firstName = customer.getFirstName();
        String email = customer.getEmail();
        String address = customer.getAddress();
        String state = customer.getState();
        String city = customer.getCity();
        String zip = customer.getZip();

        model.addAttribute("lastName", lastName);
        model.addAttribute("firstName", firstName);
        model.addAttribute("email", email);
        model.addAttribute("address", address);
        model.addAttribute("city", city);
        model.addAttribute("state", state);
        model.addAttribute("zip", zip);

        customerService.addCustomer(lastName, firstName, email, address, city, state, zip);
        return "customerResult";
    }

    @RequestMapping(value = "/emailForm", method = RequestMethod.GET)
    public ModelAndView emailForm(@ModelAttribute Email email, Model model) {
        return new ModelAndView("emailForm", "email", new Email());
    }

    @RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
    public String sendEmail(@ModelAttribute("email") Email email,
                            BindingResult result, ModelMap model) throws SQLException {

        if(result.hasErrors()){
            return "emailForm";
        }

        CustomerService customerService = new CustomerService();
        String recipient = email.getRecipient();
        String sender = email.getSender();
        String subject = email.getSubject();
        String smtpHost = email.getSmtpHost();

        model.addAttribute("recipient", recipient);
        model.addAttribute("sender", sender);
        model.addAttribute("subject", subject);
        model.addAttribute("smtpHost", smtpHost);

        String report = customerService.getAllCustomers();
        EmailSender emailSender = new EmailSender();
        emailSender.sendEmail(recipient, sender, subject, report, smtpHost);

        return "emailResult";
    }
}
