public class Main {
    public static void main(String[] args) {
        EmployeeBook book = new EmployeeBook();

        book.addEmployee(new Employee("Иванов И.И.", 1, 100));
        book.addEmployee(new Employee("Петров П.П.", 2, 200));
        book.addEmployee(new Employee("Сидоров С.С.", 1, 120));
        book.addEmployee(new Employee("Козлов К.К.", 3, 300));
        book.addEmployee(new Employee("Смирнова А.А.", 1, 80));
        book.addEmployee(new Employee("Васильев В.В.", 4, 400));
        book.addEmployee(new Employee("Попова О.О.", 2, 250));
        book.addEmployee(new Employee("Морозов М.М.", 5, 350));
        book.addEmployee(new Employee("Новиков Н.Н.", 1, 140));
        book.addEmployee(new Employee("Федорова Е.Е.", 3, 180));
        book.addEmployee(new Employee("Дмитриев Д.Д.", 2, 220));

        book.printAllEmployees();
        System.out.printf("Средняя зарплата: %.2f%n", book.calculateAverageSalary());

        book.calculateTaxes("PROPORTIONAL");
        book.calculateTaxes("PROGRESSIVE");

        book.indexSalary(1, 10); // Индексация отдела 1 на 10%
        book.printAllEmployees();

        book.findEmployeeInDepartment(1, 100);
        book.findEmployeesLessSalary(200, 3);

        Employee testEmp = new Employee("Тест", 1, 100);
        System.out.printf("Содержит сотрудника с зарплатой 100: %b%n",
                book.containsEmployee(testEmp));

        Employee found = book.findById(3);
        if (found != null) {
            System.out.println("Найден по ID 3: " + found);
        }
    }
}