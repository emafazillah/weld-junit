/*
 * JBoss, Home of Professional Open Source
 * Copyright 2018, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.weld.junit5.auto.alternatives;

import javax.inject.Inject;

import org.jboss.weld.junit5.auto.AddBeanClasses;
import org.jboss.weld.junit5.auto.EnableAlternatives;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests that @EnableAlternative works
 *
 * @author <a href="mailto:manovotn@redhat.com">Matej Novotny</a>
 */
@EnableAutoWeld
@EnableAlternatives(FooAlternative.class)
@AddBeanClasses({ Foo.class, FooAlternative.class })
public class EnableAlternativeTest {

    @Inject
    Foo foo;

    @Test
    public void testAlternativeIsEnabled() {
        Assertions.assertEquals(FooAlternative.class.getSimpleName(), foo.ping());
    }
}
