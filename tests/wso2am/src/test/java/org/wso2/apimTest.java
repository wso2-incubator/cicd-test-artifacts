/*
 *  Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */

package org.wso2;

/********** Test class for APIM ***********/

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class apimTest {

    @Test public static void main(String[] args) {
        int exitCode=1;
        try {
            String uri = System.getProperty("endpoint");
            String publisherUri = "https:"+ uri.split(":")[1] + "/publisher";
            System.out.println(publisherUri);
            String command = "curl -k -X GET " + publisherUri;
            ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
            Process process = processBuilder.start();
            TimeUnit.SECONDS.sleep(5);
            exitCode = process.exitValue();
            System.out.print(exitCode);
            process.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals(exitCode, 0);
    }
}