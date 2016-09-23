/*
 * Copyright 2013-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.cloud.client.loadbalancer;

/**
 * Responsible for creating the {@link LoadBalancedRetryPolicy}.
 * @author Ryan Baxter
 */
public interface LoadBalancedRetryPolicyFactory {

    /**
     * Creates a {@link LoadBalancedRetryPolicy}.
     * @param serviceId The ID of the service to create the retry policy for.
     * @param loadBalanceChooser Used to get the next server from a load balancer
     * @return A retry policy for the service.
     */
    public LoadBalancedRetryPolicy create(String serviceId, LoadBalanceChooser loadBalanceChooser);

    static class NeverRetryFactory implements LoadBalancedRetryPolicyFactory {

        @Override
        public LoadBalancedRetryPolicy create(String serviceId, LoadBalanceChooser loadBalanceChooser) {
            return null;
        }
    }
}
