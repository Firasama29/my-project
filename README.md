# my project
This project consists of microservices
* **content-service** which will display lists of websites, blogs, sites and articles
* **user-service** which will handle all user*related functionalities

# content-service
    a microservice to display, add and manipulate lists of websites, blogs, topics and articles.

* branch **feature-base-abstract-model** introduces abstract model classes that can be extended by other entities, inspired by petclinic-rest <link> </link>.
* the benefit of using this approach is to reduce duplication by reusing properties among entities
    * BaseEntity class has an auto-generated id, getter and setter. To be extended by entities that need the id
    * TitleEntity class has a name, getter and setter. To be extended by entities that need the title

******************************components******************************
```PENDING```
   * Unit tests
   * lombok
   * @Embeddable and composite key
   * custom validation annotation
   * jenkins pipeline
   * spring security
   * uploads
   * deploy to heruko
   * docker
   * OpenApi
   * Schema generation using hibernate and scripts
   * develop a library and import it as maven dependency
     * service class
     * custom annotation

```IN-PROGRESS```
   * @Query
   * Design patterns
     1. builder pattern

```COMPLETED```
   * entities
     1. Blogs
           * id | Long | consider UUID | required | pk
           * url | String | required
           * description | String
           * author | String
           * tags | List/array | relationship with Tags Entity
     2. Project
           * id | Long | consider UUID | required | pk
           * name | String
           * description | String
           * tags | List/array | relationship with Tags Entity
           * type | String
           * status | String
     3. Tags                                                       
           * id | Long | consider UUID | pk
           * name | String | required
           * description | String
     4. Topics                                                     
           * id * sequence
           * name | String | required
           * type | String | required
     5. Websites                                                   
           * id | Long | consider UUID | pk]
           * url | String | required
           * title | String | required
           * description | String
   * repositories
   * services
   * rest controller
   * exception handling
   * caching(topics, blogs)
   * BaseEntity and CommonEntity classes. Other entities that require properties from these 2 classes can extend them
     - benefit of this approach is to reduce duplication and reuse common properties among entities