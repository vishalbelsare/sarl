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

package io.sarl.lang.scoping.extensions.numbers.cast;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import com.google.common.util.concurrent.AtomicDouble;
import org.eclipse.xtext.xbase.lib.Inline;
import org.eclipse.xtext.xbase.lib.Pure;

/** Provide static functions related to the casting of numbers of type {@code Number}.
 *
 * @author $Author: sgalland$
 * @version $FullVersion$
 * @mavengroupid $GroupId$
 * @mavenartifactid $ArtifactId$
 * @since 0.7
 * @see "https://github.com/eclipse/xtext-extras/issues/186"
 */
public final class NumberCastExtensions {

	private NumberCastExtensions() {
		//
	}

	/** Convert the given value to {@code Byte}. This function is not null-safe.
	 *
	 * @param number a number.
	 * @return the equivalent value to {@code number} of {@code Byte} type.
	 */
	@Pure
	@Inline(value = "($1 instanceof $2 ? ($2) $1 : $2.valueOf($1.byteValue()))", imported = Byte.class)
	public static Byte toByte(Number number) {
		return number instanceof Byte ? (Byte) number : Byte.valueOf(number.byteValue());
	}

	/** Convert the given value to {@code Short}. This function is not null-safe.
	 *
	 * @param number a number.
	 * @return the equivalent value to {@code number} of {@code Short} type.
	 */
	@Pure
	@Inline(value = "($1 instanceof $2 ? ($2) $1 : $2.valueOf($1.shortValue()))", imported = Short.class)
	public static Short toShort(Number number) {
		return number instanceof Short ? (Short) number : Short.valueOf(number.shortValue());
	}

	/** Convert the given value to {@code Integer}. This function is not null-safe.
	 *
	 * @param number a number.
	 * @return the equivalent value to {@code number} of {@code Integer} type.
	 */
	@Pure
	@Inline(value = "($1 instanceof $2 ? ($2) $1 : $2.valueOf($1.intValue()))", imported = Integer.class)
	public static Integer toInteger(Number number) {
		return number instanceof Integer ? (Integer) number : Integer.valueOf(number.intValue());
	}

	/** Convert the given value to {@code AtomicInteger}. This function is not null-safe.
	 *
	 * @param number a number.
	 * @return the equivalent value to {@code number} of {@code AtomicInteger} type.
	 */
	@Pure
	@Inline(value = "($1 instanceof $2 ? ($2) $1 : new $2($1.intValue()))", imported = AtomicInteger.class)
	public static AtomicInteger toAtomicInteger(Number number) {
		return number instanceof AtomicInteger ? (AtomicInteger) number : new AtomicInteger(number.intValue());
	}

	/** Convert the given value to {@code Long}. This function is not null-safe.
	 *
	 * @param number a number.
	 * @return the equivalent value to {@code number} of {@code Long} type.
	 */
	@Pure
	@Inline(value = "($1 instanceof $2 ? ($2) $1 : $2.valueOf($1.longValue()))", imported = Long.class)
	public static Long toLong(Number number) {
		return number instanceof Long ? (Long) number : Long.valueOf(number.longValue());
	}

	/** Convert the given value to {@code AtomicLong}. This function is not null-safe.
	 *
	 * @param number a number of {@code Byte} type.
	 * @return the equivalent value to {@code number} of {@code AtomicLong} type.
	 */
	@Pure
	@Inline(value = "($1 instanceof $2 ? ($2) $1 : new $2($1.longValue()))", imported = AtomicLong.class)
	public static AtomicLong toAtomicLong(Number number) {
		return number instanceof AtomicLong ? (AtomicLong) number : new AtomicLong(number.longValue());
	}

	/** Convert the given value to {@code Float}. This function is not null-safe.
	 *
	 * @param number a number.
	 * @return the equivalent value to {@code number} of {@code Float} type.
	 */
	@Pure
	@Inline(value = "($1 instanceof $2 ? ($2) $1 : $2.valueOf($1.floatValue()))", imported = Float.class)
	public static Float toFloat(Number number) {
		return number instanceof Float ? (Float) number : Float.valueOf(number.longValue());
	}

	/** Convert the given value to {@code Double}. This function is not null-safe.
	 *
	 * @param number a number.
	 * @return the equivalent value to {@code number} of {@code Double} type.
	 */
	@Pure
	@Inline(value = "($1 instanceof $2 ? ($2) $1 : $2.valueOf($1.doubleValue()))", imported = Double.class)
	public static Double toDouble(Number number) {
		return number instanceof Double ? (Double) number : Double.valueOf(number.doubleValue());
	}

	/** Convert the given value to {@code AtomicInteger}. This function is not null-safe.
	 *
	 * @param number a number of {@code Byte} type.
	 * @return the equivalent value to {@code number} of {@code AtomicInteger} type.
	 */
	@Pure
	@Inline(value = "($1 instanceof $2 ? ($2) $1 : new $2($1.doubleValue()))", imported = AtomicDouble.class)
	public static AtomicDouble toAtomicDouble(Number number) {
		return number instanceof AtomicDouble ? (AtomicDouble) number : new AtomicDouble(number.doubleValue());
	}

}