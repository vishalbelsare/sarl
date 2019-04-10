/*
 * $Id$
 *
 * SARL is an general-purpose agent programming language.
 * More details on http://www.sarl.io
 *
 * Copyright (C) 2014-2019 the original authors or authors.
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

package io.sarl.lang.core.tests.scoping.extensions.numbers.cast.atomicinteger;

import static io.sarl.lang.scoping.extensions.numbers.cast.AtomicIntegerCastExtensions.*;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import com.google.common.util.concurrent.AtomicDouble;
import org.junit.Test;

import io.sarl.tests.api.AbstractSarlTest;

/**
 * @author $Author: sgalland$
 * @version $FullVersion$
 * @mavengroupid $GroupId$
 * @mavenartifactid $ArtifactId$
 * @see "https://github.com/eclipse/xtext-extras/issues/186"
 */
@SuppressWarnings("all")
public class CodeTest extends AbstractSarlTest {

	private static AtomicInteger left = new AtomicInteger(4);

	@Test
	public void toByte_AtomicInteger() {
		assertEquals(Byte.valueOf((byte) 4), toByte(left));
	}

	@Test
	public void toShort_AtomicInteger() {
		assertEquals(Short.valueOf((short) 4), toShort(left));
	}

	@Test
	public void toInteger_AtomicInteger() {
		assertEquals(4, toInteger(left).intValue());
	}

	@Test
	public void toLong_AtomicInteger() {
		assertEquals(Long.valueOf(4), toLong(left));
	}

	@Test
	public void toAtomicLong_AtomicInteger() {
		assertEquals(4l, toAtomicLong(left).longValue());
	}

	@Test
	public void toFloat_AtomicInteger() {
		assertEpsilonEquals(Float.valueOf(4), toFloat(left));
	}

	@Test
	public void toDouble_AtomicInteger() {
		assertEpsilonEquals(Double.valueOf(4), toDouble(left));
	}

	@Test
	public void toAtomicDouble_AtomicInteger() {
		assertEpsilonEquals(4., toAtomicDouble(left).doubleValue());
	}

}