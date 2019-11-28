#!/bin/bash

ARTIFACT_LOCATION=${ARTIFACT_LOC}

cd $ARTIFACT_LOCATION/helloworld/

if [ -d "artifacts" ]; then
        rm -rf $ARTIFACT_LOCATION/helloworld/artifacts/*
else
        mkdir artifacts
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