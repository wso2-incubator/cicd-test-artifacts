## Sample artifact resources for AWS Pipeline

Sample product artifacts and and sample test cases for WSO2 products. This repository is used as the sample for artifacts repository in WSO2 AWS pipeline..

#### Add new artifacts 
* Place the car file in `artifacts/deployment/server/carbonapps/` directory.

* A sample scenario test suite implemented using Testng is in `test/{product}/sample-test-suite{product}` directory. This run a 
simple test to validate response code of a rest endpoint. Use following command to run the test,
```
mvn test -Dendpoint=<ENDPOINT>
```
