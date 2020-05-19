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

    @BeforeClass
    public static void setUp() {
         emptyTestJob1 = new Job();
         emptyTestJob2 = new Job();
         testJobWithFields = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
         testJobWithFields2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
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

}
