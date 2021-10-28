package linear_regression;

public class OrdLeastSquaresTest {
    public static void main(String[] args) {
        if(test()) {
            System.out.println("Tests passed!");
        }
    }

    public static boolean test() {
        double xArray[] = {1,2,3,4,5,6,7,8,9,10};
        double yArray[] = {3,5,7,9,11,13,15,17,19,21};
        Estimator estimator = new OrdLeastSquares();
        Model model = estimator.getModel(xArray, yArray);
        assert model.predict(2)==5.0;
        assert model.predict(2.5)==6.0;
        assert model.predict(3)==7.0;
        return true;
    }
}
