### Prerequisities
Java JDK 21,  Maven v3.6.3

### Building the project
Use maven to build the project with the following command `mvn clean install` 

Once built, use `mvn spring-boot:run` to start the application. You can use Bruno with the following endpoints and payloads

#### create a loan
http://localhost:8080/loans
```
{
  "identifier":"xad",
  "term":12,
  "amount":200
}
```
This will create a loan with 12 month term, a reference of "xad" and oustading amount of 200. Upon succesful creation this will return with status 201 (created).

### find a created loan by identifier
http://localhost:8080/loans/xad

The path is using "xad" as a reference for the loan created by the previous call.

### pay an existing loan
http://localhost:8080/payments
```
{
  "identifier":"payxadon2",
  "loanIdentifier":"xad",
  "amount":20
}
```
This creates a payment for a loan with the unique identifier of "xad" and from a database perspective it links the payment with identifier "payxadon2". A subsequent call view the loan, will show that the remaining amount should have been reduced by the specified paymenet. Or 0 if the payment was large enough.



