# Piecewise Linear Regression

## Piecewise Linear Functions

Each section of a function is defined by providing a range and the function for the specified range.

$`
f(x) = \left\{
    \begin{array}{ll}
        x^2 & if \, x<2\\
        6 & if \, x=2\\
        10-x & if \; x>2 \; and \; x\leq6
    \end{array}
\right.
`$

https://www.mathsisfun.com/sets/functions-piecewise.html

## Piecewise Linear Regression

Piecewise linear regression involves using more than one linear regression line to model a data set. We choose a point, or points that the line used will change at and apply a corrected, but still linear line to model the data.
### Dummy Variables

$`y=\alpha+\beta_1 x+\beta_2(x-k_2)D\,`$  where $`\alpha`$ is the Y intercept and $`\beta_1`$ is the gradient of the initial line, $`\beta_2`$ and above are modifications to the gradiant beyond $`\theta_2`$, which is the x position a new line gradient is introduced.

### Programming

We need to calculate some things either first, or during calculation of the model:

- Which data values the knot value applies to
- x-k values for the values the knot applies to

Then:
- Calculate linear regression model for up until knot value
- Extend the model to operate on both data sets