package util;

public class Individual extends Payer{
    
    private Double healthExpends;

    public Individual(String name, Double income, Double healthExpends) {
        super(name, income);
        this.healthExpends = healthExpends;
    }

    public Double getHealthExpends() {
        return healthExpends;
    }

    public void setHealthExpends(Double healthExpends) {
        this.healthExpends = healthExpends;
    }

    @Override
    public Double calcTaxes() {
        if (income < 20000) {
            return (income * 0.15) - (healthExpends * 0.5);
        } else {
            return (income * 0.25) - (healthExpends * 0.5);
        }
    }
}
