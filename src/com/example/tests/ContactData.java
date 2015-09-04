package com.example.tests;

public class ContactData implements Comparable<ContactData> {
    public String firstName;
    public String lastName;
    public String address;
    public String homePhoneNumber;
    public String mobilePhoneNumber;
    public String workPhoneNumber;
    public String mainEmail;
    public String reserveEmail;
    public String dayOfBirth;
    public String monthOfBirth;
    public String yearOfBirth;
    public String selectedGroup;
    public String secondaryAddress;
    public String secondaryPhoneNumber;

    public ContactData()  {
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "firstName='" + firstName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactData)) return false;

        ContactData that = (ContactData) o;

        return firstName.equals(that.firstName);

    }

    @Override
    public int hashCode() {
        return firstName.hashCode();
    }

    @Override
    public int compareTo(ContactData other) {
        return this.firstName.toLowerCase().compareTo(other.firstName.toLowerCase());
    }
}
