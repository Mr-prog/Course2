package area.script;

import area.exceptions.AreaDotValidationException;
import area.model.AreaDot;


class AreaDotValidator {
    protected void validate(AreaDot areaDot) {
        float r = areaDot.getR();
        float x = areaDot.getX();
        float y = areaDot.getY();

        validateR(r);
        validateX(x);
        validateY(y);
    }


    private void validateR(float r) {
        // validation
    }


    private void validateX(float x) {
        final int min = -5;
        final int max = 3;

        boolean isXValid = x > min && x < max;

        if (!isXValid)
            throw new AreaDotValidationException();
    }


    private void validateY(float y) {
        final int min = -5;
        final int max = 3;

        boolean isYValid = y > min && y < max;

        if (!isYValid)
            throw new AreaDotValidationException();
    }
}