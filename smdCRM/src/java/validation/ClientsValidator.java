/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.stereotype.Component;

import objects.Clients;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@Component
public class ClientsValidator implements Validator {

    private static final Logger logger = Logger.getLogger(ClientsValidator.class.getName());

    @Override
    public boolean supports(Class<?> clazz) {
        return Clients.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
       ValidationUtils.rejectIfEmptyOrWhitespace(errors,"firstname", "Clients.firstname.required");
       ValidationUtils.rejectIfEmptyOrWhitespace(errors,"lastname", "Clients.lastname.required");
       ValidationUtils.rejectIfEmptyOrWhitespace(errors,"company", "Clients.company.required");
       ValidationUtils.rejectIfEmptyOrWhitespace(errors,"address1", "Clients.address1.required");
       //ValidationUtils.rejectIfEmptyOrWhitespace(errors,"address2", "Clients.address2.required");
       ValidationUtils.rejectIfEmptyOrWhitespace(errors,"city", "Clients.city.required");
       ValidationUtils.rejectIfEmptyOrWhitespace(errors,"state", "Clients.state.required");
       ValidationUtils.rejectIfEmptyOrWhitespace(errors,"zip", "Clients.zip.required");
       ValidationUtils.rejectIfEmptyOrWhitespace(errors,"phone", "Clients.phone.required");
       ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email", "Clients.email.required");
        
       Clients clients = (Clients) target;
        if (clients.getFirstname().length() > 120) {
            errors.rejectValue("firstname", "clients.firstname.length");
        }
        if (clients.getLastname().length() > 120) {
            errors.rejectValue("lastname", "clients.lastname.length");
        }
        if (clients.getAddress1().length() > 120) {
            errors.rejectValue("address1", "clients.address1.length");
        }
        if (clients.getAddress2().length() > 120) {
            errors.rejectValue("address2", "clients.address2.length");
        }
        if (clients.getCity().length() > 120) {
            errors.rejectValue("city", "clients.city.length");
        }
        if (clients.getState().length() > 120) {
            errors.rejectValue("state", "clients.state.length");
        }
        if (clients.getZip().length() > 20) {
            errors.rejectValue("zip", "clients.zip.length");
        }
        if (clients.getPhone().length() > 20) {
            errors.rejectValue("phone", "clients.phone.length");
        }
         if (clients.getEmail().length() > 120) {
            errors.rejectValue("email", "clients.email.length");
        }
        if (!clients.getFirstname().matches("^[A-Za-z0-9]*$")) {
            errors.rejectValue("firstname", "clients.firstname.pattern");
        }
        if (!clients.getLastname().matches("^[A-Za-z0-9]*$")) {
            errors.rejectValue("lastname", "clients.lastname.pattern");
        }
        if (!clients.getCity().matches("^[A-Za-z0-9]*$")) {
            errors.rejectValue("city", "clients.city.pattern");
        }
        if (!clients.getEmail().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
            errors.rejectValue("email", "clients.email.pattern");
        } 
    }
}
    
