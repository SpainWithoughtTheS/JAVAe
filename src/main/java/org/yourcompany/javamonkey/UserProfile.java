package org.yourcompany.javamonkey;

import java.util.List;

public class UserProfile {
    private String maritalStatus;
    private int dependents;
    private int retirementAge;
    private int riskTolerance;
    private boolean hasDebt;
    private List<String> preferredSectors;

    public UserProfile(String maritalStatus, int dependents, int retirementAge, int riskTolerance, boolean hasDebt, List<String> preferredSectors) {
        this.maritalStatus = maritalStatus;
        this.dependents = dependents;
        this.retirementAge = retirementAge;
        this.riskTolerance = riskTolerance;
        this.hasDebt = hasDebt;
        this.preferredSectors = preferredSectors;
    }

    public String getMaritalStatus() { return maritalStatus; }
    public int getDependents() { return dependents; }
    public int getRetirementAge() { return retirementAge; }
    public int getRiskTolerance() { return riskTolerance; }
    public boolean hasDebt() { return hasDebt; }
    public List<String> getPreferredSectors() { return preferredSectors; }
}