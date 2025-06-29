public class Main {
    public static void main(String[] args) {
        final String FIRST = "Первый   ";
        final String SECOND = "Второй   ";
        final String THIRD = "Третий   ";
        final String FOURTH = "Четвёртый";
        final String FIFTH = "Пятый    ";
        EmployeeBook companyBook = new EmployeeBook();
        if (!companyBook.addEntry("Дмитрий", "Вячеславович",
                "Феденистов", FIRST, 500_000))
            System.out.println("Книга переполнена, запись не добалена!");
        if (!companyBook.addEntry("Кирилл", "Иванович",
                "Петров", SECOND, 250_000))
            System.out.println("Книга переполнена, запись не добалена!");
        if (!companyBook.addEntry("Анатолий", "Юрьевич",
                "Зорин", SECOND, 200_000))
            System.out.println("Книга переполнена, запись не добалена!");
        if (!companyBook.addEntry("София", "Александровна",
                "Крымская", THIRD, 160_000))
            System.out.println("Книга переполнена, запись не добалена!");
        if (!companyBook.addEntry("Владимир", "Олегович",
                "Попов", FOURTH, 120_000))
            System.out.println("Книга переполнена, запись не добалена!");
        if (!companyBook.addEntry("Николай", "Александрович",
                "Козлов", FOURTH, 100_000))
            System.out.println("Книга переполнена, запись не добалена!");
        if (!companyBook.addEntry("Алексей", "Калинович",
                "Гудько", FIFTH, 80_000))
            System.out.println("Книга переполнена, запись не добалена!");
        if (!companyBook.addEntry("Александр", "Дмитриевич",
                "Сафронов", THIRD, 150_000))
            System.out.println("Книга переполнена, запись не добалена!");
        if (!companyBook.addEntry("Ольга", "Николаевна",
                "Грацкая", FIFTH, 75_000))
            System.out.println("Книга переполнена, запись не добалена!");
        if (!companyBook.addEntry("Пётр", "Григорьевич",
                "Фёдоров", FOURTH, 105_000))
            System.out.println("Книга переполнена, запись не добалена!");
        if (!companyBook.addEntry("Семён", "Семёнович", // Проверка ошибки записи в книгу
                "Семёнов", FOURTH, 110_000))
            System.out.println("Книга переполнена, запись не добалена!");

        System.out.println();
        System.out.print(companyBook);
        int id = 6;
        System.out.printf("%nУдалим сотрудника с id номером: %d%n", id);
        companyBook.removeEntryId(id);
        System.out.print(companyBook);
        System.out.printf("%nРасходы на зарплату в месяц - %dр%n",
                companyBook.calcSalaries());
        System.out.printf("Сотрудник с минимальной зарплатой:%n%s%s",
                companyBook.getCAP_FULL(),
                companyBook.findMinSalary());
        System.out.printf("Сотрудник с максимальной зарплатой:%n%s%s",
                companyBook.getCAP_FULL(),
                companyBook.findMaxSalary());
        System.out.printf("Средняя зарплата у сотрудников - %dр%n",
                companyBook.calcMeanSalary());
        System.out.printf("%nФИО сотрудников:%n");
        companyBook.printNameEmployees();
        int percent = 3;
        String department = FOURTH;
        int salary = 200_000;
        System.out.printf("%nИндексируем зарплату на %d%% %n", percent);
        companyBook.indexSalary(percent);
        System.out.print(companyBook);
        System.out.printf("%n%s отдел - с минимальной зарплатой: %n%s",
                department,
                companyBook.findMinSalaryDepartment(department));
        System.out.printf("%s отдел - с максимальной зарплатой: %n%s",
                department,
                companyBook.findMaxSalaryDepartment(department));
        System.out.printf("%s отдел - сумма    зарплат:   %s%n",
                department, companyBook.calcSalaryDepartment(department));
        System.out.printf("%s отдел - средняя зарплата:   %s%n",
                department, companyBook.calcMeanSalaryDepartment(department));
        percent = 5;
        System.out.printf("%nПроиндексируем %s отдел на %d%% %n", department, percent);
        companyBook.indexSalaryDepartment(department, percent);
        companyBook.printEmployeeDepartment(department);
        System.out.printf("%nСотрудники, чья зарплата меньше %dр:%n", salary);
        companyBook.printLessSalary(salary);
        System.out.printf("%nСотрудники, чья зарплата больше %dр:%n", salary);
        companyBook.printMoresSalary(salary);
        id = 9;
        System.out.printf("%nСотрудник с ID = %d :%n%s%s",
                id,
                companyBook.getCAP_FULL(),
                companyBook.findEmployeeById(id));
    }
}