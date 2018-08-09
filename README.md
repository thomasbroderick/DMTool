README
Group Members
Tom Broderick, Jared Groves, Jeremy Botta

Why this project?
We started this problem aiming to solve a problem familiar to those who run tabletop games everywhere: There's no singular all-in-one tool to assist you in sifting through the massive amount of information and applying it to your specific situation.

This is where our app comes into play: when you log in, our database stocked full of all the publicly available Dungeons and Dragons 5th Edition material populates the front-end tables and presents itself in an easy-to-navigate way. On top of that, any custom information you decide to put in yourself is persisted to our MySQL database and available to you the next time you log in.

This isn't only aimed at Dungeons and Dragons though, this was an exercise to be able to aggregate large amounts of information and display them in a meaningful and easy to navigate way.

Agile Work Environment
Greatly helping our group dynamic was our implementation of a more agile work environment. The more workplace-oriented practice of having two week sprints was quite untenable for a week-long project, so we modified these practices to have both morning and afternoon stand-up meetings in place of a traditional sprint. This allowed us to keep close tabs on where the project stood, where any issues were cropping up, and whether or not we needed to sit down for some pair programming to figure out an intractable problem. Using these practices, we were able to not only avoid code conflicts but the conflicts that arise when communication has broken down and team members find themselves at loggerheads.

Pair Programming
At last, pair programming. Your friendly readme writer happens to be a huge proponent of this practice, as it solidifies techniques and information that may have been glossed over previously. As a group, we found that talking out problems with each other provided a solution much more quickly than hacking it out solo, and most importantly, all contributors were able to walk away with a more thorough understanding of the solved problem.

Technologies
CRUD
Creating, reading, updating, and deleting (or more gently, deactivating) data was the main purpose of this project. From the back-end to the front, all data that needed to persist from one session to the next does so, making the social aspects of the site much more workable.

JPA
The Java Persistence API allowed us to maintain information from one session to the next with Java in the middle. This made our back-end database much more useful, as we would otherwise have had to hard-code any needed long-lasting information with no ability to modify it throughout.

SQL
Sql was a big part of this project since we were working with a database. Our project had a small but tightly connected database; this meant we had a lot of foreign key relationships between tables and even a self-join with User through the Friends table. This created an interesting dynamic when working with the database on the Java side and allowed us to gain experience writing unique SQL queries.

JAVA
This project allowed our group to fully grasp the versatility of the Java language for full-stack applications. Our previous lessons in Object-Oriented programming paid huge dividends on this project, whether it was lining up entities in the framework to match database tables or - quite crucially for a web application - providing the framework to allow our Tomcat server to communicate with the back-end and the various languages used throughout.

AWS
"DMTool" is accessible through an Amazon Web Services server, conveniently free for usage below a certain bandwidth. We kept copies of the SQL database at the root level of our server, then accessed it with our WAR file from the top. For testing purposes, this was incredibly helpful because we could run multiple users at once, rather than hosting the application locally and hoping that everything would work once published.

Issues Seen, Issues Solved
We gathered our data from a publicly available API hosted by a 3rd party. Writing a script to convert their JSON into objects we would add to our database was a challenge all to its own. There were some inconsistencies in the JSON

Modals
Modals. Modals saved our collective behinds. We already were having issues learning how to manipulate and format our front end when we learned about modals. With them, we were able to dramatically increase the amount of information viewable on the main page without having to have the user scroll down. All the modals were pre-generated as the page loaded, and only displayed when clicked. It really served as a great way to give the user only the information he/she wanted at any given time.

Security
We implemented Spring Security in our app. User passwords are stored in a hashed state, and never in plain text. Using Spring security, we were able to get a much better idea of how exactly to plan your app's architecture around those security elements.

Angular 6
We used Angular 6 extensively as our front-end framework. It also made it very simple to install and enforce good security practices. We all learned a tremendous amount about the tools Angular provides when it comes to components, organizing your information, injecting services and dependencies, and overall management of files. 

HTML/CSS
HTML/CSS: This one was a beast. None of us had much experience in the front end design aspect, so it really was a case of learn-on-the-fly. We had issues with Google caching the .css file, and not knowing why new elements were not being properly selected. It was really rewarding to see our final product though, all things considered. I feel like we all learned a great deal about front-end design as a whole, and are a lot more comfortable mucking around in the front end of web applications.
