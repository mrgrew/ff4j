package org.ff4j.property;

/*-
 * #%L
 * ff4j-core
 * %%
 * Copyright (C) 2013 - 2024 FF4J
 * %%
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
 * #L%
 */

import org.ff4j.exception.InvalidPropertyTypeException;

/**
 * Implementation of a property of type INT.
 *
 * @author Cedrick Lunven (@clunven)
 */
public class PropertyLong extends Property< Long > {

    /** serial. */
    private static final long serialVersionUID = -134543098672660987L;

    /**
     * Constructor by string expression.
     *
     * @param uid
     *      unique name
     * @param lvl
     *      current log level
     */
    public PropertyLong() {
    }
    
    /**
     * Constructor by string expression.
     *
     * @param uid
     *      unique name
     * @param lvl
     *      current log level
     */
    public PropertyLong(String uid) {
       super(uid);
    }
    
    /**
     * Constructor by string expression.
     *
     * @param uid
     *      unique name
     * @param lvl
     *      current log level
     */
    public PropertyLong(String uid, String value) {
       super(uid, value);
    }
    
    /**
     * Constructor by string expression.
     *
     * @param uid
     *      unique name
     * @param lvl
     *      current log level
     */
    public PropertyLong(String uid, Long value) {
       super(uid, value);
    }
    
    /** {@inheritDoc} */
    @Override
    public Long fromString(String v) {
        try {
            return new Long(v);
        } catch(NumberFormatException nbe) {
            throw new InvalidPropertyTypeException("Cannot cast " + v + "to expected " + Long.class, nbe);
        }
    }

}
