/**
 * Copyright (C) 2014 James Jory (james.b.jory@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.instagram4j;

import org.instagram4j.entity.User;
import org.junit.Assert;

import junit.framework.Test;
import junit.framework.TestSuite;

public class TestUser extends TestBase {
    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(TestUser.class);
    }

    public void testCurrentUser() throws InstagramException {
    	InstagramClient client = createClient();
    	client.setSignedHeaderEnabled(true);
    	client.setClientIps("127.0.0.1");
    	
    	Result<User> result = client.getCurrentUser();
    	Assert.assertNotNull(result);
    	Assert.assertNotNull(result.getMeta());
    	Assert.assertTrue(result.getMeta().isSuccess());
    	Assert.assertNotNull(result.getData());
    	
    	Assert.assertEquals("VinTank", result.getData().getFullName());
    	Assert.assertNotNull(result.getData().getCounts());
    }
}
