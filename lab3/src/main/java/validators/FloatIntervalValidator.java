package validators;

abstract class FloatIntervalValidator extends FloatValidator {
    private final float min;
    private final float max;


    protected FloatIntervalValidator(float min, float max) {
        this.min = min;
        this.max = max;
    }

    @Override
    protected boolean isValid(float number) {
        return (number > min && number < max);
    }


    @Override
    protected String getStandardErrorMessage() {
        return "(" + min + "; " + max + ")";
    }
}