package Models;

public interface IMileageCalculator {
    /**
     * Calc mileage of a vehicle object
     * @return 0 if the vehicle doesn't have mileage property, its mileage if it has mileage property
     */
    double calcOdo();
}
