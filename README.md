# LibraryManagement

TEST DATA: 

user:password - ROLE_USER

admin:password - ROLE_ADMIN

<img src="https://gcdnb.pbrd.co/images/KmXkx74L5K87.png" width="700"/>


This is a simple web application meant for real-world libraries, built using Spring Boot, Thymeleaf, MySQL driver, Spring Data JPA and Spring Security.
Users and books are stored in a MySQL database.
At the current stage you can index, add and remove books if you have an ADMIN role.
You can also create new users.

There are two roles, USER and ADMIN.
USER only has basic functionality for now, but over the coming weeks everything will be upgraded and more features will be added.

Over time, new features will be added, including:

PRIORITY) Proper use of authorization in Spring Security so users can be assigned USER and ADMIN roles; it is currently hardcoded.

Add navbars and show only anchor links for which the user has access to.
Implement borrowing feature of the books, show which are available, which are soon getting returned.
Implement balance feature for user accounts, show how much users need to pay if they're overdue.
Implement stock count of books (e.g. 3 books of Harry Potter available, 1 borrowed)

And more to come
