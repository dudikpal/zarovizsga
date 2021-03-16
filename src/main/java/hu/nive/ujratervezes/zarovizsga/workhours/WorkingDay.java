package hu.nive.ujratervezes.zarovizsga.workhours;

import java.time.LocalDate;

public class WorkingDay {
    
    private String workerName;
    private int workingHours;
    private LocalDate workingDate;
    
    private WorkingDay(String workerName, int workingHours, LocalDate workingDate) {
        this.workerName = workerName;
        this.workingHours = workingHours;
        this.workingDate = workingDate;
    }
    
    public static WorkingDay of(String workerName, int workingHours, LocalDate date) {
        return new WorkingDay(workerName, workingHours, date);
    }
    
    public String getWorkerName() {
        return workerName;
    }
    
    public int getWorkingHours() {
        return workingHours;
    }
    
    public LocalDate getWorkingDate() {
        return workingDate;
    }
    
    @Override
    public String toString() {
        return getWorkerName() +
                   ": " +
                   getWorkingDate();
    }
}