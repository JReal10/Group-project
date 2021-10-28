# Linear Regression
## Least-squares

https://www.youtube.com/watch?v=HLXLsvQU7Sc

Accuracy of a line as a line of best fit is calculated by comparing the y-values of each point (the predicted result based on the x-value) to the y-value of the line of best fit at that same x-value. We take the square of each difference and sum the results of all points in the data.

We can calculate a residual value $`r_n`$ for a given point:

$`r_n = y_{actual}-y_{expected}`$

Using the residual of each point, we can calculate a measure of the fit of the line, the sum of square residuals, $`S`$:

$`S = \sum (r_n)^2`$

https://www.khanacademy.org/math/ap-statistics/bivariate-data-ap/xfb5d8e68:residuals/v/regression-residual-intro

## Ordinary Least Squares Regression

### Equation of a line
$`y=\alpha+\beta x\,`$  where $`\alpha`$ is the Y intercept and $`\beta`$ is the gradient of the line.

### Equation of a specific point
$`y_i=\alpha+\beta x_i+\epsilon_i`$ where $`\epsilon_i`$ is the residual for the specific point.

### Deriving the Ordinary Least Squares estimator

Start with the equation of a point and rearrange to be in terms of the residual.

$`\epsilon_i=y_i-\alpha-\beta x_i`$

We are attempting to minimise the squares of the residuals, so square both sides.

$`\epsilon_i^2=(y_i-\alpha-\beta x_i)^2`$

We want to do this for all points, so we sum.

$`\sum\epsilon_i^2=\sum(y_i-\alpha-\beta x_i)^2`$

Now we want to minimise the sum, so we differentiate with respect to $`\beta`$ and set it's value to zero to allow us to calculate the value of $`\beta`$.

$`\hat\beta=\displaystyle\frac{\sum(x_i-\bar x)(y_i-\bar y)}{\sum(x_i-\bar x)^2}`$

With the result of this, we can also calculate the $`\alpha`$ value for our line.

$`\hat\alpha=\bar y-\hat\beta \bar x`$