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

import com.google.inject.Inject;
import org.eclipse.jdt.internal.ui.preferences.OptionsConfigurationBlock;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer;

/** Preferences for the code mining support of SARL.
 *
 * @author $Author: sgalland$
 * @version $FullVersion$
 * @mavengroupid $GroupId$
 * @mavenartifactid $ArtifactId$
 * @since 0.8
 */
public class SARLCodeminingPreferenceAccess {

	/** Prefix for the preference keys.
	 */
	public static final String PREFIX = SARLCodeminingPreferenceAccess.class.getPackage().getName() + "."; //$NON-NLS-1$

	/** Key for saving the enabling state of the codemining feature.
	 */
	public static final String CODEMINING_PROPERTY =  PREFIX + "codemining"; //$NON-NLS-1$

	/** Default value for saving the enabling state of the codemining feature.
	 */
	public static final boolean CODEMINING_DEFAULT_VALUE = true;

	private IPreferenceStoreAccess preferenceStoreAccess;

	/** Change the preference accessor.
	 *
	 * <p>The parameter is a preference store implementation in order to have access to the correct preference set.
	 * It is an implementation choice from {@link OptionsConfigurationBlock}.
	 *
	 * @param preferenceStoreAccess the accessor.
	 */
	@Inject
	public void setPreferenceStoreAccess(IPreferenceStoreAccess preferenceStoreAccess) {
		this.preferenceStoreAccess = preferenceStoreAccess;
	}

	/** Replies the preference accessor.
	 *
	 * @return the accessor.
	 */
	@Inject
	public IPreferenceStoreAccess getPreferenceStoreAccess() {
		return this.preferenceStoreAccess;
	}

	/** Replies the writable preference store to be used for the SARL editor.
	 *
	 * @return the modifiable preference store.
	 * @see #getPreferenceStore()
	 */
	public IPreferenceStore getWritablePreferenceStore() {
		return getPreferenceStoreAccess().getWritablePreferenceStore();
	}

	/** Replies the readable preference store to be used for the SARL editor.
	 *
	 * @return the unmodifiable preference store.
	 * @see #getWritablePreferenceStore()
	 */
	public IPreferenceStore getPreferenceStore() {
		return getPreferenceStoreAccess().getPreferenceStore();
	}

	/** Replies if the codemining feature is enable into the SARL editor.
	 *
	 * @return {@code true} if it is enabled.
	 */
	public boolean isCodeminingEnabled() {
		final IPreferenceStore store = getPreferenceStore();
		return store.getBoolean(CODEMINING_PROPERTY);
	}

	/** Initializer of the preferences for the SARL codemining feature.
	 *
	 * @author $Author: sgalland$
	 * @version $FullVersion$
	 * @mavengroupid $GroupId$
	 * @mavenartifactid $ArtifactId$
	 * @since 0.8
	 */
	public static class Initializer implements IPreferenceStoreInitializer {
		@Override
		public void initialize(IPreferenceStoreAccess access) {
			access.getWritablePreferenceStore().setDefault(CODEMINING_PROPERTY, CODEMINING_DEFAULT_VALUE);
		}
	}

	/** Set the values of the preferences to the default values.
	 */
	public void setToDefault() {
		final IPreferenceStore store = getWritablePreferenceStore();
		store.setToDefault(CODEMINING_PROPERTY);
	}

}
