## Quality Attributes

| ID   | Quality Attribute | Scenario                                                                                                                                                            | Associated Use Case |
|------|-------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------|
| QA-1 | Modifiability     | It should be easy to add another persistence framework to the application, without any interference on the rest of the application other than the persistence layer |                     |
| QA-2 | Localizability    | Support for English and Portuguese languages are mandatory for students                                                                                             |                     |
|      |                   |                                                                                                                                                                     |                     |

## Constraints


| ID    | Constraint                                                                     |
|-------|--------------------------------------------------------------------------------|
| CON-1 | A prototype must be delivered until November 19th                              |
| CON-2 | The prototype must be developed by the school staff                            |
| CON-3 | An on-prem solution is desirable with deployment on virtual machines or docker |
| CON-4 | A RESTful API must be developed                                                |
| CON-5 | The application must be accessible using a web browser                         |
| CON-6 | Internationalization is a requirement for the application                      |
| CON-7 | The team can only adopt open-source technologies                               |
| CON-8 | Java language and Spring framework are mandatory                               |



## Architectural concerns

| ID    | CONCERN                                                                                                                                                    |
|-------|------------------------------------------------------------------------------------------------------------------------------------------------------------|
| CRN-1 | Estabilishing an overall initial system architectur                                                                                                        |
| CRN-2 | Internationalization support is mandatory for students                                                                                                     |
| CRN-3 | The application must be independent of the persistence layer. It should not matter to the rest of the application which persistence framework will be used |