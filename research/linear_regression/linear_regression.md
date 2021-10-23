# Linear Regression

## Least-squares

Accuracy of a line as a line of best fit is calculated by comparing the y-values of each point (the predicted result based on the x-value) to the y-value of the line of best fit at that same x-value. We take the square of each difference and sum the results of all points in the data.

We can calculate a residual value $r_n$ for a given point:

$r_n = y_{actual}-y_{expected}$

Using the residual of each point, we can calculate a measure of the fit of the line, the sum of square residuals, $S$:

$S = \sum (r_n)^2$

https://www.khanacademy.org/math/ap-statistics/bivariate-data-ap/xfb5d8e68:residuals/v/regression-residual-intro

## Correlation Coefficient

Mean:

$\bar a=\frac{\sum|a_n|}{n}$

Standard deviation:

$s=\sqrt{\frac{\sum(x-\bar x)^2}{n-1}}$

Correlation coefficient:

$r = \frac{1}{n-1}\sum(\frac{x_i-\bar x}{s_x})(\frac{y_i-\bar y}{s_y})$

https://www.khanacademy.org/math/ap-statistics/bivariate-data-ap/correlation-coefficient-r/v/calculating-correlation-coefficient-r

## Calculating the line equation

For the general line equation $y=mx+b$ we can calculate the constants as follows:

$m=r \frac{s_y}{s_x}$, where $s_x$ and $s_y$ are the standard deviation of the data points on each axis and $r$ is the correlation coefficient.


The point $(\bar x,\bar y)$ is guarenteed to be on the line, so we can substitute these values into the general line equation to calculate the value of $b$.

$\bar y=m\bar x+b$

Which can be rearranged as:

$b = \bar y-m\bar x$

https://www.khanacademy.org/math/ap-statistics/bivariate-data-ap/least-squares-regression/v/calculating-the-equation-of-a-regression-line