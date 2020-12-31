/*
 * $Id$
 *
 * File is automatically generated by the Xtext language generator.
 * Do not change it.
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
package io.sarl.lang.codebuilder.builders;

import io.sarl.lang.sarl.SarlEnumLiteral;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.xbase.lib.Pure;

/** Builder of a Sarl SarlEnumLiteral.
 */
@SuppressWarnings("all")
public interface ISarlEnumLiteralBuilder {

	/** Find the reference to the type with the given name.
	 * @param typeName the fully qualified name of the type
	 * @return the type reference.
	 */
	JvmParameterizedTypeReference newTypeRef(String typeName);

	/** Find the reference to the type with the given name.
	 * @param context the context for the type reference use
	 * @param typeName the fully qualified name of the type
	 * @return the type reference.
	 */
	JvmParameterizedTypeReference newTypeRef(Notifier context, String typeName);

	/** Dispose the resource.
	 */
	void dispose();

	/** Replies the context for type resolution.
	 * @return the context or {@code null} if the Ecore object is the context.
	 */
	IJvmTypeProvider getTypeResolutionContext();

	/** Initialize the Ecore element.
	 * @param container the container of the SarlEnumLiteral.
	 * @param name the name of the SarlEnumLiteral.
	 */
	void eInit(XtendTypeDeclaration container, String name, IJvmTypeProvider context);

	/** Replies the generated element.
	 */
	@Pure
	SarlEnumLiteral getSarlEnumLiteral();

	/** Replies the resource.
	 */
	@Pure
	Resource eResource();

	/** Change the documentation of the element.
	 *
	 * <p>The documentation will be displayed just before the element.
	 *
	 * @param doc the documentation.
	 */
	void setDocumentation(String doc);

}

