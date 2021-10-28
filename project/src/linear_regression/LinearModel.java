package linear_regression;

/**
 * Defines a linear model for an equation of the form y=mx+c
 * Where m is named the coefficient, and c is named the constant
 */
 public class LinearModel implements Model {
    private double coefficient;
    private double constant;

    /**
     * @param coefficient produces the gradient of the resulting line function
     * @param constant produces the y-intercept of the resulting line function
     */
    public LinearModel(double coefficient, double constant) {
        this.coefficient=coefficient;
        this.constant=constant;
    }

    /**
     * Given the defined linear model, calculate a value of y for the given value of x
     * @param x variable to be provided to the linear model function
     * @return y; result from the model as a prediction based on x
     */
    public double predict(double x) {
        return coefficient*x+constant;
    }
}
