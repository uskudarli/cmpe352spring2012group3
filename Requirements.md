# 1.General Description #
> This application shall be a social web application which aims to create an environment where members of the community can share interests with anyone and express their ideas accordingly in the community.

# 2.Functional Requirements #

> ## <b>2.1. Member Profiles</b> ##

> 2.1.1. User profile shall contain name, surname, profile picture, email, password, phone number, <b><i>interest tags</i></b>, entrance year for each user.


> 2.1.2. The system shall send an email for confirmation after register.

> 2.1.3. The system shall provide a password reminder via e-mail.

> 2.1.4. The system shall provide an interface for editing profiles for users

> 2.1.5. The system shall provide roles for the users (i.e. user, administrator)

> 2.1.6. The system shall allow users to follow other users status updates.

> 2.1.7. The system shall allow users to enter status updates.

> 2.1.8. The system shall allow users to comment on their friends' status updates.

> <b><i>2.1.9. Users should be able add tag to other users from their profile page.</i></b>

> <b><i>2.1.10. Users should be able to add tags to themselves.</i></b>

> <b><i>2.1.11. The system shall recommend tags to users while registering.</i></b>

> <b><i>2.1.12. The system shall recommend tags in the "Recommended Tags" section of the users profile page.</i></b>

> <b><i>2.1.13. The "Recommended Tags" section shall introduce tags used by users's friends(connected users).</i></b>

> ## <b>2.2 Creation of a space for special interests or topics</b> ##

> <b><i>2.2.1. Users should be able to create tags about their interests or temporary occasions.</i></b>

> <b><i>2.2.2. The system shall create a page for each tag.</i></b>

> <b><i>2.2.3. The system shall recommend tags to users in the "Recommended Tags" section of the tag page.</i></b>

> <b><i>2.2.4. The "Recommended Tags" section shall introduce tags added by users's of the current tag.</i></b>


> <b><i>2.2.5. The system shall list users having the current tag, in the "Recommended Users" section of the tag page.</i></b>

> <b><i>2.2.6. The users shall post on tag page.</i></b>

> <b><i>2.2.7. The users shall reply on post, appearing on tag page.</i></b>

> <b><i>2.2.8 The users shall view replies from the tag page.</i></b>

> ## <b>2.3 Special purpose structures for the area of interests </b> ##

> 2.3.1. Users should create an event with action date,location.

> 2.3.2. The creator of the event should invite other members to attend his events.

> 2.3.3. The creator of the event should be able to edit settings of event.

> 2.3.4. Invited users shall comment on events.

> 2.3.5. The system shall remove the event from website after timeout or cancellation of the creator.

> ## <b>2.4 Discussion Forum</b> ##

> 2.4.1. Administrators should be able to open categories

> 2.4.2. Users should be able to open a topic on discussion forum in predefined categories

> 2.4.3. Users should be able to write their own comments to the topics

> 2.4.4. Users should be able to like or dislike any comments on any topics

> ## <b>2.5. Surveys</b> ##

> 2.5.1 Users should be able to create surveys

> 2.5.2. Users shall see the results of the survey after voting

> 2.5.3. The creator of the survey shall give a due date for the surveys

> ## <b>2.6. Search/ Advanced Search</b> ##

> 2.6.1. Users should be able to search for people, group, event, survey, topic on discussion forum

> 2.6.2. The system shall give suggestions to users

> 2.6.3. Users should be able to filter the results of the search

> 2.6.4. The system shall list the result of search or filtered search

> ## <b>2.7. Browsing</b> ##

> 2.7.1. Users should be allowed to navigate through user profiles,group,surveys,events and discussion forums

> ## <b>2.8. Notification from subscriptions</b> ##

> 2.8.1. The system shall send notifications to users from subscribed pages.

> 2.8.2. The system shall send notifications when a user is invited to an event.

> 2.8.3. The system shall send notification to users whose status is commented by other users.

> 2.8.4. The system shall send notification to requested users.

> <b><i>2.8.5. The system shall send notification to users when there is a reply to their posts on tag pages.</i></b>

> ## <b>2.9. Validation of a registration</b> ##

> 2.9.1. Admin should load email information of instructors & students to system each semester

> 2.9.2. On registration system shall check if the user’s email exists in the system.


# 3.Non-functional Requirements #

> ## <b>3.1. Usability</b> ##

> 3.1.1. The system shall provide a user friendly, simple interface to ease usage.

> 3.1.2. The application shall be easily understandable and available even by elder members of CMPE Community

> ## <b>2. Accessibility</b> ##

> 3.2.1. The community should be accessed only by people from CMPE people.

> 3.2.2. All users shall have the ability to access CMPE Community all the time, in every circumstances (i.e. non restricted number of profiles and usage time)

> ## <b>3.3. Privacy and Security</b> ##

> 3.3.1. The user shall be able to hide his personal information from other users.

> 3.3.2. The creator of the survey shall open the survey only for a group, or public(for all users).

> 3.3.3. The system shall keep password as a hashed password.

> 3.3.4. The system shall allow admin to delete a profile, a group or a survey when s/he decides that content or user is not appropriate.

> ## <b>3.4. Authentication</b> ##

> 3.4.1. In the case of wrong password users shall be obliged to authenticate their information for security.

> ## <b>3.5. Portability</b> ##

> 3.5.1 CMPE Community shall have an Android application for portability.

> ## <b>3.6. Avaliability</b> ##

> 3.6.1. The user interface of the system shall be viewed properly by Firefox and Chrome.

> ## <b>3.7. Performance and Efficiency</b> ##

> 3.7.1. Web pages of the application should be loaded quickly.

> 3.7.2. The system shall minimize traffic amount between a server and a mobile device.

> ## <b>3.8. Capacity</b> ##

> 3.8.1. The application should avoid from unnecessary tables in the database to minimize data size.

> 3.8.2. The common module(javascript functions,HTML code generator) should be constructed for web pages having some common properties.Hence writability and readibility of code increase.

> ## <b>3.9. Reliability</b> ##

> 3.9.1. On an unexpected situation (power loss, system crash), the system will prevent loss of data.

> ## <b>3.10. Dependability</b> ##

> 3.10.1 The project shall be implemented using Java with Apache Tomcat Server on the front side, MySQL on the back side.


