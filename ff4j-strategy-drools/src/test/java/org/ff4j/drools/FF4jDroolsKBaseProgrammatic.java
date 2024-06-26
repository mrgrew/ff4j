package org.ff4j.drools;

/*-
 * #%L
 * ff4j-strategy-drools
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


import org.ff4j.FF4j;
import org.ff4j.core.Feature;
import org.junit.Assert;
import org.junit.Test;

/**
 * Externalize the flipping strategy into
 *
 * @author Cedrick Lunven (@clunven)</a>
 */
public class FF4jDroolsKBaseProgrammatic {
    
    @Test
    public void testDroolsStrategyFromkBaseName() {
        // Given
        FF4j ff4j = new FF4j();
        // When
        Feature f1 = new Feature("f1", true);
        f1.setFlippingStrategy(new FF4jDroolsFlippingStrategy("ff4jDroolsStrategy"));
        ff4j.createFeature(f1);
        Assert.assertTrue(ff4j.exist("f1"));
        // Then
        Assert.assertTrue(ff4j.check("f1"));
    }
        
}
