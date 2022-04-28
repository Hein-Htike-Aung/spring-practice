package com.example.module03onetoone;

import com.example.module03onetoone.com.hha.entity.BiographicalInfo;
import com.example.module03onetoone.com.hha.entity.Employee;
import com.example.module03onetoone.com.hha.service.BiographicalInfoService;
import com.example.module03onetoone.com.hha.service.EmployeeService;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Module03OneToOneApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private BiographicalInfoService biographicalInfoService;

    public static void main(String[] args) {
        SpringApplication.run(Module03OneToOneApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("\nSave Employee");
        employeeService.saveEmployee();


        System.out.println("\n Find Employee id = 2");
        Employee employee = employeeService.findById(2);
        System.out.println(employee.getName() + " : " + employee.getBiographicalInfo().getDateOfBirth() + " : " + employee.getPhone());

//        System.out.println("\nDelete Employee id = 2");
//        employeeService.deleteEmployee(2);

        System.out.println("\nDelete Biographical id = 2");
        biographicalInfoService.deleteBiographicalInfoById(2);

        System.out.println("\nFind from Employee");
        List<Employee> employeeList = employeeService.findAllEmployee();
        employeeList
                .stream()
                .map(e -> e.getName() + " : " +  e.getBiographicalInfo().getDateOfBirth() + " : " +  e.getPhone())
                .forEach(System.out::println);

        System.out.println("\nFind from Biographical Info");
        List<BiographicalInfo> biographicalInfoList = biographicalInfoService.findAllBioInfo();
        biographicalInfoList
                .stream()
                .map(b -> b.getEmployee().getName() + " : " +  b.getDateOfBirth() + " : " +  b.getEmployee().getPhone())
                .forEach(System.out::println);
    }
}
