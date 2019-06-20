package org.launchcode.models.forms;

import javafx.geometry.Pos;
import org.launchcode.models.*;
import org.launchcode.models.data.JobData;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

/**
 * Created by LaunchCode
 */
public class JobForm {

    @NotNull
    @Size(min=1, message = "Name may not be empty")
    private String name;

    @NotNull
    private Employer employer;

    @NotNull
    private Location location;

    @NotNull
    private CoreCompetency coreCompetency;

    @NotNull
    private PositionType positionType;

    private ArrayList<Employer> employers;
    private ArrayList<Location> locations;
    private ArrayList<CoreCompetency> coreCompetencies;
    private ArrayList<PositionType> positionTypes;

    JobData jobData = JobData.getInstance();

    public JobForm() {

        employers = jobData.getEmployers().findAll();
        locations = jobData.getLocations().findAll();
        coreCompetencies = jobData.getCoreCompetencies().findAll();
        positionTypes = jobData.getPositionTypes().findAll();

    }

    // Name Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Employer ID Getters and Setters
    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer anEmployer) {
        this.employer = anEmployer;
    }

    public ArrayList<Employer> getEmployers() {
        return employers;
    }

    public void setEmployers(ArrayList<Employer> employers) {
        this.employers = employers;
    }

    // Location Getters and Setters

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location aLocation) {
        this.location = aLocation;
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    // Core Competencies Getters and Setters
    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency aCoreCompetency) {
        this.coreCompetency = aCoreCompetency;
    }

    public ArrayList<CoreCompetency> getCoreCompetencies() {
        return coreCompetencies;
    }

    public void setCoreCompetencies(ArrayList<CoreCompetency> coreCompetencies) {
        this.coreCompetencies = coreCompetencies;
    }

    // PositionType Getters and Setters
    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType aPositionType) {
        this.positionType = aPositionType;
    }

    public ArrayList<PositionType> getPositionTypes() {
        return positionTypes;
    }

    public void setPositionTypes(ArrayList<PositionType> positionTypes) {
        this.positionTypes = positionTypes;
    }
}
