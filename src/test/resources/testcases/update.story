Narrative:
Con la idea de probar la actualizacion de una persona
accederemos al servicio, actualizaremos una nueva persona y
verificaremos que el registro se cree correctamente.

Scenario: Creacion de una persona y verificacion
Given I'm on the welcome page <initial>
And go to update <update> a person with id <id>
When I change the name <name>
Then I'll have a 200 status response

Examples:
|initial                       |update                        |id|name   |
|http://localhost:8090/welcome |http://localhost:8090/personas|1 |Alberto|