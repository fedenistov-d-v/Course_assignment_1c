public class Main {

    public static void printNameEmployees(Employee[] list) {
        for (final Employee employee : list) {
            if (employee == null) break;
            System.out.printf("%s %s %s%n",
                    employee.getLastName(),
                    employee.getFirstName(),
                    employee.getMiddleName());
        }
    }

    public static int calcMeanSalary(Employee[] list) {
        return calcSalaryMonthly(list) / list.length;
    }

    public static int calcMeanSalaryDepartment(Employee[] list, String department) {
        int sum = 0;
        int count = 0;
        for (final Employee employee : list) {
            if (employee == null) break;
            if (employee.getDepartment().equals(department)) {
                sum += employee.getSalary();
                count++;
            }
        }
        return sum / count;
    }

    public static Employee findMaxSalary(Employee[] list) {
        Employee maxSalary = list[0];
        for (int i = 1; i < list.length; i++) {
            if (list[i] == null) break;
            if (list[i].getSalary() > maxSalary.getSalary()) maxSalary = list[i];
        }
        return maxSalary;
    }

    public static Employee findMaxSalaryDepartment(Employee[] list, String department) {
        Employee maxSalary = null;
        int max = -1;
        for (Employee employee : list) {
            if (employee == null) break;
            if (employee.getDepartment().equals(department) && employee.getSalary() > max) {
                maxSalary = employee;
                max = maxSalary.getSalary();
            }
        }
        return maxSalary;
    }

    public static Employee findMinSalary(Employee[] list) {
        Employee minSalary = list[0];
        for (int i = 1; i < list.length; i++) {
            if (list[i] == null) break;
            if (list[i].getSalary() < minSalary.getSalary()) minSalary = list[i];
        }
        return minSalary;
    }

    public static Employee findMinSalaryDepartment(Employee[] list, String department) {
        Employee minSalary = null;
        int min = 1_000_000_000;
        for (Employee employee : list) {
            if (employee == null) break;
            if (employee.getDepartment().equals(department) && employee.getSalary() < min) {
                minSalary = employee;
                min = minSalary.getSalary();
            }
        }
        return minSalary;
    }

    public static int calcSalaryMonthly(Employee[] list) {
        int sum = 0;
        for (final Employee employee : list) {
            if (employee == null) break;
            sum += employee.getSalary();
        }
        return sum;
    }

    public static int calcSalaryDepartment(Employee[] list, String department) {
        int sum = 0;
        for (final Employee employee : list) {
            if (employee == null) break;
            if (employee.getDepartment().equals(department)) sum += employee.getSalary();
        }
        return sum;
    }

    public static void printEmployeeList(Employee[] list) {
        for (final Employee employee : list) {
            if (employee == null) break;
            System.out.println(employee);
        }
    }

    public static void indexSalaryDepartment(Employee[] list, String department, int percent) {
        for (final Employee employee : list) {
            if (employee == null) break;
            if (employee.getDepartment().equals(department)) {
                employee.setSalary((int) (employee.getSalary() * (1 + (double) percent / 100)));
            }
        }
    }

    public static void indexSalary(Employee[] list, int percent) {
        for (final Employee employee : list) {
            if (employee == null) break;
            employee.setSalary((int) (employee.getSalary() * (1 + (double) percent / 100)));
        }
    }

    public static void printEmployeeDepartment(Employee[] list, String department) {
        for (final Employee employee : list) {
            if (employee == null) break;
            if (employee.getDepartment().equals(department)) {
                System.out.printf("%d %s %s %s зарплата - %d%n",
                        employee.getId(),
                        employee.getLastName(),
                        employee.getFirstName(),
                        employee.getMiddleName(),
                        employee.getSalary());
            }
        }
    }

    public static void printLessSalary(Employee[] list, int salary) {
        for (final Employee employee : list) {
            if (employee == null) break;
            if (salary > employee.getSalary()) {
                System.out.printf("%d %s %s %s зарплата - %d%n",
                        employee.getId(),
                        employee.getLastName(),
                        employee.getFirstName(),
                        employee.getMiddleName(),
                        employee.getSalary());
            }
        }
    }

    public static void printMoresSalary(Employee[] list, int salary) {
        for (final Employee employee : list) {
            if (employee == null) break;
            if (salary <= employee.getSalary()) {
                System.out.printf("%d %s %s %s зарплата - %d%n",
                        employee.getId(),
                        employee.getLastName(),
                        employee.getFirstName(),
                        employee.getMiddleName(),
                        employee.getSalary());
            }
        }
    }

    public static void main(String[] args) {
        Employee[] employeeList = new Employee[10];
        employeeList[0] = new Employee("Дмитрий", "Вячеславович",
                "Феденистов", "Первый", 500_000);
        employeeList[1] = new Employee("Кирилл", "Иванович",
                "Петров", "Второй", 250_000);
        employeeList[2] = new Employee("Анатолий", "Юрьевич",
                "Зорин", "Второй", 200_000);
        employeeList[3] = new Employee("София", "Александровна",
                "Крымская", "Третий", 160_000);
        employeeList[4] = new Employee("Владимир", "Олегович",
                "Попов", "Четвёртый", 120_000);
        employeeList[5] = new Employee("Николай", "Александрович",
                "Козлов", "Четвёртый", 100_000);
        employeeList[6] = new Employee("Алексей", "Калинович",
                "Гудько", "Пятый", 80_000);
        employeeList[7] = new Employee("Александр", "Дмитриевич",
                "Сафронов", "Третий", 150_000);
        employeeList[8] = new Employee("Ольга", "Николаевна",
                "Грацкая", "Пятый", 75_000);
        employeeList[9] = new Employee("Пётр", "Григорьевич",
                "Фёдоров", "Четвёртый", 105_000);

        printEmployeeList(employeeList);
        System.out.printf("%nРасходы на зарплату в месяц - %dр%n", calcSalaryMonthly(employeeList));
        System.out.printf("%nСотрудник с минимальной зарплатой:%n%s%n", findMinSalary(employeeList));
        System.out.printf("%nСотрудник с максимальной зарплатой:%n%s%n", findMaxSalary(employeeList));
        System.out.printf("%nСотрудник с максимальной зарплатой:%n%s%n", findMaxSalary(employeeList));
        System.out.printf("%nСредняя зарплата у сотрудников - %dр%n", calcMeanSalary(employeeList));
        System.out.printf("%nФИО сотрудников:%n");
        printNameEmployees(employeeList);
        int percent = 3;
        String department = "Четвёртый";
        int salary = 200_000;
        System.out.printf("Индексируем зарплату на %d%% %n", percent);
        indexSalary(employeeList, percent);
        printEmployeeList(employeeList);
        System.out.printf("%s отдел - с минимальной зарплатой: %s%n",
                department, findMinSalaryDepartment(employeeList, department));
        System.out.printf("%s отдел - с максимальной зарплатой: %s%n",
                department, findMaxSalaryDepartment(employeeList, department));
        System.out.printf("%s отдел - сумма    зарплат:   %s%n",
                department, calcSalaryDepartment(employeeList, department));
        System.out.printf("%s отдел - средняя зарплата:   %s%n",
                department, calcMeanSalaryDepartment(employeeList, department));
        percent = 5;
        System.out.printf("Проиндексируем %s отдел на %d%% %n", department, percent);
        indexSalaryDepartment(employeeList, department, percent);
        System.out.printf("%s отдел:%n", department);
        printEmployeeDepartment(employeeList, department);
        System.out.printf("%nСотрудники, чья зарплата меньше %dр:%n", salary);
        printLessSalary(employeeList, salary);
        System.out.printf("%nСотрудники, чья зарплата больше %dр:%n", salary);
        printMoresSalary(employeeList, salary);

    }
}