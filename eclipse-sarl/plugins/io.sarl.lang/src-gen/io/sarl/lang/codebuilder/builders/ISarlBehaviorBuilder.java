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
package io.sarl.lang.codebuilder.builders;

import io.sarl.lang.sarl.SarlBehavior;
import io.sarl.lang.sarl.SarlScript;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.xbase.lib.Pure;

/** Builder of a Sarl SarlBehavior.
 */
@SuppressWarnings("all")
public interface ISarlBehaviorBuilder {

	/** Replies the context for type resolution.
	 * @return the context or <code>null</code> if the Ecore object is the context.
	 */
	IJvmTypeProvider getTypeResolutionContext();

	/** Dispose the resource.
	 */
	void dispose();

	/** Initialize the Ecore element when inside a script.
	 */
	void eInit(SarlScript script, String name, IJvmTypeProvider context);

	/** Replies the generated SarlBehavior.
	 */
	@Pure
	SarlBehavior getSarlBehavior();

	/** Replies the resource to which the SarlBehavior is attached.
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

	/** Change the super type.
	 * @param superType - the qualified name of the super type,
	 *     or <code>null</code> if the default type.
	 */
	void setExtends(String superType);

	/** Add a modifier.
	 * @param modifier - the modifier to add.
	 */
	void addModifier(String modifier);

	/** Create a SarlConstructor.
	 * @return the builder.
	 */
	ISarlConstructorBuilder addSarlConstructor();

	/** Create a SarlBehaviorUnit.
	 * @param name - the typename of the SarlBehaviorUnit.
	 * @return the builder.
	 */
	ISarlBehaviorUnitBuilder addSarlBehaviorUnit(String name);

	/** Create a SarlField.
	 * @param name - the name of the SarlField.
	 * @return the builder.
	 */
	ISarlFieldBuilder addVarSarlField(String name);

	/** Create a SarlField.
	 * @param name - the name of the SarlField.
	 * @return the builder.
	 */
	ISarlFieldBuilder addValSarlField(String name);

	/** Create a SarlField.	 *
	 * <p>This function is equivalent to {@link #addVarSarlField}.
	 * @param name - the name of the SarlField.
	 * @return the builder.
	 */
	ISarlFieldBuilder addSarlField(String name);

	/** Create a SarlAction.
	 * @param name - the name of the SarlAction.
	 * @return the builder.
	 */
	ISarlActionBuilder addDefSarlAction(String name);

	/** Create a SarlAction.
	 * @param name - the name of the SarlAction.
	 * @return the builder.
	 */
	ISarlActionBuilder addOverrideSarlAction(String name);

	/** Create a SarlAction.	 *
	 * <p>This function is equivalent to {@link #addDefSarlAction}.
	 * @param name - the name of the SarlAction.
	 * @return the builder.
	 */
	ISarlActionBuilder addSarlAction(String name);

	/** Create a SarlClass.
	 * @param name - the name of the SarlClass.
	 * @return the builder.
	 */
	ISarlClassBuilder addSarlClass(String name);

	/** Create a SarlInterface.
	 * @param name - the name of the SarlInterface.
	 * @return the builder.
	 */
	ISarlInterfaceBuilder addSarlInterface(String name);

	/** Create a SarlEnumeration.
	 * @param name - the name of the SarlEnumeration.
	 * @return the builder.
	 */
	ISarlEnumerationBuilder addSarlEnumeration(String name);

	/** Create a SarlAnnotationType.
	 * @param name - the name of the SarlAnnotationType.
	 * @return the builder.
	 */
	ISarlAnnotationTypeBuilder addSarlAnnotationType(String name);

}

