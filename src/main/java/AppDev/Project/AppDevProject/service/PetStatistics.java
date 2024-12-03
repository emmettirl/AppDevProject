package AppDev.Project.AppDevProject.service;


public class PetStatistics {
    private double averageAge;
    private int oldestAge;

    public PetStatistics(double averageAge, int oldestAge) {
        this.averageAge = averageAge;
        this.oldestAge = oldestAge;
    }

    public double getAverageAge() {
        return averageAge;
    }

    public void setAverageAge(double averageAge) {
        this.averageAge = averageAge;
    }

    public int getOldestAge() {
        return oldestAge;
    }

    public void setOldestAge(int oldestAge) {
        this.oldestAge = oldestAge;
    }
}
