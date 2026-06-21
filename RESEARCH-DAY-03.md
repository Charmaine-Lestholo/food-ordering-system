********Day 03 Research********

***Q1. What is JPA? What is Hibernate? How are they related?***

JPA (Java Persistence API) is a specification that defines how Java objects should be mapped to relational databases. It is just a set of rules, not an implementation. Hibernate is a framework that implements JPA and provides the actual functionality for database operations like saving, updating, and querying data. So, Hibernate is one of the most popular implementations of JPA.

***Q2. Difference between @Entity and @Table***

@Entity tells JPA that a class is a database entity and should be managed in persistence context. @Table is used to define the exact table name in the database. If @Table is not used, the table name defaults to the class name.

***Q3. What is a foreign key? What is @ManyToOne? Give 2 examples***

A foreign key is a column that links one table to another in a relational database. @ManyToOne represents a relationship where many records in one table belong to one record in another table.

**Examples:**

Many menus belong to one category (Pizza, Burger, Drinks)
Many orders belong to one customer

***Q4. What does @JoinColumn(name = "category_id") do?***

It defines the foreign key column name in the database table. In this case, it creates a column called category_id in the menus table that links each menu to a category.

***Q5. Why store price as BigDecimal and not double?***

BigDecimal is used because it provides precise decimal calculations, especially for money. Double can cause rounding errors due to floating-point precision issues, which is not acceptable for financial data.

***Q6. FetchType LAZY vs EAGER + default for @ManyToOne***

LAZY loading means data is only fetched when it is needed.
EAGER loading means data is loaded immediately with the main entity.
Default for @ManyToOne is EAGER, meaning related entities are loaded automatically unless changed.

***Q7. What is the N+1 query problem?***

It happens when one query loads a list of entities (1 query), and then additional queries are executed for each related entity (N queries). This leads to performance issues and too many database calls.

***Q8. Dependency injection + constructor vs field injection***

Dependency injection is a design pattern where objects are provided their dependencies instead of creating them manually.
***Field injection:*** uses @Autowired on variables (not recommended)
***Constructor injection:*** dependencies are passed through constructor (recommended)
Constructor injection is preferred because it makes code easier to test, safer, and immutable.

***Q9. What does @RequiredArgsConstructor do?***

It generates a constructor for all final fields in a class. This is commonly used with Spring services to enable constructor injection without writing boilerplate code.

***Q10. Role of the SERVICE layer***

The service layer contains business logic. It separates logic from controllers, which should only handle HTTP requests. This makes the application cleaner, easier to maintain, and reusable.

***Q11. Why validate categoryId exists before saving a menu?***

Because saving a menu with a non-existing category would break database integrity and foreign key constraints. It ensures the menu always belongs to a valid category.

***Q12. Difference between save() and saveAndFlush()***

save() stores the entity but may delay writing to the database.
saveAndFlush() immediately writes changes to the database.
Flush forces synchronization with the database right away.

***Q13. Why write private mapper methods (entity <-> dto)?***

Mapper methods keep code clean and reusable by separating conversion logic. They prevent duplication and make it easier to maintain and update transformations between entity and DTO.
