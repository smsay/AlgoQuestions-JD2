package main.java.week_19_sorting_methodReference_stream.lambda_sort_doublecolon_tasks;

import java.util.List;

import static week_19_sorting_methodReference_stream.lambda_sort_doublecolon_tasks.DataGenerator.*;
import static week_19_sorting_methodReference_stream.lambda_sort_doublecolon_tasks.Service.filter;
import static week_19_sorting_methodReference_stream.lambda_sort_doublecolon_tasks.Service.getAllEmployees;


public class PracticeTasks {
    public static void main(String[] args) {
        createAllAddresses();
        createAllCompanies();
        createAllEmployees();

        //When you start to solve new question, comment out the System.out.println statement


        //EXAMPLE
        //       System.out.println("*** get all employees if their Id number is odd");
        System.out.println("*************** solution with behavior parameterization ****************");
        List<Employee> list = filter(getAllEmployees(), employee -> employee.getId() % 2 != 0);
        list.forEach(System.out::println);

        System.out.println("*************** solution with collection forEach() method **************");
        getAllEmployees().forEach(employee -> {
            if (employee.getId() % 2 != 0) {
                System.out.println(employee);
            }
        });

        System.out.println("*************** solution with stream **************");
        getAllEmployees().stream()
                .filter(employee -> employee.getId() % 2 != 0)
                .forEach(System.out::println);


        //System.out.println("*** get all employees if their Id number is even");


        //System.out.println("*** get all employees if they are older than 50");


        //System.out.println("*** get all employees whose company name info starts with A or a");


        //System.out.println("*** get all employees their company is located in Utah, Indiana or California as a state ");


        //System.out.println(" show all the employees full name and corresponding age information in one list");


        //System.out.println("*** get just the fullName of all employees if their Id number is even");


        //System.out.println("***just print the employees if their address id is 6");


        //System.out.println("***SORTING QUESTIONS***");

        //System.out.println("sort all employees with age in ascending order");


        //System.out.println("sort all employees with age in descending order");


        //System.out.println("*** sort all employees with full name in ascending order and print only their full names ***");


        //System.out.println("*** sort all employees with full name in descending order and print only their full names ***");


        //System.out.println("***sort all employees with company name in ascending order***");


        //System.out.println("***sort all employees with company name in descending order***");


        //System.out.println("sort all employees with company id in ascending order");


    }
}
