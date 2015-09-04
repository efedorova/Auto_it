package com.example.tests;

import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;

public class GroupCreationTests extends TestBase {

    @Test(dataProvider = "randomValidGroupGenerator")
    public void testGroupCreationWithValidData(GroupData group) throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().gotoGroupsPage();

        // save old states
        List<GroupData> oldList = app.getGroupHelper().getGroups();

        // actions
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupsPage();

        // save new state

        List<GroupData> newList = app.getGroupHelper().getGroups();

        // compare content
        oldList.add(group);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }
}
