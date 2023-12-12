import java.util.LinkedList;

public class Apartment implements Comparable<Apartment> {
    private String streetAddress;
    private int apartmentNumber;
    private double monthlyRent;
    private int numberOfBedrooms;

    public Apartment(String streetAddress, int apartmentNumber, double monthlyRent, int numberOfBedrooms) {
        this.streetAddress = streetAddress;
        this.apartmentNumber = apartmentNumber;
        this.monthlyRent = monthlyRent;
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public double getMonthlyRent() {
        return monthlyRent;
    }

    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "streetAddress='" + streetAddress + '\'' +
                ", apartmentNumber=" + apartmentNumber +
                ", monthlyRent=" + monthlyRent +
                ", numberOfBedrooms=" + numberOfBedrooms +
                '}';
    }

    @Override
    public int compareTo(Apartment other) {
        // Corrected the comparison logic
        return Double.compare(this.monthlyRent, other.monthlyRent);
    }
}
