## Sample test cases for AWS Pipeline WSO2EI

Sample product artifacts and and sample test cases for WSO2 Enterprise Integrator. This repository is used as the sample for artifacts repository in WSO2 AWS pipeline for WSO2EI..

* A sample scenario test suite implemented using Testng is in `tests/wso2ei/` directory. This run a simple test to validate response code of a rest endpoint.

#### Add new test 
* Place the tests in `test/wso2ei/` directory. Update the testng.xml file to include your test class.

#### Run test suites
* Use following command to run the tests,
```
mvn test -Dendpoint=<ENDPOINT>
```

#### Add new artifacts 
* Place the artifact source code in the repository. Update `buildArtifact.sh` file with correct paths to artifact code.
