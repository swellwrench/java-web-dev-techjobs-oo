package org.launchcode.techjobs_oo;

public class Job {

    public int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;
    private String finalOutputString;
    public int emptyFieldCounter = 0;

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

    public String stringifyByField(JobField field) {
        String fieldName = field.getClass().getSimpleName();
        if (fieldName.equals("CoreCompetency")) {
            fieldName = "Core Competency";
        }
        if (fieldName.equals("PositionType")) {
            fieldName = "Position Type";
        }
        String fieldValue = field.getValue();
        if (fieldValue == "") {
            fieldValue = "Data not available";
            emptyFieldCounter += 1;
        }
        if (emptyFieldCounter == 4) {
            return "OOPS! This job does not seem to exist.";
        } else {
            return "\n" + fieldName + ": " + fieldValue;
        }
    }

    @Override
    public String toString() {
//        return "\nID: " + this.getId() + "\nName: " + this.getName() + "\nEmployer: " + this.getEmployer() + "\nLocation: " + this.getLocation() + "\nPosition Type: " + this.getPositionType() + "\nCore Competency: " + this.getCoreCompetency() + "\n";
        try {
            finalOutputString = "\nID: " + this.getId();
            finalOutputString +="\nName: " + this.getName();
            finalOutputString += stringifyByField(this.getEmployer());
            finalOutputString += stringifyByField(this.getLocation());
            finalOutputString += stringifyByField(this.getPositionType());
            finalOutputString += stringifyByField(this.getCoreCompetency());
            finalOutputString += "\n";
            if (finalOutputString.contains("OOPS! This job does not seem to exist.")) {
                return "OOPS! This job does not seem to exist.";
            } else {
                return finalOutputString;
            }
        } catch (NullPointerException e) {
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
