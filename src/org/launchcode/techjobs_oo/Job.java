package org.launchcode.techjobs_oo;

public class Job {

    private int id;
    private static int nextId = 1;
    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job() {
        this.id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // Overrides:

    @Override
    public String toString() {
        String outputStringCore = "";
        JobField[] arrayOfJobFields = {employer, location, positionType, coreCompetency};
        int emptyFieldCounter = 0;
        try {   // Try/catch so that jobs with null fields trigger the job-does-not-exist message.
            for (JobField jobField : arrayOfJobFields) { // This loop is responsible for writing all of the final
                String jobFieldValue;                    // string except for the ID, Name, and opening and closing
                if (jobField.getValue().equals("")) {    // blank lines. If a field is empty, it replaces its value with
                    jobFieldValue = "Data not available";// Data Not Available and increments the empty field counter.
                    emptyFieldCounter += 1;
                } else {
                    jobFieldValue = jobField.getValue();
                }
                outputStringCore += "\n" + jobField.getCategory() + ": " + jobFieldValue; //Each loop iteration adds an-
            }                                                                             //other line to outputStringCore.
            if (emptyFieldCounter < 4) {
                return "\nID: " + id + "\nName: " + name + outputStringCore + "\n"; // Final output string - returns
            } else {                                                                // outputStringCore from the loop plus
                                                                                    // the missing ID, Name, and blank lines.
                return "OOPS! This job does not seem to exist."; // An empty field counter of 4 implies that all four
            }                                                    // job fields are blank and triggers the job-does-not-
        } catch(NullPointerException e) {                        // exist message.
            return "OOPS! This job does not seem to exist.";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    // Getters and setters:

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }
}