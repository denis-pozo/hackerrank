package org.pozopardo.iplytics.proman.data;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

/**
 * This class loads the data from external forma  of a csv file. Given a certain class, it extracts
 * the data from the csv file, proofs their validity and returns a list of the
 * parsed objects.
 */
public class DataLoader {

    public static final String DATA_PATH = "src/test/resources/data/";
    private static final String EMPLOYEES_FILE = "employees.csv";
    private static final String PROJECTS_FILE = "projects.csv";
    private static final String TASKS_FILE = "tasks.csv";


    public Set<List<String>> loadData(String fileName) throws IOException {
        Reader in = new FileReader(DATA_PATH + fileName);
        Iterable<CSVRecord> records = CSVFormat.DEFAULT
                                                .withFirstRecordAsHeader()
                                                .parse(in);

        Set<List<String>> processedRecords = processRecords(records);
        in.close();
        return processedRecords;
    }

    private Set<List<String>> processRecords(Iterable<CSVRecord> records) {
        Set<List<String>> loadedValues = new LinkedHashSet<>();

        for(CSVRecord record : records) {
            List<String> values = new ArrayList<>();
            for(int i = 0 ; i < record.size() ; i++) {
                values.add(record.get(i));
            }
            loadedValues.add(values);
        }
        return loadedValues;
    }

//        Set<String> supervisors = new HashSet<>();
//
//        for(CSVRecord record : getRecords(FILE_NAME)) {
//            String firstName = record.get("firstName");
//            String lastName = record.get("lastName");
//            String supervisor = record.get("supervisor");
//            Employee employee = new Employee(firstName, lastName);
//            if(supervisor == null || supervisor.equals("")) {
//                supervisors.add(lastName);
//            } else {
//                employee.setSupervisor(
//                        employees.stream()
//                                .filter(sup -> employee.getLastName().equals(supervisor))
//                                .findAny()
//                                .orElse(null));
//            }
//            employees.add(employee);
//        }
//        return employees;
//    }
//    /* It may have better logs, when something goes wrong */
}
