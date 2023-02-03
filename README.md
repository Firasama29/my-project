# my project
This project consists of microservices
- **content-service** which will display lists of websites, blogs, sites and articles
- **user-service** which will handle all user-related functionalities

# content-service
  a microservice to display, add and manipulate lists of websites, blogs, topics and articles.
  components
**entities**
  1. Blogs                                                      ----> done
     - id | Long | consider UUID | required | pk
     - url | String | required
     - description | String
     - author | String
     - tags | List/array | relationship with Tags Entity
  2. Project                                                    ----> done
     - id | Long | consider UUID | required | pk
     - name | String
     - description | String
     - tags | List/array | relationship with Tags Entity
     - type | String
     - status | String
  3. Tags                                                       ----> done
     - id | Long | consider UUID | pk
     - name | String | required
     - description | String
  4. Topics                                                     ----> done
     - id - sequence
     - name | String | required
     - type | String | required
  5. Websites                                                   ----> done
     - id | Long | consider UUID | pk]
     - url | String | required
     - title | String | required
     - description | String
**repositories**                             -  done
**services**                                 -  done
**rest controller**                          -  done

- exception handling                         -  pending
- @Query                                     -  pending
- @Embeddable and composite key              -  pending
- caching(topics, blogs)                     -  in-progress
- lombok                                     -  pending