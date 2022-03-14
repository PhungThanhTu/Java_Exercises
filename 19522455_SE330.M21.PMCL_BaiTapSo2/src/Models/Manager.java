package Models;

/**
 * Manager Staff
 */
public class Manager extends Staff{

    @Override
    public int getBasicSalary() {
        return 1500;
    }

    @Override
    public int getBills() {
        return getType() == ContractType.Intern ? (int)(getBasicSalary()*1.2) : (int) (getBasicSalary()*1.5);
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Loai nhan vien : Quan li");
    }
}
