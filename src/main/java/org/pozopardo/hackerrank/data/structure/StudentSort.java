package org.pozopardo.hackerrank.data.structure;

import java.util.*;

public class StudentSort {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while(testCases>0){
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        Collections.sort(studentList, (student1, student2) -> {
            if(student1.getCgpa() != student2.getCgpa())
                return Double.compare(student2.getCgpa(), student1.getCgpa());

            if(!student1.getFname().equalsIgnoreCase(student2.getFname()))
                return student1.getFname().compareTo(student2.getFname());

            return student1.getId() - student2.getId();
        });

        for(Student st: studentList){
            System.out.println(st.getFname());
        }
    }
}

class Student{
    private int id;
    private String fname;
    private double cgpa;
    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }
    public int getId() {
        return id;
    }
    public String getFname() {
        return fname;
    }
    public double getCgpa() {
        return cgpa;
    }
}
