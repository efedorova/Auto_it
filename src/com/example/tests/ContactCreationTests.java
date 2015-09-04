package com.example.tests;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {

    @Test
    public void testNonEmptyContactCreation() throws Exception {
        app.getNavigationHelper().openMainPage();

        // save state
        List<ContactData> oldList = app.getContactHelper().getContact();

        // actions
        app.getContactHelper().initContactCreation();
        ContactData contact = new ContactData();
        //contact.firstName = "first name";
        //contact.lastName = "last name";
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

        Collections.sort(oldList);

        assertEquals(newList, oldList);
    }
}
