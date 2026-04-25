public class EmployeeBook {
    private Employee[] employees = new Employee[10];
    private int size = 0;

    public void printAllEmployees() {
        System.out.println("=== Все сотрудники ===");
        for (Employee emp : employees) {
            if (emp != null) {
                System.out.println(emp);
            }
        }
    }

    //Средняя зарплата
    public double calculateAverageSalary() {
        if (size == 0) return 0;
        int totalSalary = 0;
        for (int i = 0; i < size; i++) {
            totalSalary += employees[i].getSalary();
        }
        return (double) totalSalary / size;
    }

    //налоги
    public void calculateTaxes(String taxType) {
        System.out.println("=== Налоги (" + taxType + ") ===");
        for (int i = 0; i < size; i++) {
            Employee emp = employees[i];
            if (emp == null) {
                break;
            }

            int tax;
            if ("PROPORTIONAL".equals(taxType)) {
                tax = emp.getSalary() * 13 / 100;
            } else { // PROGRESSIVE
                switch (emp.getSalary()) {
                    case 150:
                        tax = emp.getSalary() * 13 / 100;
                        break;
                    case 350:
                        tax = emp.getSalary() * 17 / 100;
                        break;
                    default:
                        if (emp.getSalary() < 150) {
                            tax = emp.getSalary() * 13 / 100;
                        } else if (emp.getSalary() < 350) {
                            tax = emp.getSalary() * 17 / 100;
                        } else {
                            tax = emp.getSalary() * 21 / 100;
                        }
                        break;
                }
            }
            System.out.printf("%s: налог = %d%n", emp.getFullName(), tax);
        }
    }

    //индексация
    public void indexSalary(int department, int percent) {
        System.out.printf("=== Индексация отдела %d на %d%% ===%n", department, percent);
        for (int i = 0; i < size; i++) {
            Employee emp = employees[i];
            if (emp == null) {
                break;
            }
            if (emp.getDepartment() == department) {
                int newSalary = emp.getSalary() * (100 + percent) / 100;
                emp.setSalary(newSalary);
                System.out.printf("Обновлена зарплата %s: %d -> %d%n",
                        emp.getFullName(), emp.getSalary(), newSalary);
            } else {
                continue;
            }
        }
    }

    //поиск первого сотрудника отдела с зп больше минимальной
    public void findEmployeeInDepartment(int department, int minSalary) {
        System.out.printf("=== Поиск в отделе %d с зарплатой > %d ===%n",
                department, minSalary);
        for (int i = 0; i < size; i++) {
            Employee emp = employees[i];
            if (emp == null) break;
            if (emp.getDepartment() == department && emp.getSalary() > minSalary) {
                System.out.printf("Позиция %d: ", i + 1);
                emp.printShortInfo();
                break;
            }
        }
    }

    //первые n сотрудников с зп меньше заданной
    public void findEmployeesLessSalary(int wage, int employeeNumber) {
        System.out.printf("=== Первые %d сотрудников с зарплатой < %d ===%n",
                employeeNumber, wage);
        int count = 0;
        int i = 0;
        while (i < size && count < employeeNumber) {
            Employee emp = employees[i];
            if (emp == null) break;
            if (emp.getSalary() < wage) {
                emp.printShortInfo();
                count++;
            }
            i++;
            if (count == employeeNumber) {
                break;
            }
        }
    }

    //сотрудник с такой же зп
    public boolean containsEmployee(Employee employee) {
        for (int i = 0; i < size; i++) {
            if (employees[i] != null && employees[i].equals(employee)) {
                return true;
            }
        }
        return false;
    }

    //добавление сотрудника
    public boolean addEmployee(Employee employee) {
        if (size >= employees.length) {
            System.out.println("Нет свободных мест!");
            return false;
        }
        employees[size] = employee;
        size++;
        System.out.println("Сотрудник успешно добавлен!");
        return true;
    }

    //поиск по id
    public Employee findById(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                return employees[i];
            }
        }
        return null;
    }
}
