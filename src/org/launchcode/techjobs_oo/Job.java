package org.launchcode.techjobs_oo;

public class Job {

    public int id;
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

    @Override
    public String toString() {
        String outputStringCore = "";
        JobField[] arrayOfJobFields = {employer, location, positionType, coreCompetency};
        int emptyFieldCounter = 0;
        try {
            for (JobField jobField : arrayOfJobFields) {
                String jobFieldValue;
                if (jobField.getValue().equals("")) {
                    jobFieldValue = "Data not available";
                    emptyFieldCounter += 1;
                } else {
                    jobFieldValue = jobField.getValue();
                }
                outputStringCore += "\n" + jobField.getCategory() + ": " + jobFieldValue;
            }
            if (emptyFieldCounter < 4) {
                return "\nID: " + id + "\nName: " + name + outputStringCore + "\n";
            } else {
                return "OOPS! This job does not seem to exist.";
            }
        } catch(NullPointerException e) {
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