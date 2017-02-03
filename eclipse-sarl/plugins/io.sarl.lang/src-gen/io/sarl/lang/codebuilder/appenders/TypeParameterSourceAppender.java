/*
 * $Id$
 *
 * File is automatically generated by the Xtext language generator.
 * Do not change it.
 *
 * SARL is an general-purpose agent programming language.
 * More details on http://www.sarl.io
 *
 * Copyright 2014-2017 the original authors and authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.sarl.lang.codebuilder.appenders;

import io.sarl.lang.codebuilder.builders.ITypeParameterBuilder;
import java.io.IOException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.xbase.compiler.ISourceAppender;
import org.eclipse.xtext.xbase.lib.Pure;

/** Appender of a Sarl type parameter.
 */
@SuppressWarnings("all")
public class TypeParameterSourceAppender extends AbstractSourceAppender implements ITypeParameterBuilder {

	private final ITypeParameterBuilder builder;

	public TypeParameterSourceAppender(ITypeParameterBuilder builder) {
		this.builder = builder;
	}

	public void build(ISourceAppender appender) throws IOException {
		build(this.builder.getJvmTypeParameter(), appender);
	}

	/** Initialize the type parameter.
	 * <p>Caution: This initialization function does not add the type parameter in its container.
	 * The container is responsible of adding the type parameter in its internal object.
	 * @param name - the name of the type parameter.
	 * @param typeContext - the provider of types or null.
	 */
	public void eInit(EObject context, String name, IJvmTypeProvider typeContext) {
		this.builder.eInit(context, name, typeContext);
	}

	public IJvmTypeProvider getTypeResolutionContext() {
		return this.builder.getTypeResolutionContext();
	}

	/** Replies the created parameter.
	 *
	 * @return the parameter.
	 */
	@Pure
	public JvmTypeParameter getJvmTypeParameter() {
		return this.builder.getJvmTypeParameter();
	}

	/** Replies the resource to which the type parameter is attached.
	 */
	@Pure
	public Resource eResource() {
		return getJvmTypeParameter().eResource();
	}

	/** Dispose the resource.
	 */
	public void dispose() {
		this.builder.dispose();
	}

	/** Add upper type bounds.
	 * @param type the type.
	 */
	public void addUpperConstraint(String type) {
		this.builder.addUpperConstraint(type);
	}

	/** Add lower type bounds.
	 * @param type the type.
	 */
	public void addLowerConstraint(String type) {
		this.builder.addLowerConstraint(type);
	}

}

