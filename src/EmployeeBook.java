import java.util.Arrays;
import java.util.Objects;

public class EmployeeBook {
    private final Employee[] entries;
    private final String CAP_FULL = "id Отдел    Зарплата        ФИО" + '\n';

    public EmployeeBook() {
        this.entries = new Employee[10];
    }

    public String getCAP_FULL() {
        return CAP_FULL;
    }

    public boolean addEntry(String fistName,
                            String middleName,
                            String lastName,
                            String department,
                            int salary) {
        Employee newEntry = null;
        for (int i = 0; i < entries.length; i++) {
            if (entries[i] == null) {
                newEntry = new Employee(fistName, middleName, lastName, department, salary);
                entries[i] = newEntry;
                break;
            }
        }
        return newEntry != null;
    }

    public void removeEntryId(int id) {
        for (int i = 0; i < entries.length; i++) {
            if (entries[i] != null && entries[i].getId() == id) entries[i] = null;
        }
    }

    public int calcSalaries() {
        int sum = 0;
        for (final Employee employee : entries) {
            if (employee != null) sum += employee.getSalary();
        }
        return sum;
    }

    public int calcMeanSalary() {
        int sum = 0;
        int count = 0;
        for (final Employee employee : entries) {
            if (employee != null) {
                sum += employee.getSalary();
                count++;
            }
        }
        return sum / count;
    }

    public int calcSalaryDepartment(String department) {
        int sum = 0;
        for (final Employee employee : entries) {
            if (employee != null &&
                    employee.getDepartment().equals(department))
                sum += employee.getSalary();
        }
        return sum;
    }

    public int calcMeanSalaryDepartment(String department) {
        int sum = 0;
        int count = 0;
        for (final Employee employee : entries) {
            if (employee != null &&
                    employee.getDepartment().equals(department)) {
                sum += employee.getSalary();
                count++;
            }
        }
        return sum / count;
    }

    public Employee findMinSalary() {
        Employee minSalary = this.entries[0];
        for (int i = 1; i < entries.length; i++) {
            if (entries[i] != null &&
                    entries[i].getSalary() < minSalary.getSalary())
                minSalary = entries[i];
        }
        return minSalary;
    }

    public Employee findMaxSalary() {
        Employee maxSalary = entries[0];
        for (int i = 1; i < entries.length; i++) {
            if (entries[i] != null &&
                    entries[i].getSalary() > maxSalary.getSalary())
                maxSalary = entries[i];
        }
        return maxSalary;
    }

    public Employee findMinSalaryDepartment(String department) {
        Employee minSalary = null;
        int min = 1_000_000_000;
        for (Employee employee : entries) {
            if (employee != null &&
                    employee.getDepartment().equals(department) &&
                    employee.getSalary() < min) {
                minSalary = employee;
                min = minSalary.getSalary();
            }
        }
        return minSalary;
    }

    public Employee findMaxSalaryDepartment(String department) {
        Employee maxSalary = null;
        int max = -1;
        for (Employee employee : entries) {
            if (employee != null &&
                    employee.getDepartment().equals(department) &&
                    employee.getSalary() > max) {
                maxSalary = employee;
                max = maxSalary.getSalary();
            }
        }
        return maxSalary;
    }

    public Employee findEmployeeById(int id) {
        Employee employee = null;
        for (Employee entry : entries) {
            if (entry != null &&
                    entry.getId() == id)
                employee = entry;
        }
        return employee;
    }

    public void indexSalary(int percent) {
        for (final Employee employee : entries) {
            if (employee != null)
                employee.setSalary((int) (employee.getSalary() * (1 + (double) percent / 100)));
        }
    }

    public void indexSalaryDepartment(String department, int percent) {
        for (final Employee employee : entries) {
            if (employee != null &&
                    employee.getDepartment().equals(department)) {
                employee.setSalary((int) (employee.getSalary() * (1 + (double) percent / 100)));
            }
        }
    }

    public void printNameEmployees() {
        for (final Employee employee : entries) {
            if (employee != null)
                System.out.printf("%s %s %s%n",
                        employee.getLastName(),
                        employee.getFirstName(),
                        employee.getMiddleName());
        }
    }

    public void printEmployeeDepartment(String department) {
        for (final Employee employee : entries) {
            if (employee != null &&
                    employee.getDepartment().equals(department)) {
                System.out.printf("%2d %s %s %s зарплата - %d%n",
                        employee.getId(),
                        employee.getLastName(),
                        employee.getFirstName(),
                        employee.getMiddleName(),
                        employee.getSalary());
            }
        }
    }

    public void printLessSalary(int salary) {
        for (final Employee employee : entries) {
            if (employee != null &&
                    salary > employee.getSalary()) {
                System.out.printf("%2d %s %s %s зарплата - %d%n",
                        employee.getId(),
                        employee.getLastName(),
                        employee.getFirstName(),
                        employee.getMiddleName(),
                        employee.getSalary());
            }
        }
    }

    public void printMoresSalary(int salary) {
        for (final Employee employee : entries) {
            if (employee != null &&
                    salary <= employee.getSalary()) {
                System.out.printf("%d %s %s %s зарплата - %d%n",
                        employee.getId(),
                        employee.getLastName(),
                        employee.getFirstName(),
                        employee.getMiddleName(),
                        employee.getSalary());
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder printBook = new StringBuilder(CAP_FULL);
        for (final Employee employee : this.entries) {
            if (employee != null) printBook.append(employee);
        }
        return printBook.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeBook that = (EmployeeBook) o;
        return Objects.deepEquals(entries, that.entries);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(entries);
    }
}