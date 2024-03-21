package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;


public class App 
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Config.xml");
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
//        Student student = new Student(2324,"Sahil","Surat");
//        int r = studentDao.insert(student);
//        System.out.println("Done"+r);
        
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        boolean go =true;
        while(go) {
        System.out.println("PRESS 1 for add new student");
        System.out.println("PRESS 2 for display all student");
        System.out.println("PRESS 3 for get detail of single student");
        System.out.println("PRESS 4 for delete student");
        System.out.println("PRESS 5 for update student");
        System.out.println("PRESS 6 for exit");
        
        try {
        	int input = Integer.parseInt(br.readLine());
        	
        	switch (input) {
        	case 1:
        		//add a new student
        		//taking inputs from users
        		System.out.println("Enter user Id:");
        		int uId=Integer.parseInt(br.readLine());
        		
        		System.out.println("Enter user name:");
        		String uName=br.readLine();
        		
        		System.out.println("Enter user city:");
        		String uCity=br.readLine();
        		
        		//creating student object and setting values
        		Student s=new Student();
        		s.setStudentId(uId);
        		s.setStudentName(uName);
        		s.setStudentCity(uCity);
        		
        		//saving student object to databases by calling insert of studentDao
        		int r = studentDao.insert(s);
        		System.out.println(r+"Student added");
        		System.out.println("***************************");
        		System.out.println();
        		break;
        		 
        	case 2:
        		//display all student
        		List<Student> allStudents = studentDao.getAllStudents();
        		for(Student st:allStudents)
        		{   
        			System.out.println("ID:"+st.getStudentId());
        			System.out.println("Name:"+st.getStudentName());
        			System.out.println("City:"+st.getStudentCity());
        			System.out.println("--------------------------------");
        		}
        		break;
        		
        	case 3:
        		//get single student data
        		System.out.println("Enter user Id:");
        		int userId=Integer.parseInt(br.readLine());
                Student student = studentDao.getStudent(userId);
                System.out.println("ID:"+student.getStudentId());
    			System.out.println("Name:"+student.getStudentName());
    			System.out.println("City:"+student.getStudentCity());
    			System.out.println("--------------------------------");
        		break;
        		
        	case 4:
        		//delete student
        		System.out.println("Enter user Id:");
        		int id=Integer.parseInt(br.readLine());
        		studentDao.deleteStudent(id);
        		System.out.println("Student deleted...");
        		break;
        		
        	case 5:
        		//update the student
        		System.out.println("Enter user Id:");
        		int Id=Integer.parseInt(br.readLine());
        		
        		System.out.println("Enter user name:");
        		String Name=br.readLine();
        		
        		System.out.println("Enter user city:");
        		String City=br.readLine();
        		
        		//creating student object and setting values
        		Student t=new Student();
        		t.setStudentId(Id);
        		t.setStudentName(Name);
        		t.setStudentCity(City);
        		
        		studentDao.updateStudent(t);
        		System.out.println("Data updated...");
        		break;
        		
        	case 6:
        		//exit
        		go = false;
        		break;
        		
        	}
        	
        } catch(Exception e) {
        	System.out.println("Innvalid imput try with another one !!");
        	System.out.println("e.getMessage");
        }
        
        }
       System.out.println("Thankyou for using my application");
       System.out.println("See you soon");
    }
   
}
