package com.example.tests;

public class GroupData implements Comparable<GroupData> {
    public  String name;
    public  String header;
    public  String footer;

    public GroupData() {
    }

    /*public GroupData(String name, String header, String footer) {
        this.name = name;
        this.header = header;
        this.footer = footer;
    }*/

    @Override
    public String toString() {
        return "GroupData{" +
                "name='" + name + '\'' +
                ", header='" + header + '\'' +
                ", footer='" + footer + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroupData)) return false;
        GroupData groupData = (GroupData) o;
        return name.equals(groupData.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public int compareTo(GroupData other) {
        return this.name.toLowerCase().compareTo(other.name.toLowerCase());
    }
}
