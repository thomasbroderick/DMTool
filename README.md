**DM Tool - Final Project for Skill Distillery

*Group Members
Tom Broderick, Jared Groves, Jeremy Botta

Hosted on AWS at http://18.217.143.254:8080/FinalREST/
Login with Username "Test" and Password "Test"

*Overview

We started this problem aiming to solve a problem familiar to those who run tabletop games everywhere: There's no singular all-in-one tool to assist you in sifting through the massive amount of information and applying it to your specific situation.

This is where our app comes into play: when you log in, our database stocked full of all the publicly available Dungeons and Dragons 5th Edition material populates the front-end tables and presents itself in an easy-to-navigate way. On top of that, any custom information you decide to put in yourself is persisted to our MySQL database and available to you the next time you log in.

This isn't only aimed at Dungeons and Dragons though, this was an exercise to be able to aggregate large amounts of information and display them in a meaningful and easy to navigate way.  Users can move the various grid elements around the screen, add their own characters, search the Tome of Arcane Knowledge, and access various rules for 5E play.  

*Agile

Greatly helping our group dynamic was our implementation of a more agile work environment. The more workplace-oriented practice of having two week sprints was untenable for a week-long project, so we modified these practices to have both morning and afternoon stand-up meetings in place of a traditional sprint. This allowed us to keep close tabs on where the project stood, where any issues were cropping up, and whether or not we needed to sit down for some pair programming to figure out an intractable problem. Using these practices, we were able to not only avoid code conflicts but the conflicts that arise when communication has broken down and team members find themselves at loggerheads.

*Pair Programming

Working in pairs solidifies techniques and information that may have been glossed over previously. As a group, we found that talking out problems with each other provided a solution much more quickly than hacking it out solo, and most importantly, all contributors were able to walk away with a more thorough understanding of the solved problem.

*Technologies

JPA
The Java Persistence API allowed us to maintain information from one session to the next with Java in the middle. This made our back-end database much more useful, as we would otherwise have had to hard-code any needed long-lasting information with no ability to modify it throughout.

SQL
Sql was a big part of this project since we were working with a database. Our project had a small but tightly connected database; this meant we had a lot of foreign key relationships between tables and even a self-join with User through the Friends table. This created an interesting dynamic when working with the database on the Java side and allowed us to gain experience writing unique SQL queries.  The project allows for full CRUD operations on all items in the DB.

Java 8
This project allowed our group to fully grasp the versatility of the Java language for full-stack applications. Our previous lessons in Object-Oriented programming paid huge dividends on this project, whether it was lining up entities in the framework to match database tables or - quite crucially for a web application - providing the framework to allow our Tomcat server to communicate with the back-end and the various languages used throughout.

Angular 6
Our front end was built using Angular 6 and incorporating Angular Materials design elements along with some custom Javascript.  The UI grid allows for a customizable view.  We used the Bootstrap library for CSS styling.  The page also utilizes numerous modals to display longer content.  We all learned a tremendous amount about the tools Angular provides when it comes to components, organizing your information, injecting services and dependencies, and overall management of files. 

AWS
"DMTool" is accessible through an Amazon Web Services server, conveniently free for usage below a certain bandwidth. We kept copies of the SQL database at the root level of our server, then accessed it with our WAR file from the top. For testing purposes, this was incredibly helpful because we could run multiple users at once, rather than hosting the application locally and hoping that everything would work once published.

Security
We implemented Spring Security in our app. User passwords are stored in a hashed state, and never in plain text. Using Spring security, we were able to get a much better idea of how exactly to plan your app's architecture around those security elements.
