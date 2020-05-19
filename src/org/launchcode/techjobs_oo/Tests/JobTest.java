package org.launchcode.techjobs_oo.Tests;
import org.junit.BeforeClass;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;
import static org.junit.Assert.*;

public class JobTest {

    static Job emptyTestJob1;
    static Job emptyTestJob2;
    static Job testJobWithFields;
    static Job testJobWithFields2;
    static Job testJobWithPartialFields;

    @BeforeClass
    public static void setUp() {
         emptyTestJob1 = new Job();
         emptyTestJob2 = new Job();
         testJobWithFields = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
         testJobWithFields2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
         testJobWithPartialFields = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType(), new CoreCompetency());
    }

    @Test
    public void testSettingJobId() {
        assertEquals(emptyTestJob1.getId() + 1, emptyTestJob2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(testJobWithFields.getEmployer() instanceof Employer);
        assertTrue(testJobWithFields.getLocation() instanceof Location);
        assertTrue(testJobWithFields.getPositionType() instanceof PositionType);
        assertTrue(testJobWithFields.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(testJobWithFields.getName(), "Product tester");
        assertEquals(testJobWithFields.getEmployer().getValue(), "ACME");
        assertEquals(testJobWithFields.getLocation().getValue(), "Desert");
        assertEquals(testJobWithFields.getPositionType().getValue(), "Quality control");
        assertEquals(testJobWithFields.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        assertNotEquals(testJobWithFields,testJobWithFields2);
    }

    @Test
    public void toStringAddsBlankLines() {
        assertTrue(testJobWithFields.toString().startsWith("\n"));
        assertTrue(testJobWithFields.toString().endsWith("\n"));
    }

    @Test
    public void toStringFormatsProperlyWhenAllFieldsPresent() {
        assertEquals(testJobWithFields.toString(),"\nID: " + testJobWithFields.getId() + "\nName: " + testJobWithFields.getName() + "\nEmployer: " + testJobWithFields.getEmployer() + "\nLocation: " + testJobWithFields.getLocation() + "\nPosition Type: " + testJobWithFields.getPositionType() + "\nCore Competency: " + testJobWithFields.getCoreCompetency() + "\n");
    }

    @Test
    public void toStringFormatsProperlyWithPartialFields() {
        assertEquals(testJobWithPartialFields.toString(),"\nID: " + testJobWithPartialFields.getId() + "\nName: " + testJobWithPartialFields.getName() + "\nEmployer: " + testJobWithPartialFields.getEmployer() + "\nLocation: " + testJobWithFields.getLocation() + "\nPosition Type: Data not available\nCore Competency: Data not available\n");
    }

}
