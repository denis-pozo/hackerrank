package org.pozopardo.hackerrank.data.structure;

import java.util.*;

public class PriorityStudentList {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }

    }
}

class Priorities {
    List<Student> getStudents(List<String> events) {
        Queue<Student> priorityList = new PriorityQueue<>(
                events.size(),
                (student1, student2) -> {
                    if (student1.getCGPA() != student2.getCGPA()){
                        return Double.compare(student2.getCGPA(), student1.getCGPA());

                    }
                    if (!student1.getName().equals(student2.getName())) {
                        return student1.getName().compareTo(student2.getName());
                    }

                    return student1.getID() - student2.getID();
                });

        for (String event : events) {
            if (event.contains("ENTER")) {
                String[] student = event.split(" ");
                priorityList.add(new Student(
                        Integer.valueOf(student[3]),
                        student[1],
                        Double.valueOf(student[2])));
            } else if (event.contains("SERVED")) {
                priorityList.poll();

            }


        }

        List<Student> students = new ArrayList<>();
        int nStudents = priorityList.size();
        while (nStudents-- > 0) {
            students.add(priorityList.poll());
        }

        return students;
    }
}

