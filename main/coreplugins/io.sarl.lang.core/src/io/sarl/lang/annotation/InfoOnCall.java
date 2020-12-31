/*
 * $Id$
 *
 * SARL is an general-purpose agent programming language.
 * More details on http://www.sarl.io
 *
 * Copyright (C) 2014-2021 the original authors or authors.
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

package io.sarl.lang.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** Annotation for marking an element with a SARL compiler issue than the element is invoked from the SARL code.
 *
 * @author $Author: sgalland$
 * @version $FullVersion$
 * @mavengroupid $GroupId$
 * @mavenartifactid $ArtifactId$
 * @since 0.12
 */
@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD })
@Retention(RetentionPolicy.CLASS)
public @interface InfoOnCall {

	/** Replies the message to provide to the SARL developer.
	 *
	 * @return the issue message. If empty or {@code null}, no issue will be generated by the compiler.
	 */
	String value();

	/** Replies if the issue is always an error.
	 * It not, the result of {@link #warning()} is used.
	 *
	 * @return {@code true} if it is an error; {@code false} if the error level depends on {@link #warning()}.
	 * @see #warning()
	 */
	boolean error() default false;

	/** Replies if the issue is always a warning.
	 * If the function {@link #error()} replies {@code true}, the result of this function should be ignored.
	 * If this function replies {@code true}, the message is a warning message.
	 * It not, the result of {@link #info()} is used.
	 *
	 * @return {@code true} if it is a warning; {@code false} if the error level depends on {@link #info()}.
	 * @see #error()
	 * @see #info()
	 */
	boolean warning() default false;

	/** Replies if the issue is always a warning.
	 * If one of the functions {@link #error()} or {@link #warning()} replies {@code true},
	 * the result of this function should be ignored.
	 * If this function replies {@code true}, the message is an information message.
	 * If this function replies {@code false}, the message level depends on the user preferences.
	 * In this last case, the error level could be "error", "warning", "info", or "ignore"
	 *
	 * @return {@code true} if it is an information message; {@code false} if the error level depends the user preferences.
	 * @see #error()
	 * @see #warning()
	 */
	boolean info() default false;

}
