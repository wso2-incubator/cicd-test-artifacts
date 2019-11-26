#/*
# *  Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
# *
# *  WSO2 Inc. licenses this file to you under the Apache License,
# *  Version 2.0 (the "License"); you may not use this file except
# *  in compliance with the License.
# *  You may obtain a copy of the License at
# *
# *  http://www.apache.org/licenses/LICENSE-2.0
# *
# *  Unless required by applicable law or agreed to in writing,
# *  software distributed under the License is distributed on an
# *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
# *  KIND, either express or implied.  See the License for the
# *  specific language governing permissions and limitations
# *  under the License.
# *
# */

#!/bin/bash
ARTIFACT_LOCATION=${ARTIFACT_LOC}

if [ -d "$ARTIFACT_LOCATION/helloworld/artifacts" ]; then
        rm -rf $ARTIFACT_LOCATION/helloworld/artifacts/*
else
        mkdir -p $ARTIFACT_LOCATION/helloworld/artifacts
fi

cd $ARTIFACT_LOCATION/helloworld/dev/dev-esb
mvn clean install
cd ../helloworld_dev
mvn clean install
cp -r target/*  $ARTIFACT_LOCATION/helloworld/artifacts/

cd $ARTIFACT_LOCATION/helloworld/staging/staging-esb
mvn clean install
cd ../helloworld_staging
mvn clean install
cp -r target/*  $ARTIFACT_LOCATION/helloworld/artifacts/

cd $ARTIFACT_LOCATION/helloworld/prod/prod_esb
mvn clean install
cd ../helloworld_production
mvn clean install
cp -r target/*  $ARTIFACT_LOCATION/helloworld/artifacts/

cd $ARTIFACT_LOCATION/helloworld/common/helloworld
mvn clean install
cd ../helloworld_common
mvn clean install
cp -r target/*  $ARTIFACT_LOCATION/helloworld/artifacts/


cp -r $ARTIFACT_LOCATION/helloworld/artifacts/* $ARTIFACT_LOCATION/artifacts/repository/deployment/server/carbonapps/
rm -rf $ARTIFACT_LOCATION/helloworld/artifacts