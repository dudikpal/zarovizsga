package hu.nive.ujratervezes.zarovizsga.workhours;


/*
Nem ellenőriztem semmi inputot a megbeszéltek szerint, hogy csak akkor kell,
 ha a feladat kéri
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class WorkHours {
    
    private List<WorkingDay> workingDays = new ArrayList<>();
    
    
    public String minWork(String file) {
        fileReader(file);
        return minWorkingDay();
    }
    
    
    private String minWorkingDay() {
        int minHours = Integer.MAX_VALUE;
        String result = "Result is null";
        for (WorkingDay day : workingDays) {
            if (minHours > day.getWorkingHours()) {
                minHours = day.getWorkingHours();
                result = day.toString();
            }
        }
        return result;
    }
    
    
    private void fileReader(String file) {
        
        try (BufferedReader br = new BufferedReader(Files.newBufferedReader(Path.of(file)))){
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String workerName = parts[0];
                int workingHours = Integer.parseInt(parts[1]);
                LocalDate workingDate = createLocalDateFromString(parts[2]);
                workingDays.add(WorkingDay.of(workerName, workingHours, workingDate));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file, ", ioe);
        }
    }
    
    
    private LocalDate createLocalDateFromString(String dateString) {
        String[] dateParts = dateString.split("-");
        int year = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]);
        int day = Integer.parseInt(dateParts[2]);
        return LocalDate.of(year, month, day);
    }
}