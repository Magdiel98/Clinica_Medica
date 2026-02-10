# Clínica Médica Backend

## Description 

This application is an API responsible for the communication between the database and the frontend, providing structured endpoints for data management.

This project was built using: 
Java, Spring Boot, PostgreSQL, Maven. 

The main objective of this project is to facilitate the relationship between doctors and patients by managing appointments on the backend side, ensuring data integrity and persistence.

## Installation Instructions

To run this backend application locally, follow these steps: 

### Prerequisites: 
* Java JDK [21.0.7];
* PostgreSQL [17] , pgAdmin4;
* Maven.

### 1. Database Setup
1. Create a database named "[Database Name]" in your PosgreSQL.
2. Update the `src/main/resources/application.yaml` file with your database credentials: 
``
spring:
    application:
        name: [Database Name]
    
    datasource: 
        url: jdbc:postgresql://localhost:5432/[Database Name]
        username: [Your Username]
        password: [Your Password]
``

## Usage

To use this project, clone the repository to your local machine and import it into your IDE (such as Spring Tool Suite 4).
Or, if you want use this project online you can access this link: https://clinica-medica-8pva.onrender.com. 
In the following endpoints below you can use the link above instead of localhost. 

Endpoints: 

### Endpoint GET
### GET Doctor

`GET http://localhost:8080/medicos` - Retrieve a list of all registered doctors. 

`
[  
  {
    "id": 1,
    "nome": "Dr. Firmino Alves",
    "email": "firminoalves@gmail.com",
    "crm": "CRM/RN 123456",
    "telefones": [
      "(88)88888-8888"
    ]
  }
]
`


### GET Appointments
`GET http://localhost:8080/consultas` - Retrieve a list of all registered appointments.

`[
  {
    "id": 1,
    "data": "2026-02-10",
    "hora": "14:30:00",
    "status": "AGENDADA",
    "nomePaciente": "José",
    "nomeMedico": "Dr. Firmino Alves"
  }
]
`

### GET Patients
`GET http://localhost:8080/pacientes` - Retrieve a list of all registered patients.

`
[
  {
    "id": 1,
    "nome": "José",
    "email": "josé@gmail.com",
    "cpf": "129.020.092-04",
    "telefones": [
      "(99)99999-9999"
    ]
  }
]
`
### Endpoint POST
### POST Doctor
`POST http://localhost:8080/medicos` - Register a new doctor into the Database

`
[  
  {
    "nome": "Dr. Rangel Gomes",
    "email": "rangelgomes@gmail.com",
    "crm": "CRM/RN 345678",
    "telefones": [
        "(22)22222-2222"
    ]
  }
]
`

### POST Appointments
`POST http://localhost:8080/consultas` - Register a new appointment into the Database

`[
  {
     "data": "2026-02-10",
    "hora": "14:30",
    "pacienteId": "1",
    "medicoId": "1"
  }
]
`

### POST Patients
`POST http://localhost:8080/pacientes` - Register a new patient into the Database
`
[  
  {
    "nome": "José",
    "email": "josé@gmail.com",
    "cpf": "129.020.092-04",
    "telefones": [
      "(99)99999-9999"
    ]
  }
]
`

## Contributing 

Contributions are always welcome! If you want to improve this clinic system, follow these steps: 

1. Fork this project; 
2. Create a Feature Branch;
3. Commit your changes;
4. Push to the Branch;
5. Open a Pull Request. 

Please make sure to update tests and documentation as appropriate. 


## Contributors or Owners

**[Magdiel Gomes Ferreira]** - [GitHub Profile](https://github.com/Magdiel98)

## License 

This project is licensed under the [MIT License](LICENSE).

