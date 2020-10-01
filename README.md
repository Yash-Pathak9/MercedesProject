# MercedesProject

Project 1: Spring BootApplicationDevelopment

1. Project 1 conists of Spring Boot application which has two End points: 
   1) addEmployee (Post Request create the data in data base)
   2) getAllEmployees (Get Request : Fetches the list of all employees with 3 attributes employee id, Employee Name,Manager Name)
2. Used H2 data storage for In memory storage.
3. Used Postman for API Testing.

Post request format: 
{   
    "employeeId" : "1",
    "employeeName":"Yash",
    "managerId" : "2" ,
    "managerName":"Vachaspati"
}

-----------------------------------------------------------------------

MercedesProject2 : Query String validation and Query JSON conversion

1. MercedesProject2 consists of Java Application which converts any string of type ((A=2 && B=3) || (C=4 && D=5)) to
   Json Format.
2. Created binary tree to store the string character by character and traversed it using Depth First Search Algorithm to 
   form the Json format.
3. Based on Assumptions mentioned in the assignment.

Input Format: please provide the input from the console.
ex: ((A=2 && B=3) || (C=4 && D=5))
