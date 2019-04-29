package org.pozopardo.iplytics.proman.data;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class DataLoaderTest {

    @Test(expected = IOException.class)
    public void loadDataThrowsExceptionWhenFileDoesNotExist() throws IOException {
        DataLoader loader = new DataLoader();
        Set<List<String>> records = loader.loadData("FakeFileName.csv");
    }

    @Test
    @Parameters(method = "getDataSets")
    public void loadEmployeesShouldReturnNotRepeatedRecords(
            String fileName, int nOfRecords, int repeated) throws IOException {

        DataLoader loader = new DataLoader();
        Set<List<String>> records = loader.loadData(fileName);
        assertEquals(nOfRecords - repeated, records.size());
    }

    private static final Object [] getDataSets() {
        return new Object[]{
                new Object[]{"employees.csv", 11, 1},
                new Object[]{"projects.csv", 5, 0},
                new Object[]{"tasks.csv", 10, 1}
        };
    }
}
