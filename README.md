# cicd-test-artifacts

This repository holds artifacts and scenario tests


#### Directory structure
```
.
├── artifacts
│   └── repository
│       └── deployment
│           └── server
│               └── carbonapps
└── tests
    └── sample-scenario-tests
        ├── src
           └── test
               ├── java
               │   └── org
               │       └── wso2
               └── resources
```

#### Quick Start Guide
* Place the car file in `artifacts/deployment/server/carbonapps/` directory.

* A sample scenario test suite implemented using Testng is in `test/sample-scenario-tests` directory. Which run a 
simple test to validate response code of a rest endpoint. Use following command to run the test,
```
mvn test -Dendpoint=<ENDPOINT>
```
Implement a new scenario test for the new car 

* Configure this repository as the artifacts repository in the Jenkins CICD pipeline
