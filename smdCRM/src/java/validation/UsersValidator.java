/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import java.util.logging.Logger;
import objects.Users;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import java.util.regex.Pattern;

/**
 *
 * @author sethd
 */

@Component
public class UsersValidator implements Validator {

    private static final Logger logger = Logger.getLogger(UsersValidator.class.getName());

    @Override
    public boolean supports(Class<?> clazz) {
        return Users.class.isAssignableFrom(clazz);
    }  
    
    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Username", "users.Username.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Password", "users.Password.required");

        Users users = (Users) target;
        if (users.getUsername().length() > 45) {
            errors.rejectValue("username", "users.username.length");
        }

        if (!users.getUsername().matches("^[A-Za-z0-9]*$")) {
            errors.rejectValue("username", "users.username.pattern");
        }

        if (users.getPassword().length() <= 8 && users.getPassword().length() >= 12) {
            errors.rejectValue("password", "users.password.length");
        }

        if (!users.getPassword().matches("^[A-Za-z0-9]*$")) {
            errors.rejectValue("password", "users.password.pattern");
        }
    }

}
