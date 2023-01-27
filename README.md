# description
This project consists of microservices
    - **content-service** which will display lists of websites, blogs, sites and articles
    - **user-service** which will handle all user-related functionalities
# content-service
a microservice to display, add and manipulate lists of websites, blogs, topics and articles.
# my-projectEntity
my-projectEntity

components
- **entities**
  1. Blogs
     - id | Long | consider UUID | required | pk
     - url | String | required
     - description | String
     - author | String
     - tags | List/array | relationship with Tags Entity
  2. Project
     - id | Long | consider UUID | required | pk
     - name | String
     - description | String
     - tags | List/array | relationship with Tags Entity
     - type | String
     - status | String
  3. Role
     - id | Long | consider UUID | required | pk
     - roleName | String
     - roleDescription | String
  4. User
     - id | Long | consider UUID | pk
     - name | String | required
     - email | String | required
     - password | String | required | relationship with UserRole
  5. UserRole
     - id | Long | consider UUID | pk
     - Role | Role Entity
  6. Sites
     - id - sequence - unique
     - name
  7. Tags
     - id | Long | consider UUID | pk
     - name | String | required
     - description | String
  8. Topics
     - id - sequence
     - name | String | required
     - type | String | required
  9. Websites
     - id | Long | consider UUID | pk]
     - url | String | required
     - title | String | required
     - description | String
- repositories
- services
- rest controller
- exception handling
- @Query
