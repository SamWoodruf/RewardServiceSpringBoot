
- A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.
- A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent between $50 and $100 in each transaction. (e.g., a $120 purchase = 2x$20 + 1x$50 = 90 points).  
- Given a record of every transaction during a three-month period, calculate the reward points earned for each customer per month and total.
- Solve using Spring Boot:
  - Create a RESTful endpoint
  - Make up a data set to best demonstrate your solution
  - Check solution into GitHub 


This solution uses maps to simulate database storage for customers and transactions with a dataset
defined in the respective repository constructors.

<br>
Import project into IDE as a Maven project and run the main application class
<br>

Usage is as follows:
`GET localhost:8080/rewards/{customer_id}`
Sample Response Body:
```
{
    "rewardsMonthMap": {
        "Apr": 50,
        "Jun": 30,
        "May": 10,
        "Mar": 0
    },
    "customerId": 10,
    "rewardsTotal": 90
}
```