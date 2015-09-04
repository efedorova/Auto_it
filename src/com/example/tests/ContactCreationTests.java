package com.example.tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import java.util.Collections;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testNonEmptyContactCreation() throws Exception {
        app.getNavigationHelper().openMainPage();

        // save state
        List<ContactData> oldList = app.getContactHelper().getContact();

        printList(oldList, "Start old 111");

        // actions
        app.getContactHelper().initContactCreation();
        ContactData contact = new ContactData();
        contact.firstname = "first name";
        contact.lastname = "last name";
        contact.address = "address";
        contact.homePhoneNumber = "123456";
        contact.mobilePhoneNumber = "234567";
        contact.workPhoneNumber = "345678";
        contact.mainEmail = "email@gmail.com";
        contact.reserveEmail = "email2@mail.com";
        contact.dayOfBirth = "27";
        contact.monthOfBirth = "3";
        contact.yearOfBirth = "1990";
        contact.selectedGroup = "1";
        contact.secondaryAddress = "some address";
        contact.secondaryPhoneNumber = "something else";
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToHomePage();

        // save new state
        List<ContactData> newList = app.getContactHelper().getContact();

        // compare states
        assertEquals(newList.size(), oldList.size() + 1);

        oldList.add(contact);
        printList(oldList, "Start old 222");

        Collections.sort(oldList);
        printList(oldList, "Start old");
        printList(newList, "Start new");

        assertEquals(newList, oldList);
    }

    private void printList(List<ContactData> oldList, String text) {
        System.out.println(text);
        for(ContactData d : oldList) {
            System.out.print(d.firstname + " ");
        }
        System.out.println();
        System.out.println();
    }
}
