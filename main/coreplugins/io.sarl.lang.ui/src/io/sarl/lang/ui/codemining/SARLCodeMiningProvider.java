/*
 * $Id$
 *
 * SARL is an general-purpose agent programming language.
 * More details on http://www.sarl.io
 *
 * Copyright (C) 2014-2018 the original authors or authors.
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

package io.sarl.lang.ui.codemining;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.inject.Inject;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.codemining.ICodeMining;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.codemining.AbstractXtextCodeMiningProvider;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator;

import io.sarl.lang.services.SARLGrammarAccess;
import io.sarl.lang.services.SARLGrammarKeywordAccess;

/** Provider of a code mining support for SARL.
 *
 * <p>Code Mining shows inline annotations in the text editor that are not part of the text
 * itself, but derived from its contents. It can be very helpful to leverage code
 * minings for example to show inferred types, parameter names for literals and
 * other kind of meta information.
 *
 * @author $Author: sgalland$
 * @version $FullVersion$
 * @mavengroupid $GroupId$
 * @mavenartifactid $ArtifactId$
 * @since 0.8
 * @see "https://blogs.itemis.com/en/code-mining-support-in-xtext"
 */
public class SARLCodeMiningProvider extends AbstractXtextCodeMiningProvider {

	@Inject
	private JvmModelAssociator jvmModelAssocitions;

	@Inject
	private SARLGrammarAccess grammar;

	@Inject
	private SARLGrammarKeywordAccess keywords;

	@Inject
	private SARLCodeminingPreferenceAccess codeminingPreferences;

	@Override
	public CompletableFuture<List<? extends ICodeMining>> provideCodeMinings(ITextViewer viewer, IProgressMonitor monitor) {
		if (this.codeminingPreferences.isCodeminingEnabled()) {
			return super.provideCodeMinings(viewer, monitor);
		}
		return null;
	}

	@Override
	protected void createCodeMinings(IDocument document, XtextResource resource, CancelIndicator indicator,
			IAcceptor<? super ICodeMining> acceptor) throws BadLocationException {
		createImplicitActionReturnType(resource, acceptor);
	}

	/** Add an annotation when the action's return type is implicit and inferred by the SARL compiler.
	 *
	 * @param resource the resource to parse.
	 * @param acceptor the code mining acceptor.
	 */
	@SuppressWarnings("checkstyle:npathcomplexity")
	private void createImplicitActionReturnType(XtextResource resource, IAcceptor<? super ICodeMining> acceptor) {
		final List<XtendFunction> actions = EcoreUtil2.eAllOfType(resource.getContents().get(0), XtendFunction.class);

		for (final XtendFunction action : actions) {
			// inline annotation only for methods with no return type
			if (action.getReturnType() != null) {
				continue;
			}
			// get return type name from operation
			final JvmOperation inferredOperation = (JvmOperation) this.jvmModelAssocitions.getPrimaryJvmElement(action);
			if (inferredOperation == null || inferredOperation.getReturnType() == null) {
				continue;
			}
			// find document offset for inline annotationn
			final ICompositeNode node = NodeModelUtils.findActualNodeFor(action);
			final Keyword parenthesis = this.grammar.getAOPMemberAccess().getRightParenthesisKeyword_2_5_6_2();
			final Assignment fctname = this.grammar.getAOPMemberAccess().getNameAssignment_2_5_5();
			int offsetFctname = -1;
			int offsetParenthesis = -1;
			for (Iterator<INode> it = node.getAsTreeIterable().iterator(); it.hasNext();) {
				final INode child = it.next();
				if (child != node) {
					final EObject grammarElement = child.getGrammarElement();
					if (grammarElement instanceof RuleCall) {
						if (fctname.equals(grammarElement.eContainer())) {
							offsetFctname = child.getTotalEndOffset();
						}
					} else if (parenthesis.equals(grammarElement)) {
						offsetParenthesis = child.getTotalEndOffset();
						break;
					}
				}
			}
			int offset = -1;
			if (offsetParenthesis >= 0) {
				offset = offsetParenthesis;
			} else if (offsetFctname >= 0) {
				offset = offsetFctname;
			}
			if (offset >= 0) {
				final String returnType = inferredOperation.getReturnType().getSimpleName();
				final String text = " " + this.keywords.getColonKeyword() + " " + returnType; //$NON-NLS-1$ //$NON-NLS-2$
				acceptor.accept(createNewLineContentCodeMining(offset, text));
			}
		}
	}

}
