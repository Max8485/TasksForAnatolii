package org.example.springproject.livecode.tasks.Anatolii;

import java.util.*;
import java.util.stream.Collectors;

public class FindEmployeer {
    //Найти отдел с самым высоким «коэффициентом эффективности».
    //Коэффициент эффективности отдела вычисляется по формуле:
    //эффективность = (средняя зарплата по отделу) / (средний возраст по отделу)

    //////thenComparing - использовать для сортировки (где их несколько)//////

    //Если два отдела имеют одинаковый коэффициент, выбрать тот, у которого выше суммарная зарплата.
    //Если и это одинаково — выбрать отдел с меньшим id.

    //Дополнительное требование:
    //Отделы, в которых работает меньше 3 сотрудников, исключаются из рассмотрения.

    //Формат вывода:
    //Метод должен вернуть объект Department (или null, если подходящих отделов нет).


    //1. Создать мапу со всеми департаментами и всеми сотрудниками

    //  Далее посчитать среднюю ЗП и средний возраст

    //  avaregeSalarey -  ЗП всех сотрудников одного департамента / количество сотрудников

    //  avarageAge - сумма возрастов всех сотрудников / количество сотрудников

    //  Отделы, в которых работает меньше 3 сотрудников, исключаются из рассмотрения.

    //2. Посчитать эффективность (коэффициент) = (средняя зарплата по отделу) / (средний возраст по отделу)

    //3. Если два отдела имеют одинаковый коэффициент, выбрать тот, у которого выше суммарная зарплата.
    //   Если и это одинаково — выбрать отдел с меньшим id.

    //Найти отдел с самым высоким «коэффициентом эффективности».

    public static void main(String[] args) {
        FindEmployeer findEmployeer = new FindEmployeer();

        Department department1 = new Department(1, "JavaDepart");
        Department department2 = new Department(2, "PythonDepart");
        Department department3 = new Department(3, "GoDepart");
        List<Department> departmentList = new ArrayList<>();
        departmentList.add(department1);
        departmentList.add(department2);
        departmentList.add(department3);


        Employee employee1 = new Employee(1, "Вася", 1, 100000, 20);
        Employee employee2 = new Employee(2, "Петя", 1, 120000, 22);
        Employee employee3 = new Employee(3, "Андрей", 2, 150000, 30);
        Employee employee4 = new Employee(4, "Илья", 2, 110000, 29);
        Employee employee5 = new Employee(5, "Виктор", 1, 200000, 26);
        Employee employee6 = new Employee(6, "Мария", 1, 90000, 24);
        Employee employee7 = new Employee(7, "Варя", 1, 170000, 32);
        Employee employee8 = new Employee(8, "Ирина", 3, 160000, 35);
        Employee employee9 = new Employee(9, "Петр", 3, 80000, 32);
        Employee employee10 = new Employee(10, "Станислав", 3, 135000, 40);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        employeeList.add(employee4);
        employeeList.add(employee5);
        employeeList.add(employee6);
        employeeList.add(employee7);
        employeeList.add(employee8);
        employeeList.add(employee9);
        employeeList.add(employee10);

        System.out.println("Отдел с самым высоким «коэффициентом эффективности: " + findEmployeer.bestDepartment(departmentList, employeeList));
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("Средняя зарплата: " + findEmployeer.averageSalary(employeeList));
        System.out.println("Средний возраст: " + findEmployeer.averageAge(employeeList));
        System.out.println("Эффективность: " + findEmployeer.effect(employeeList));
    }

    private Map<Integer, Double> averageSalary(List<Employee> employeeList) { // ЗП всех сотрудников одного департамента / количество сотрудников
        return employeeList.stream()
                .collect(Collectors.groupingBy(
                        e -> e.departmentId, Collectors.averagingInt(e -> e.salary)
                ));
    }

    private Map<Integer, Double> averageAge(List<Employee> employeeList) { //сумма возрастов всех сотрудников / количество сотрудников
        return employeeList.stream()
                .collect(Collectors.groupingBy(
                        e -> e.departmentId, Collectors.averagingInt(e -> e.age)
                ));
    }

    private Map<Integer, Double> effect(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        e -> e.departmentId,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream().mapToInt(e -> e.salary).average().orElse(0) /
                                        list.stream().mapToInt(e -> e.age).average().orElse(1)
                        )
                ));
    }

    //Метод должен вернуть объект Department (или null, если подходящих отделов нет).
    public Department bestDepartment(List<Department> departmentList, List<Employee> employeeList) {

        //Создать мапу - все depart.id - key// все emloyees - value
        Map<Integer, List<Employee>> departEmployee = new HashMap<>();

        //  Добавляем все отделы с пустыми списками
        for (Department depart : departmentList) {
            departEmployee.put(depart.id, new ArrayList<>());
        }

        //  Заполнить каждый отдел сотрудниками
        for (Employee employee : employeeList) {
            int departmentId = employee.departmentId;

            if (departEmployee.containsKey(departmentId)) {
                departEmployee.get(departmentId).add(employee); //Теперь у нас есть мапа со всеми департаментами и всеми сотрудниками
            }
        }

        //считаем эффективность
        int bestDepartId = departEmployee.entrySet().stream()
                .filter(entry -> entry.getValue().size() >= 3) //отделы, в которых работает меньше 3 сотрудников, исключаются из рассмотрения.
                .max(Comparator.comparing((Map.Entry<Integer, List<Employee>> entry) -> {
                    List<Employee> employees = entry.getValue();
                            double averageSal = employees.stream().mapToInt(e -> e.salary).average().orElse(0); // средняя ЗП
                            double averageAge = employees.stream().mapToInt(e -> e.age).average().orElse(1); // средний возраст
                            return averageSal / averageAge;  //эффективность
                                })
                                .thenComparing(entry -> entry.getValue().stream().mapToInt(e -> e.salary).sum()) //если одинаковый коэффициент
                                .thenComparing((d1, d2) -> Integer.compare(d2.getKey(), d1.getKey())) //Если и это одинаково — выбрать отдел с меньшим id.
                )
                .map(Map.Entry::getKey)
                .orElse(0);

        return departmentList.stream() //возвращаем объект Department
                .filter(d -> d.id == bestDepartId)
                .findFirst()
                .orElse(null);
    }

    static class Department {
        int id;          // ID отдела
        String name;     // Название отдела

        public Department(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Department{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    static class Employee {
        int id;             // ID сотрудника
        String name;        // Имя сотрудника
        int departmentId;   // ID отдела, в котором работает
        int salary;         // Зарплата
        int age;            // Возраст

        public Employee(int id, String name, int departmentId, int salary, int age) {
            this.id = id;
            this.name = name;
            this.departmentId = departmentId;
            this.salary = salary;
            this.age = age;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(int departmentId) {
            this.departmentId = departmentId;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", departmentId=" + departmentId +
                    ", salary=" + salary +
                    ", age=" + age +
                    '}';
        }
    }
}
