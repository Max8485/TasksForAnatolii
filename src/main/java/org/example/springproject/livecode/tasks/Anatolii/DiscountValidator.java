package org.example.springproject.livecode.tasks.Anatolii;

import java.util.*;

public class DiscountValidator {
    public static void main(String[] args) {
        DiscountChainValidator chainValidator = new DiscountChainValidator();

        List<DiscountRule> rules = List.of(
                new DiscountRule("early", DiscountType.PERCENT, 10, "veteran"),
                new DiscountRule("veteran", DiscountType.PERCENT, 5, null), //"student"
                new DiscountRule("student", DiscountType.FIXED, 50, "early"));

        System.out.println(chainValidator.calculateFinalAmount(rules, 1000.0, "student")); // 812.25

        //// Цепочка для "student": student → early → veteran
        //// Результат: начальная сумма 1000 → -50 = 950 → -10% = 855 → -5% = 812.25
    }

    // Задача: Валидатор цепочки скидок в интернет-магазине

    // В корзине интернет-магазина применяется цепочка скидочных правил. Каждое правило имеет тип (PERCENT или FIXED)
    // и может ссылаться на другое правило по имени. Ссылки могут образовывать циклы.

    //Пример цепочки:

    //"early_bird" → 10% скидка
    //"veteran" → ссылается на "early_bird" → затем ещё 5% (итого: 10% + 5%)
    //"double_vet" → ссылается на "veteran" → затем ещё 5%
    //"crazy" → ссылается на самого себя → затем 50% (цикл!)


    // Пример работы:
    // Правила:

    // List<DiscountRule> rules = List.of(
    //    new DiscountRule("early", PERCENT, 10, "veteran"),
    //    new DiscountRule("veteran", PERCENT, 5, null),
    //    new DiscountRule("student", FIXED, 50, "early")
    //);

    //// Цепочка для "student": student → early → veteran
    //// Результат: начальная сумма 1000 → -50 = 950 → -10% = 855 → -5% = 812.25

    //Вход:

    // calculateFinalAmount(rules, 1000.0, "student") // 812.25

    // Пример цикла:
    // List<DiscountRule> rules = List.of(
    //    new DiscountRule("a", PERCENT, 10, "b"),
    //    new DiscountRule("b", PERCENT, 5, "a")
    //);
    // calculateFinalAmount(rules, 1000, "a")

    //// Результат hasCycle = true

    // Твоя задача:
    // Написать метод, который принимает список правил и начальную сумму корзины, а возвращает итоговую сумму после применения всей цепочки.
    // Если обнаружен цикл — указать это в ответе, сумму можно не считать

    // Ограничение: Правила можно применять только в том порядке, который задан ссылками (своего рода "вычисление с мемоизацией").

    public enum DiscountType {
        PERCENT,   // уменьшает на процент от текущей суммы
        FIXED      // уменьшает на абсолютное значение (в рублях)
    }

    public static class DiscountRule {
        private String name;
        private DiscountType type;
        private double value;          // 15 для 15% или 200 для 200 руб
        private String nextRuleName;   // null если правило последнее

        public DiscountRule(String name, DiscountType type, double value, String nextRuleName) {
            this.name = name;
            this.type = type;
            this.value = value;
            this.nextRuleName = nextRuleName;
        }

        public String getName() {
            return name;
        }

        public DiscountType getType() {
            return type;
        }

        public double getValue() {
            return value;
        }

        public String getNextRuleName() {
            return nextRuleName;
        }
    }

    public static class ValidationResult {
        private boolean hasCycle;
        private double finalAmount;

        public ValidationResult(boolean hasCycle, double finalAmount) {
            this.hasCycle = hasCycle;
            this.finalAmount = finalAmount;
        }

        @Override
        public String toString() {
            return "ValidationResult{" +
                    "hasCycle=" + hasCycle +
                    ", finalAmount=" + finalAmount +
                    '}';
        }
    }

    public static class DiscountChainValidator {  //startRuleName - с какого промокода начинаем расчет
        //  П - процент
        //  формула: initialAmount *  П / 100
        //  Пример 10% от 1000: скидка = 1000 * 10 / 100 = 100

        public ValidationResult calculateFinalAmount(List<DiscountRule> rules, double initialAmount, String startRuleName) {
            // Создаем Map для быстрого поиска правил по имени

            Map<String, DiscountRule> nameRuleMap = new HashMap<>();
            for (DiscountRule rule : rules) {
                nameRuleMap.put(rule.getName(), rule);
            }
            //Создадим set для проверки цикла (true/false)
            Set<String> ruleSet = new HashSet<>();

            double currentAmount = initialAmount;
            String currentRuleName = startRuleName;

            while (currentRuleName != null && nameRuleMap.containsKey(currentRuleName)) {
                DiscountRule rule = nameRuleMap.get(currentRuleName);

                //добавим проверку на цикл
                if (ruleSet.contains(currentRuleName)) {
                    return new ValidationResult(true, 0.0);
                }
                ruleSet.add(currentRuleName);

                //далее проводим подсчет скидок
                if (rule.getType() == DiscountType.FIXED) {
                    currentAmount = currentAmount - rule.getValue();
                } else {
                    currentAmount = currentAmount - (currentAmount * rule.getValue() / 100);
                }
                currentRuleName = rule.getNextRuleName();
            }
            return new ValidationResult(false, currentAmount);
        }
    }
}
