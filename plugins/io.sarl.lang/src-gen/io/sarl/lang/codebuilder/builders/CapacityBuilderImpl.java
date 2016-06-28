/*
 * $Id$
 *
 * File is automatically generated by the Xtext language generator.
 * Do not change it.
 *
 * SARL is an general-purpose agent programming language.
 * More details on http://www.sarl.io
 *
 * Copyright 2014-2016 the original authors and authors.
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

import io.sarl.lang.core.Capacity;
import io.sarl.lang.sarl.SarlCapacity;
import io.sarl.lang.sarl.SarlFactory;
import io.sarl.lang.sarl.SarlScript;
import java.util.function.Predicate;
import javax.inject.Inject;
import javax.inject.Provider;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsFactory;
import org.eclipse.xtext.xbase.compiler.DocumentationAdapter;
import org.eclipse.xtext.xbase.lib.Pure;

/** Builder of a Sarl SarlCapacity.
 */
@SuppressWarnings("all")
public class CapacityBuilderImpl extends AbstractBuilder implements ICapacityBuilder {

	private SarlCapacity sarlCapacity;

	/** Initialize the Ecore element.
	 */
	public void eInit(SarlScript script, String name) {
		if (this.sarlCapacity == null) {
			this.sarlCapacity = SarlFactory.eINSTANCE.createSarlCapacity();
			script.getXtendTypes().add(this.sarlCapacity);
			if (!Strings.isEmpty(name)) {
				this.sarlCapacity.setName(name);
			}
		}
	}

	/** Replies the generated SarlCapacity.
	 */
	@Pure
	public SarlCapacity getSarlCapacity() {
		return this.sarlCapacity;
	}

	/** Replies the resource to which the SarlCapacity is attached.
	 */
	@Pure
	public Resource eResource() {
		return getSarlCapacity().eResource();
	}

	/** Change the documentation of the element.
	 *
	 * <p>The documentation will be displayed just before the element.
	 *
	 * @param doc the documentation.
	 */
	public void setDocumentation(String doc) {
		if (Strings.isEmpty(doc)) {
			getSarlCapacity().eAdapters().removeIf(new Predicate<Adapter>() {
				public boolean test(Adapter adapter) {
					return adapter.isAdapterForType(DocumentationAdapter.class);
				}
			});
		} else {
			DocumentationAdapter adapter = (DocumentationAdapter) EcoreUtil.getExistingAdapter(
					getSarlCapacity(), DocumentationAdapter.class);
			if (adapter == null) {
				adapter = new DocumentationAdapter();
				getSarlCapacity().eAdapters().add(adapter);
			}
			adapter.setDocumentation(doc);
		}
	}

	/** Add the super type.
	 * @param superType - the qualified name of the super type.
	 */
	public void addExtends(String superType) {
		if (!Strings.isEmpty(superType)
				&& !Capacity.class.getName().equals(superType)) {
			JvmParameterizedTypeReference superTypeRef = newTypeRef(this.sarlCapacity, superType);
			JvmTypeReference baseTypeRef = newTypeRef(this.sarlCapacity, Capacity.class);
			if (isSubTypeOf(this.sarlCapacity, superTypeRef, baseTypeRef)) {
				this.sarlCapacity.getExtends().add(superTypeRef);
			}
		}
	}

	/** Add an annotation.
	 * @param type - the qualified name of the annotation.
	 */
	public void addAnnotation(String type) {
		if (!Strings.isEmpty(type)) {
			XAnnotation annotation = XAnnotationsFactory.eINSTANCE.createXAnnotation();
			annotation.setAnnotationType(newTypeRef(sarlCapacity, type).getType());
			this.sarlCapacity.getAnnotations().add(annotation);
		}
	}

	/** Add a modifier.
	 * @param modifier - the modifier to add.
	 */
	public void addModifier(String modifier) {
		if (!Strings.isEmpty(modifier)) {
			this.sarlCapacity.getModifiers().add(modifier);
		}
	}

	@Inject
	private Provider<IActionBuilder> iActionBuilderProvider;

	/** Create an Action.
	 * @param name - the name of the Action.
	 * @return the builder.
	 */
	public IActionBuilder addAction(String name) {
		IActionBuilder builder = this.iActionBuilderProvider.get();
		builder.eInit(getSarlCapacity(), name);
		return builder;
	}

}
