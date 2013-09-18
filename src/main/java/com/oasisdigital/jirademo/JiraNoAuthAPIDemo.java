package com.oasisdigital.jirademo;

// Demo of talking to JIRA API Anonymously
// Copyright 2013 Oasis Digital Solutions Inc.
// Released under the MIT license. See file.

// The purpose of this is to demonstrate the the JIRA API can be used
// anonymously, in instances that support anonymous access to JIRA. Of course,
// only reads work.

// Use the easy JIRA API wrapper from rcarz:

import net.rcarz.jiraclient.ICredentials;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;

import org.apache.http.HttpRequest;

public class JiraNoAuthAPIDemo {

    public static void main(String[] args) {
        // Log in anonymously
        AnonCredentials creds = new AnonCredentials();
        JiraClient jira = new JiraClient("https://hibernate.atlassian.net/",
                creds);

        try {
            // Retrieve an issue.
            Issue issue = jira.getIssue("BVAL-464");

            // Print some info about it to show it works:
            System.out.println(issue);
            System.out.println(issue.getDescription());
            System.out.println("Reporter: " + issue.getReporter());

            for (String l : issue.getLabels())
                System.out.println("Label: " + l);

            // Search
            Issue.SearchResult sr = jira
                    .searchIssues("project = BVAL AND resolution = Unresolved ORDER BY priority DESC");
            System.out.println("Issues Found: " + sr.total);
            for (Issue i : sr.issues)
                System.out.println("Issue ID: " + i);

        } catch (JiraException ex) {
            System.err.println(ex.getMessage());
            if (ex.getCause() != null)
                System.err.println(ex.getCause().getMessage());
        }
    }
}

class AnonCredentials implements ICredentials {

    public void authenticate(HttpRequest arg0) {
        // Do nothing
    }

    public String getLogonName() {
        return "none";
    }
}
