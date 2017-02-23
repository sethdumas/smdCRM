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

@Component
public class ClientsValidator implements Validator {

    private static final Logger logger = Logger.getLogger(ClientsValidator.class.getName());

    @Override
    public boolean supports(Class<?> clazz) {
        return Clients.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
       ValidationUtils.rejectIfEmptyOrWhitespace(errors,"firstName", "Clients.firstName.required");
       ValidationUtils.rejectIfEmptyOrWhitespace(errors,"lastName", "Clients.lastName.required");
       ValidationUtils.rejectIfEmptyOrWhitespace(errors,"company", "Clients.company.required");
       ValidationUtils.rejectIfEmptyOrWhitespace(errors,"address1", "Clients.address1.required");
       ValidationUtils.rejectIfEmptyOrWhitespace(errors,"address2", "Clients.address2.required");
       ValidationUtils.rejectIfEmptyOrWhitespace(errors,"city", "Clients.city.required");
       ValidationUtils.rejectIfEmptyOrWhitespace(errors,"state", "Clients.state.required");
       ValidationUtils.rejectIfEmptyOrWhitespace(errors,"zip", "Clients.zip.required");
       ValidationUtils.rejectIfEmptyOrWhitespace(errors,"phone", "Clients.phone.required");
       ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email", "Clients.email.required");
        
       Clients clients = (Clients) target;
        if (clients.getFirstname().length() > 120) {
            errors.rejectValue("firstname", "client.name.length");
        }

        if (!clients.getFirstname().matches("^[A-Za-z0-9]*$")) {
            errors.rejectValue("name", "client.firstname.pattern");
        } else {
           errors.rejectValue("firstName","client.firstName.pattern");
        }
        
        if (!clients.getLastname().matches("^[A-Za-z0-9]*$")) {
            errors.rejectValue("lastname", "clients.lastname.pattern");
        } else {
           errors.rejectValue("lastname","clients.lastname.pattern");
        }
        
        
    }
}
