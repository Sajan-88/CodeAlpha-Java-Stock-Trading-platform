import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        User student = new User("InternUser", new BigDecimal("1000.00"));
        student.buyStock("TECH", 5, new BigDecimal("50.00"));
        student.sellStock("TECH", 2, new BigDecimal("60.00"));
        student.displayPortfolio();
    }
}
