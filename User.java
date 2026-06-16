import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String username;
    private BigDecimal balance;
    private Map<String, Integer> portfolio = new HashMap<>();

    public User(String username, BigDecimal initialBalance) {
        this.username = username;
        this.balance = initialBalance;
    }

    public void buyStock(String symbol, int quantity, BigDecimal price) {
        BigDecimal totalCost = price.multiply(BigDecimal.valueOf(quantity));
        if (this.balance.compareTo(totalCost) >= 0) {
            this.balance = this.balance.subtract(totalCost);
            portfolio.put(symbol, portfolio.getOrDefault(symbol, 0) + quantity);
        } else {
            System.out.println("Insufficient funds!");
        }
    }
    public void sellStock(String symbol, int quantity, BigDecimal price) {
        if (portfolio.getOrDefault(symbol, 0) >= quantity) {
            BigDecimal totalGain = price.multiply(BigDecimal.valueOf(quantity));
            this.balance = this.balance.add(totalGain);
            portfolio.put(symbol, portfolio.get(symbol) - quantity);
            System.out.println("Sold " + quantity + " shares of " + symbol);
        } else {
            System.out.println("Insufficient stock to sell!");
        }
    }
    public void displayPortfolio() {
        System.out.println("--- Portfolio for " + this.username + " ---");
        System.out.println("Balance: $" + this.balance);
        if (portfolio.isEmpty()) {
            System.out.println("No stocks owned.");
        } else {
            for (Map.Entry<String, Integer> entry : portfolio.entrySet()) {
                System.out.println("Stock: " + entry.getKey() + " | Quantity: " + entry.getValue());
            }
        }
        System.out.println("----------------------------");
    }
} 
