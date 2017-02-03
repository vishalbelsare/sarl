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

import io.sarl.lang.documentation.InnerBlockDocumentationAdapter;
import java.util.function.Predicate;
import javax.inject.Inject;
import javax.inject.Provider;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.tasks.ITaskTagProvider;
import org.eclipse.xtext.tasks.TaskTags;
import org.eclipse.xtext.util.EmfFormatter;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbaseFactory;
import org.eclipse.xtext.xbase.lib.Procedures;
import org.eclipse.xtext.xbase.lib.Pure;

/** Builder of a Sarl XBlockExpression.
 */
@SuppressWarnings("all")
public class BlockExpressionBuilderImpl extends AbstractBuilder implements IBlockExpressionBuilder {

	@Inject
	private ITaskTagProvider taskTagProvider;

	@Inject
	private Provider<IExpressionBuilder> expressionProvider;
	private XBlockExpression block;

	/** Replies the provider of task tags.
	 *
	 * @return the provider.
	 */
	protected ITaskTagProvider getTaskTagProvider() {
		return this.taskTagProvider;
	}

	/** Create the XBlockExpression.
	 */
	public void eInit(IJvmTypeProvider context) {
		setTypeResolutionContext(context);
		if (this.block == null) {
			this.block = XbaseFactory.eINSTANCE.createXBlockExpression();
		}
	}

	/** Replies the string for "auto-generated" comments.
	 * @return the comment text.
	 */
	@Pure
	public String getAutoGeneratedActionString() {
		return getAutoGeneratedActionString(getXBlockExpression().eResource());
	}

	/** Replies the string for "auto-generated" comments.
	 * @param resource the resource for which the comment must be determined.
	 * @return the comment text.
	 */
	@Pure
	public String getAutoGeneratedActionString(Resource resource) {
		TaskTags tags = getTaskTagProvider().getTaskTags(resource);
		String taskTag;
		if (tags != null && tags.getTaskTags() != null && !tags.getTaskTags().isEmpty()) {
			taskTag = tags.getTaskTags().get(0).getName();
		} else {
			taskTag = "TODO";
		}
		return taskTag + " Auto-generated code.";
	}

	/** An empty block expression.
	 * @return the block expression.
	 */
	@Pure
	public XBlockExpression getXBlockExpression() {
		return this.block;
	}

	/** Replies the resource to which the XBlockExpression is attached.
	 */
	@Pure
	public Resource eResource() {
		return getXBlockExpression().eResource();
	}

	/** Change the documentation of the element.
	 *
	 * <p>getXBlockExpression()
	 *
	 * @param doc the documentation.
	 */
	public void setInnerDocumentation(String doc) {
		if (Strings.isEmpty(doc)) {
			getXBlockExpression().eAdapters().removeIf(new Predicate<Adapter>() {
				public boolean test(Adapter adapter) {
					return adapter.isAdapterForType(InnerBlockDocumentationAdapter.class);
				}
			});
		} else {
			InnerBlockDocumentationAdapter adapter = (InnerBlockDocumentationAdapter) EcoreUtil.getExistingAdapter(
					getXBlockExpression(), InnerBlockDocumentationAdapter.class);
			if (adapter == null) {
				adapter = new InnerBlockDocumentationAdapter();
				getXBlockExpression().eAdapters().add(adapter);
			}
			adapter.setDocumentation(doc);
		}
	}

	/** Add an expression inside the block.
	 * @return the expression builder.
	 */
	public IExpressionBuilder addExpression() {
		final IExpressionBuilder builder = this.expressionProvider.get();
		builder.eInit(getXBlockExpression(), new Procedures.Procedure1<XExpression>() {
					private int index = -1;
					public void apply(XExpression it) {
						if (this.index >= 0) {
							getXBlockExpression().getExpressions().set(index, it);
						} else {
							getXBlockExpression().getExpressions().add(it);
							this.index = getXBlockExpression().getExpressions().size() - 1;
						}
					}
				}, getTypeResolutionContext());
		return builder;
	}

	/** Fill the block with the standard "auto-generated" content.
	 * <p>Any previously added content is removed.
	 * @param type - the expected type of the block (the last instruction), or
	    <code>null</code> for no type.
	 */
	public void setDefaultAutoGeneratedContent(String type) {
		getXBlockExpression().getExpressions().clear();
		if (Strings.isEmpty(type)) {
			setInnerDocumentation(getAutoGeneratedActionString());
		} else {
			IExpressionBuilder expr = addExpression();
			String defaultValue = expr.getDefaultValueForType(type);
			if (Strings.isEmpty(defaultValue)) {
				setInnerDocumentation(getAutoGeneratedActionString());
			} else {
				expr.setExpression(defaultValue);
				expr.setDocumentation(getAutoGeneratedActionString());
			}
		}
	}

	@Override
	@Pure
	public String toString() {
		return EmfFormatter.objToStr(getXBlockExpression());
	}

}

