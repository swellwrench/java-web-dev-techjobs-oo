package org.launchcode.techjobs_oo;

import static org.junit.Assert.assertEquals;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;
    private String finalOutputString;

    public Job() {
        this.id = nextId;
        nextId++;
    }

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

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
        }
        return "\n" + fieldName + ": " + fieldValue;
    }

    @Override
    public String toString() {
//        return "\nID: " + this.getId() + "\nName: " + this.getName() + "\nEmployer: " + this.getEmployer() + "\nLocation: " + this.getLocation() + "\nPosition Type: " + this.getPositionType() + "\nCore Competency: " + this.getCoreCompetency() + "\n";
        finalOutputString = "\nID: " + this.getId();
        finalOutputString +="\nName: " + this.getName();
        finalOutputString += stringifyByField(this.getEmployer());
        finalOutputString += stringifyByField(this.getLocation());
        finalOutputString += stringifyByField(this.getPositionType());
        finalOutputString += stringifyByField(this.getCoreCompetency());
        finalOutputString += "\n";
        return finalOutputString;
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
