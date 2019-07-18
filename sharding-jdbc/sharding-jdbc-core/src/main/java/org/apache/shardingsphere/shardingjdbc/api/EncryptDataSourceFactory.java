/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.shardingjdbc.api;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.shardingsphere.api.config.encrypt.EncryptRuleConfigurationBak;
import org.apache.shardingsphere.shardingjdbc.jdbc.core.datasource.EncryptDataSource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Encrypt data source factory.
 * 
 * @author panjuan
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class EncryptDataSourceFactory {
    
    /**
     * Create encrypt data source.
     *
     * @param dataSource data source
     * @param encryptRuleConfiguration encrypt rule configuration
     * @return encrypt data source
     */
    public static DataSource createDataSource(final DataSource dataSource, final EncryptRuleConfigurationBak encryptRuleConfiguration) {
        return createDataSource(dataSource, encryptRuleConfiguration, new Properties());
    }
    
    /**
     * Create encrypt data source.
     * 
     * @param dataSource data source
     * @param encryptRuleConfiguration encrypt rule configuration
     * @param props properties
     * @return encrypt data source
     */
    public static DataSource createDataSource(final DataSource dataSource, final EncryptRuleConfigurationBak encryptRuleConfiguration, final Properties props) {
        return new EncryptDataSource(dataSource, encryptRuleConfiguration, props);
    }
}
