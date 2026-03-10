package util;

public class Company extends Payer {

    private Integer employeesNum;

    public Company(String name, Double income, Integer employeesNum) {
        super(name, income);
        this.employeesNum = employeesNum;
    }

    public Integer getEmployeesNum() {
        return employeesNum;
    }

    public void setEmployeesNum(Integer employeesNum) {
        this.employeesNum = employeesNum;
    }

    @Override
    public Double calcTaxes() {
        if (employeesNum > 10) {
            return income * 0.14;
        } else {
            return income * 0.16;
        }
    }
}
