
package Program;

import entities.Employee;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import static java.util.Locale.US;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;


public class Application {
    public static void main(String[] args) {
    
      Locale.setDefault(Locale.US);
      
      Scanner read = new Scanner(System.in);

      
        System.out.println("Entre com o caminho do arquivo :");
        String path = read.nextLine();
        
    try(BufferedReader br = new BufferedReader(new FileReader (path))){
    List<Employee> emp = new ArrayList<>();
    
    String line = br.readLine();
    while(line !=null){
    String[] camp =line.split(",");
    emp.add(new Employee(camp[0],camp[1],Double.parseDouble(camp[2])));
    line=br.readLine();
    
    }
        System.out.println("lista de funcionarios totais:");
        emp.forEach(System.out::println);
        System.out.print("valor do salario :");
        Double salary= read.nextDouble();
        
    //Comparator<String> campar = (emp1,emp2) -> emp1.compareTo(emp2);
    List<Employee> listEmp=emp.stream()
   .filter(p->p.getSalary()>salary)
   .sorted((p1,p2) ->p1.getEmail().compareTo(p2.getEmail()))
   .collect(Collectors.toList());
     System.out.println("Funcionario que recebe valor acima de :"+salary);
     listEmp.forEach(System.out::println);



     List<Employee> FuncM = emp.stream() //lista para funcionarios com letra M
    .filter(p->p.getName().startsWith("m"))
    .collect(Collectors.toList());

    Double sumSalary = FuncM.stream()
    .map(p->p.getSalary())
    .reduce(0.000,(x,y)-> x + y);

    FuncM.forEach(System.out::println);
   System.out.println("\n valor total do salario: "+String.format("%.3f",sumSalary));
    }   
    catch (IOException erro){
            System.out.print("Erro : " +erro.getMessage());
    }
    
    
    
    }
}
 