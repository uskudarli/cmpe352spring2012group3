# Use Case Diagram #

<img src='http://cmpe352spring2012group3.googlecode.com/files/UseCaseScenario.jpg' />

# Scenario 1 #

**Description :**

Ahmet, whose main interest is making old style kites registers to the site. System recommends people and tags for this person whom he might enjoy.

**Main Scenario :**

1) Ahmet registers the page with his/her name, surname, password, e-mail, preferred tags and entrance year.

2) Ahmet logs into the system.

3) Ahmet finds a tag "Old Style Kites" in "Recommended Tags" section of his profile page, and adds the tag to himself.

4) Ahmet enters the "Old Style Kites"s tag page.

5) System recommends other users having "Old Style Kites" tags & popular tags of those users on the tag page.

5) Ahmet posts on "Old Style Kites" tag page that he is going to buy some materials for his new kite on weekend.

6) Ahmet's post will appear on the profile page of other users having "Old Style Kites" tag.

# Use Cases #

**1.SIGN UP**

<b>Actors:</b> Users and Admins

<b>Goal:</b> Become a part of the CMPE community web site by creating a user profile.

<b>Preconditions:</b> Be a part of CMPE community

<b>Steps:</b>

> - New user enters personal info for creating an account

> - System provides this info to the admin

> - Admin checks if the user is a part of CMPE community


<b>Postconditions:</b>

> - If the user is accepted, the system sends a confirmation mail to the user

> - The account of the user is created


**2.LOGIN**

<b>Actors:</b> Users and Admins

<b>Goal:</b> Enter the system.

<b>Preconditions:</b> Have an account in the system.

<b>Steps:</b>

> - User provides username and password.

> - System checks if username and password are valid

<b>Postconditions:</b>

> - User enters the system


**3.ADD A TAG TO HIMSELF/HERSELF**

<b>Actors:</b> Users and System

<b>Goal:</b> Adding a tag to himself/herself in order to meet with people sharing same interest & informed by recent updates of the tag.

<b>Preconditions:</b> Have an account in the system.

<b>Steps:</b>

> - System checks the database to make personal suggestions to each  user, according to his tags & his friend's tags.

> - User finds a tag via "Recommended Tags" section on his profile.


<b>Postconditions:</b>

> - The suggested tags show up on each users profile page

> - User will receive notifications from the tag page


**4.SET PROPERTIES OF A GROUP**

<b>Actors:</b> Group Owner

<b>Goal:</b> Editing the properties of a group

<b>Preconditions:</b> Owning a group

<b>Steps:</b>

> - The owner edits the group page.

> - System checks the database to make personal suggestions to each user, according to the belonging groups


<b>Postconditions:</b>

> - The suggested groups show up on each users profile page, according to his/her interests

> - Properties of the group changes


**5.SEARCH**


<b>5.1 SEARCH PEOPLE</b>

> <b>Actors:</b> Users and System

> <b>Goal:</b> Searching the system according to a given key word

> <b>Preconditions:</b> Being a part of CMPE community group

> <b>Steps:</b>

> - The user will give, or the system will provide a key word.

> - System searches the database


> <b>Postconditions:</b>

> - The system will return the result of the query


# Scenario 2 #

**Description :**

A user wants to setup a <a href='http://en.wikipedia.org/wiki/BarCamp'>BarCamp</a> organization about Jquerry.

**Main Scenario :**

1)User registers the page with his/her name, surname, password, e-mail and entrance year.

2)Registered user logs into the system.

3)User creates an event by entering the name of the event and <a href='http://en.wikipedia.org/wiki/BarCamp'>BarCamp</a> as the organization type,“Jquerry” as the subject of the event with specified date,location.

4)User invites Ayşe to the event.

5)System sends a notification of the event to Ayşe.

6)Ayşe view the event and decides to attend or not attend.

7)Systems remove the event after action date or creator may cancel it.

**Alternative Scenario :**

1)This event already exists in the system.

2)An invited user is trying to cancel the event.

3)Although event has occured, the system could not delete the event.

4)Uninvited people are trying to access the event.


# Use Cases #

**1.CREATE AN EVENT**

<b>Actors:</b> Users

<b>Goal:</b> Creating an event for a specific purpose

<b>Preconditions:</b> Being a user of the CMPE community

<b>Steps:</b>

> - Enter a name for the event

> - Provide necessary information (such as time and place) for the event


<b>Postconditions:</b>

> - Event creator invites people to the event.


**2.INVITE PEOPLE TO EVENT**

<b>Actors:</b> Event Creator

<b>Goal:</b> Inviting users to the event.

<b>Preconditions:</b> Owning an event

<b>Steps:</b>

> - Enter user name of the people to be invited to the group

> - System sends a notification of the event to the invited users.


<b>Postconditions:</b>

> - Invited people view the event and decides to attend or not attend.


**3.EDIT EVENT PROPERTIES**

<b>Actors:</b> Event Creator

<b>Goal:</b> Editing properties of the event.

<b>Preconditions:</b> Owning an event

<b>Steps:</b>

> - Update event properties such as time and place.


<b>Postconditions:</b>

> - Invited/attending people notified the update.

**4.DELETE AN EVENT**

<b>Actors:</b> Event Creator

<b>Goal:</b> Deleting an event

<b>Preconditions:</b> Owning the event

<b>Steps:</b>

> - Event deletion is confirmed and removed from active events.


<b>Postconditions:</b>

> - Attending or invited people are notified that event is canceled.


**5.RECEIVE A NOTIFICATION**

<b>Actors:</b> Users

<b>Goal:</b> Getting an invitation or event update.

<b>Preconditions:</b> An incoming invitation, or being in event which is recently updated.

<b>Steps:</b>

> - System checks the user info from the database.


<b>Postconditions:</b>

> - A notification is shown to user.


**5.UPDATE ATTENDANCE STATUS**

<b>Actors:</b> Users

<b>Goal:</b> Updating attendance status to an event.

<b>Preconditions:</b> Being invited to the event

<b>Steps:</b>

> - User select whether to attend or not attend to the event.


<b>Postconditions:</b>

> - User's attendance status is updated.


**6.VIEW AN EVENT**

<b>Actors:</b> Users

<b>Goal:</b> Viewing details of an event.

<b>Preconditions:</b> Being invited to the event.

<b>Steps:</b>

> - System provides information about the event to the user.


<b>Postconditions:</b>

> - Users are able to view details of an event.


**7.CHECK FOR INVITATION**

<b>Actors:</b> System

<b>Goal:</b> Providing privacy for the event.

<b>Preconditions:</b> A user requested to view or attend to an event

<b>Steps:</b>

> - System checks if the user was invited to the event.


<b>Postconditions:</b>

> - Only allowed users can view the event.