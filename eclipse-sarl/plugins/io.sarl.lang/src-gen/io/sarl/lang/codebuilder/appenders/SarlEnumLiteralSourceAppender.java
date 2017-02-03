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

import io.sarl.lang.codebuilder.builders.ISarlEnumLiteralBuilder;
import io.sarl.lang.sarl.SarlEnumLiteral;
import java.io.IOException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.xbase.compiler.ISourceAppender;
import org.eclipse.xtext.xbase.lib.Pure;

/** Source appender of a Sarl SarlEnumLiteral.
 */
@SuppressWarnings("all")
public class SarlEnumLiteralSourceAppender extends AbstractSourceAppender implements ISarlEnumLiteralBuilder {

	private final ISarlEnumLiteralBuilder builder;

	public SarlEnumLiteralSourceAppender(ISarlEnumLiteralBuilder builder) {
		this.builder = builder;
	}

	public void build(ISourceAppender appender) throws IOException {
		build(this.builder.getSarlEnumLiteral(), appender);
	}

	/** Dispose the resource.
	 */
	public void dispose() {
		this.builder.dispose();
	}

	public IJvmTypeProvider getTypeResolutionContext() {
		return this.builder.getTypeResolutionContext();
	}

	/** Initialize the Ecore element.
	 * @param container - the container of the SarlEnumLiteral.
	 * @param name - the name of the SarlEnumLiteral.
	 */
	public void eInit(XtendTypeDeclaration container, String name, IJvmTypeProvider context) {
		this.builder.eInit(container, name, context);
	}

	/** Replies the generated element.
	 */
	@Pure
	public SarlEnumLiteral getSarlEnumLiteral() {
		return this.builder.getSarlEnumLiteral();
	}

	/** Replies the resource.
	 */
	@Pure
	public Resource eResource() {
		return getSarlEnumLiteral().eResource();
	}

	/** Change the documentation of the element.
	 *
	 * <p>The documentation will be displayed just before the element.
	 *
	 * @param doc the documentation.
	 */
	public void setDocumentation(String doc) {
		this.builder.setDocumentation(doc);
	}

	@Override
	@Pure
	public String toString() {
		return this.builder.toString();
	}

}

