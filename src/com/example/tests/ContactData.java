package com.example.tests;

public class ContactData implements Comparable<ContactData> {
    public String firstname;
    public String lastname;
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
                "firstname='" + firstname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactData)) return false;

        ContactData that = (ContactData) o;

        return firstname.equals(that.firstname);

    }

    @Override
    public int hashCode() {
        return firstname.hashCode();
    }

    @Override
    public int compareTo(ContactData other) {
        return this.firstname.toLowerCase().compareTo(other.firstname.toLowerCase());
    }
}
