# my project
This project consists of microservices
* **content-service** which will display lists of websites, blogs, sites and articles
* **user-service** which will handle all user*related functionalities

# content*service
    a microservice to display, add and manipulate lists of websites, blogs, topics and articles.

******************************components******************************

```PENDING```
   * Unit tests
   * custom validation annotation
   * jenkins pipeline
   * spring security
   * uploads
   * deploy to heruko or google cloud
   * docker

```IN-PROGRESS```
   * Design patterns
     1. factory pattern

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
   * Design patterns
      1. builder pattern
   * @Query
   * lombok
   * @Embeddable and composite key
