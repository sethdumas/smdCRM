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

import objects.Interactions;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 *
 * @author sethd
 */

@Component
public class InteractionsValidator implements Validator {

    private static final Logger logger = Logger.getLogger(InteractionsValidator.class.getName());

    @Override
    public boolean supports(Class<?> clazz) {
        return Interactions.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "interaction.firstname.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "interaction.lastnamame.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "typeofinteraction", "typeofinteraction.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "interactiontime", "interaction.interactiontime.required");
        Interactions interactions = (Interactions) target;

        if (!interactions.getFirstname().matches("^[a-zA-Z0-9-_. ]+$")) {
            errors.rejectValue("firstname", "interactions.firstname.pattern", "default");
        }

        if (!interactions.getLastname().matches("^[a-zA-Z0-9-_. ]+$")) {
            errors.rejectValue("lastname", "interactions.lastname.pattern", "default");
        }
    }

}