public class DashboardFinal {
    /*
     * Employee Management Dashboard
     * Develop a dashboard to analyze and display various statistics based on employee data.
     * Each employee is associated with a name, salary, and department.
     * The dashboard should provide the following information:
     * 1- Number of employees in each department. [Done]
     * 2- Total number of employees in the company. (-----Company------) [Done]
     * 3- Total salaries of all employees. (-----Company------) [Done]
     * 4- Total salaries in each department.[Done]
     * 5- The highest and lowest salaries in the company.(-----Company------) [Done]
     * 6- The highest and lowest salaries in each department.[Done]
     */

    public static void main(String[] args) {
        String[] employeeNames = {"Alice", "Bob", "Charlie", "Diana", "Edward", "Fiona", "Ahmed", "Michael", "Janice", "John", "Greg", "Perla"};
        int[] employeeSalaries = {5000, 7000, 8000, 6000, 7500, 8200, 15000, 13500, 9200, 12000, 80000, 28000};
        String[] employeeDepartments = {"HR", "IT", "IT", "HR", "Finance", "Finance", "Marketing", "Marketing", "Sales", "Sales", "Localization", "Localization"};


        System.out.print("\nCompany Departments: ");
        String[] companyDepartments = getcompanyDepartments(employeeDepartments);
        for (int i = 0; i < companyDepartments.length; i++) {
            System.out.print(companyDepartments[i]);

            if (i < companyDepartments.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("\n");
        employeesPerdepartment(companyDepartments, employeeDepartments);
        System.out.println("\nTotal number of company employees: " + numberOfEmployees(employeeNames));
        System.out.println("Total salaries of all employees: " + totalCompanySalaries(employeeSalaries));


        System.out.println("\n\nCompany highest and lowest Salaries");
        highestAndLowestSalary(employeeSalaries);
        gettingHighestAndLowestSalaryPerDepartment(companyDepartments, employeeSalaries, employeeDepartments);
        System.out.println();
        totalSalariesPerDepartment(companyDepartments, employeeSalaries, employeeDepartments);


    }

    //Calculating Salaries Per Department
    static void totalSalariesPerDepartment(String[] companyDepartments, int[] salaries, String[] employeesDepartrments) {


        for (int i = 0; i < companyDepartments.length; i++) {
            int amount = 0;
            for (int j = 0; j < employeesDepartrments.length; j++)
                if (companyDepartments[i].equals(employeesDepartrments[j]))
                    amount += salaries[j];

            System.out.println("Total Salary in " + companyDepartments[i] + " is: " + amount);
        }
    }

    //Calculating Highest and lowest
    static void highestAndLowestSalary(int[] salaries) {
        int highestSalary = salaries[0];
        int lowestSalary = salaries[0];
        for (int i = 1; i < salaries.length; i++)
            if (highestSalary < salaries[i])
                highestSalary = salaries[i];

        for (int i = 1; i < salaries.length; i++)
            if (lowestSalary > salaries[i])
                lowestSalary = salaries[i];

        int[] highestAndlowest = {highestSalary, lowestSalary};

        for (int i = 0; i < 2; i++) {
            System.out.println("Highest Salary: " + highestAndlowest[i]);
            i++;
            System.out.println("Lowest Salary: " + highestAndlowest[i]);
        }


    }


    //Calculating Number of Employees
    static int numberOfEmployees(String[] employees) {
        return employees.length;
    }

    //Calculating Total paid Salaries for all employees
    static int totalCompanySalaries(int[] totalSalaries) {
        int salary = 0;

        for (int i = 0; i < totalSalaries.length; i++) {
            salary += totalSalaries[i];
        }
        return salary;
    }


    //Number of employees in each department
    static void employeesPerdepartment(String[] companydepartments, String[] mployeeDepartments) {
        for (int i = 0; i < companydepartments.length; i++) {
            int count = 0;

            for (int j = 0; j < mployeeDepartments.length; j++)
                if (companydepartments[i].equals(mployeeDepartments[j]))
                    count++;

            System.out.println("Total employees in " + companydepartments[i] + ":" + count);
        }

    }


    //Getting Company Departments method
    static String[] getcompanyDepartments(String[] emplyeeDepartments) {
        int currentIndex = 0;
        String[] dummyDepartments = new String[emplyeeDepartments.length];
        for (int i = 0; i < emplyeeDepartments.length; i++) {
            boolean isExist = false;
            for (int j = 0; j < dummyDepartments.length; j++) {
                if (emplyeeDepartments[i].equals(dummyDepartments[j])) {
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                dummyDepartments[currentIndex] = emplyeeDepartments[i];
                currentIndex++;
            }
        }

        String[] result = new String[currentIndex];

        for (int i = 0; i < currentIndex; i++) {
            result[i] = dummyDepartments[i];
        }

        return result;
    }

    //Highest and Lowest Salary per Department
    static void gettingHighestAndLowestSalaryPerDepartment(String[] companyDepartments, int[] employeeSalaries, String[] employeeDepartments) {
        for (int i = 0; i < companyDepartments.length; i++) {
            int highestSalary = Integer.MIN_VALUE;
            int lowestSalary = Integer.MAX_VALUE;
            for (int j = 0; j < employeeDepartments.length; j++)

                if (companyDepartments[i].equals(employeeDepartments[j])) {

                    if (employeeSalaries[j] > highestSalary)
                        highestSalary = employeeSalaries[j];

                    if (employeeSalaries[j] < lowestSalary)
                        lowestSalary = employeeSalaries[j];
                }

            /*int highestSalary = -1;
            int lowestSalary = 0;
            for (int j = 0; j < employeeDepartments.length; j++)
                if (companyDepartments[i].equals(employeeDepartments[j])) {

                    if (employeeSalaries[j] > highestSalary) {
                        lowestSalary = highestSalary;
                        highestSalary = employeeSalaries[j];
                    } else {
                        lowestSalary = employeeSalaries[j];
                    }
                }*/
            System.out.println("\nHighest Salary in " + companyDepartments[i] + " is: " + highestSalary);
            System.out.println("lowest Salary in " + companyDepartments[i] + " is: " + lowestSalary);
        }


    }


}









