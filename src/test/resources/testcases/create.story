Narrative:
Con la idea de probar la creacion de una persona
accederemos al servicio, crearemos una nueva persona y
verificaremos que el registro se cree correctamente.

Scenario: Creacion de una persona y verificacion
Given go to create <create> a person with id <id>, name <name>, lastname <lastName> and <age>
When I verify that the status is 200
Then I'll have 1 records

Examples:
|initial                       |create                        |id|name     |lastName  |age|
|http://localhost:8090/welcome |http://localhost:8090/personas|3 |Alberto|Cardenas|33 |