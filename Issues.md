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

    3. Error status and message were not displaying in the response in postman
        - Since this project has multiple APIs, controllers, services, etc. that correspond to a particular section ex. projects, websites, etc.,
            only projects APIs were displaying a proper error status and message in postman when an exception is caught.
            other APIs were not doing so, even though I implemented a controllerAdvice and exception handling mechanism.
        - SOLUTION: It turns out it was a simple mistake. The RestControllerAdvice annotation has an attribute called AssignableTypes
            whose value is the array of controllers but I was only referencing ProjectController, which is why the issue was happening

    4. The get API was throwing an error
        - The error was : (No serializer found for class com.project.content.model.project.ProjectData and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS))
            indicates that Jackson - the JSON serialization library - is unable to serialize an instance of ProjectData class which is a property of ProjectListResponse
        - Solution: I added @JsonProperty on each property of ProjectData

    5. API response is returning null fields
        - After implementing builder pattern, all fields in the response were null.
        - Solution: Both the response class and builder class had no parameterized constructors.