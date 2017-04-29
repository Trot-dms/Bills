package pl.bills.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.bills.forms.UserCreateForm;
import pl.bills.other.UserSafeCodeGenerator;
import pl.bills.services.UserService;

/**
 * Created by trot on 13.04.17.
 */
@Component
public class UserCreateFormValidator implements Validator {

    private final UserService userService;
    private final UserSafeCodeGenerator userSafeCodeGenerator;

    @Autowired
    public UserCreateFormValidator(UserService userService, UserSafeCodeGenerator userSafeCodeGenerator) {
        this.userService = userService;
        this.userSafeCodeGenerator = userSafeCodeGenerator;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(UserCreateForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserCreateForm form = (UserCreateForm) target;
        validatePasswords(errors, form);
        validateEmail(errors, form);
        validateSafeCode(errors, form);
    }

    private void validatePasswords(Errors errors, UserCreateForm form) {
        if (!form.getPassword().equals(form.getPasswordRepeated())) {
            errors.rejectValue("passwordRepeated", "passwordRepeated.no_match", "Źle przepisane hasło");
        }
    }

    private void validateEmail(Errors errors, UserCreateForm form) {
        if (userService.getUserByEmail(form.getEmail()).isPresent()) {
            errors.rejectValue("email", "email.exists", "Użytkownik o tym emailu już istnieje");
        }
    }

    private void validateSafeCode(Errors errors, UserCreateForm form) {
        String formSafeCode = form.getSafeCode();
        if (formSafeCode.isEmpty() || formSafeCode == null || !formSafeCode.equals(userSafeCodeGenerator.getSafeCode())) {
            errors.rejectValue("safeCode", "safeCode.error", "Kod bezpieczeństwa jest pusty lub nieprawidłowy");
        }
    }
}
