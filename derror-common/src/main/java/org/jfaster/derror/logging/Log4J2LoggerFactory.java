/*
 *
 *   Copyright 2018 derror.jfaster.org.
 *     <p>
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *   </p>
 */

package org.jfaster.derror.logging;

import org.apache.logging.log4j.LogManager;

/**
 * @author yangnan
 */
public class Log4J2LoggerFactory extends InternalLoggerFactory {

    public static final InternalLoggerFactory INSTANCE = new Log4J2LoggerFactory();

    private Log4J2LoggerFactory() {
    }

    @Override
    public InternalLogger newInstance(String name) {
        return new Log4J2Logger(LogManager.getLogger(name));
    }
}