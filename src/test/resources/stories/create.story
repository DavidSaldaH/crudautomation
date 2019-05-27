Scenario: Testing loking for a record
Given I'm on the welcome page <initial>
And go to <create> a person <id><name><lastName> and <age>
When I verify that the status is 200
Then I'll have 2 records

Examples:
|initial                       |create                        |id|name     |lastName  |age|
|http://localhost:8090/welcome |http://localhost:8090/personas|3 |Alberto|Cardenas|33 |