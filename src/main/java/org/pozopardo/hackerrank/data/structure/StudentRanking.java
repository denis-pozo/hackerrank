package org.pozopardo.hackerrank.data.structure;

import java.util.*;

public class StudentRanking {

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
            if(student1.getCGPA() != student2.getCGPA())
                return Double.compare(student2.getCGPA(), student1.getCGPA());

            if(!student1.getName().equalsIgnoreCase(student2.getName()))
                return student1.getName().compareTo(student2.getName());

            return student1.getID() - student2.getID();
        });

        for(Student st: studentList){
            System.out.println(st.getName());
        }
    }
}

