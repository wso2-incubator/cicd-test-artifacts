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

/********** Test class for EI ***********/

//import org.apache.commons.httpclient.*;
//import org.apache.commons.httpclient.methods.GetMethod;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.io.IOException;
//import java.util.concurrent.TimeUnit;
//
///**
// * This class tests the HelloWorld Rest endpoint
// */
//
//public class SimpleScenarioTest {
//    @Test public void testEndpoint() throws InterruptedException {
//        HttpClient client = new HttpClient();
//        String deployedAPI = "/helloworld";
//        int statusCode = -1;
//        String uri = System.getProperty("endpoint") + deployedAPI;
//        TimeUnit.MINUTES.sleep(1);
//        HttpMethod method = new GetMethod(uri);
//        try {
//            statusCode = client.executeMethod(method);
//        } catch (HttpException e) {
//            System.err.println("Fatal protocol violation: " + e.getMessage());
//            e.printStackTrace();
//        } catch (IOException e){
//            System.err.println("Fatal transport error: " + e.getMessage());
//            e.printStackTrace();
//        } finally {
//            method.releaseConnection();
//        }
//        Assert.assertEquals(statusCode, HttpStatus.SC_OK);
//    }
//}


/********** Test class for IS ***********/

import org.apache.commons.httpclient.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

/**
 * This class tests whether IS node is up and running
 */

public class SimpleScenarioTest {
    @Test public void testEndpoint() throws InterruptedException {

        String uri = System.getProperty("endpoint");
        TimeUnit.MINUTES.sleep(1);

        TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }
            public void checkClientTrusted(X509Certificate[] certs, String authType) {
            }
            public void checkServerTrusted(X509Certificate[] certs, String authType) {
            }
        }
        };

        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e1){
            e1.printStackTrace();
        }

        HostnameVerifier allHostsValid = new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };

        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

        int code = -1;

        try {
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            code = connection.getResponseCode();
        } catch (IOException e){
            e.printStackTrace();
        }
        Assert.assertEquals(code, HttpStatus.SC_OK);

    }
}
