/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package software.amazon.SpringBootHikariExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import software.amazon.awssdk.services.sts.StsClient;
import software.amazon.awssdk.services.sts.auth.StsAssumeRoleCredentialsProvider;
import software.amazon.awssdk.services.sts.model.AssumeRoleRequest;
import software.amazon.jdbc.authentication.AwsCredentialsManager;

@SpringBootApplication
public class SpringBootHikariExampleApplication {
  public static void main(String[] args) {
    AwsCredentialsManager.setCustomHandler((hostSpec, props) -> {
      StsClient stsClient = StsClient.builder().build();
      AssumeRoleRequest req = AssumeRoleRequest.builder()
          .roleArn("arn:aws:iam::005965230347:role/iam-poc-testuserb")
          .roleSessionName("test123")
          .build();
      return StsAssumeRoleCredentialsProvider.builder()
          .stsClient(stsClient)
          .refreshRequest(req)
          .build();
    });
    SpringApplication.run(SpringBootHikariExampleApplication.class, args);
  }
}
