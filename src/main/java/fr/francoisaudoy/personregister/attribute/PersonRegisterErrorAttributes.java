package fr.francoisaudoy.personregister.attribute;

import fr.francoisaudoy.personregister.exception.PersonRegisterException;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Component
public class PersonRegisterErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> attributes = super.getErrorAttributes(webRequest, options);

        final Throwable t = super.getError(webRequest);

        if (t instanceof PersonRegisterException) {
            PersonRegisterException exception = (PersonRegisterException) t;
            attributes.put("code", exception.getErrorCode());
            attributes.put("message", exception.getMessage());
        }

        return attributes;
    }
}
