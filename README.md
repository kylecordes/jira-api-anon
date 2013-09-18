# Using the JIRA API Anonymously

[Kyle Cordes](http://kylecordes.com),
[Oasis Digital](http://oasisdigital.com),
Sep. 2013

Released under the MIT license; though this is so little code, surely you won't have any need to derive anything from it anyway.

## Rumors and Lies

There are rumors around that it is impossible to use the JIRA API anonymously, even with an instance set up for public read access.

That is not true, and this tiny project demonstrates it by retrieving info from a public JIRA instance (the [public JIRA instance for Hibernate](https://hibernate.atlassian.net/).

The main source of this confusion: neither the official JIRA API Java client, nor the third-party (and easy to work) [rcarz client](https://github.com/rcarz/jira-client) ships with anonymous access code or examples.

## Existance Proof

As of September 2013, this code demonstrates that it is trivial to access the JIRA API of a public JIRA instance. You just need a tiny bit of code to not try to auth.
