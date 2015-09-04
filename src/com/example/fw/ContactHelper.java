package com.example.fw;

import com.example.tests.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.firstname);
        type(By.name("lastname"), contact.lastname);
        type(By.name("address"), contact.address);
        type(By.name("home"), contact.homePhoneNumber);
        type(By.name("mobile"), contact.mobilePhoneNumber);
        type(By.name("work"), contact.workPhoneNumber);
        type(By.name("email"), contact.mainEmail);
        type(By.name("email2"), contact.reserveEmail);
        selectByIndex(By.name("bday"), contact.dayOfBirth);
        selectByIndex(By.name("bmonth"), contact.monthOfBirth);
        type(By.name("byear"), contact.yearOfBirth);
        selectByIndex(By.name("new_group"), contact.selectedGroup);
        type(By.name("address2"), contact.secondaryAddress);
        type(By.name("phone2"), contact.secondaryPhoneNumber);
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void initContactModification(int index) {
        click(By.xpath("//img [@alt='Edit'][" + index + "]"));
    }

    public void deleteContact() {
        click(By.xpath("(//input[@name='update'])[2]"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public List<ContactData> getContact() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
        for (WebElement checkbox : checkboxes) {
            ContactData contact = new ContactData();
            String title = checkbox.getAttribute("title");
            contact.firstname = title.substring("Select (".length(), title.length() - "secondname)".length());
            contacts.add(contact);
        }
        return contacts;
    }
}
