## Sample artifact resources for AWS Pipeline

Sample product artifacts and and sample test cases for WSO2 products. This repository is used as the sample for artifacts repository in WSO2 AWS pipeline..

#### Add new artifacts 
* Place the car file in `artifacts/deployment/server/carbonapps/` directory. Follow below naming convention when for artifacts. (c-apps).
    
        * Different endpoint c-apps need to included for different environments. For,
            production environment endpoint c-app: should contain "_production" in the name.
            eg: helloworld_production_1.0.car
            
            staging environment endpoint c-app: should contain "_staging" in the name.
            eg: helloworld_staging_1.0.car
            
            dev environment endpoint c-app: should contain "_dev" in the name.
            eg: helloworld_dev_1.0.car
         
        * Common c-app for all the environments.
            should contain "_common" in the name
            eg: helloworld_common_1.0.car

* A sample scenario test suite implemented using Testng is in `test/{product}/sample-test-suite{product}` directory. This run a 
simple test to validate response code of a rest endpoint. Use following command to run the test,
```
mvn test -Dendpoint=<ENDPOINT>
```

