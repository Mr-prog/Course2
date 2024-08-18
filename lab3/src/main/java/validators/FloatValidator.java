package validators;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;


abstract class FloatValidator implements Validator<Object> {

    protected abstract boolean isValid(float number);

    protected abstract String getStandardErrorMessage();

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        final float number = parseFloat(o);
        if (!isValid(number)) throw new ValidatorException(getStandardFacesErrorMessage());
    }

    private float parseFloat(Object o) throws ValidatorException {
        try {
            return Float.parseFloat(o.toString());
        } catch (NumberFormatException | NullPointerException e) {
            throw new ValidatorException(getStandardFacesErrorMessage());
        }
    }

    private FacesMessage getStandardFacesErrorMessage() {
        return new FacesMessage(getStandardErrorMessage());
    }
}