## List of issues I encounter during the course of development of this application

    1. Main application class is not within the proper classpath
        - This is a small issue. The root package was src/main/java and contained the Application.java class that is annotated with
            @SpringBootApplication. For some reason, @ComponentScan is not able to scan the class and the application fails to run
            if the class is situated in that root package.
        - SOLUTION: extend the root package - for example src/main/java/com/project/content and move the Application class to that new package

    2. Get request is displaying one object when it should fetch and display all objects from the database
        - This issue happened because I created a Response class that is mapped to an entity class. The mapping was done in a way that
        only one object from the database is displayed.
        - SOLUTION: I added 3 map methods. See the mapper classes for more details