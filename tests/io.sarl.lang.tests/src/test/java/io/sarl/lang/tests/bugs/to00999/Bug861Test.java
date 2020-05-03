/* 
 * $Id$
 * 
 * SARL is an general-purpose agent programming language.
 * More details on http://www.sarl.io
 * 
 * Copyright (C) 2014-2020 the original authors or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.sarl.lang.tests.bugs.to00999;

import static io.sarl.tests.api.tools.TestEObjects.file;
import static io.sarl.tests.api.tools.TestUtils.multilineString;
import static io.sarl.tests.api.tools.TestValidator.validate;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import io.sarl.lang.SARLVersion;
import io.sarl.lang.sarl.SarlPackage;
import io.sarl.lang.sarl.SarlScript;
import io.sarl.tests.api.AbstractSarlTest;
import io.sarl.tests.api.tools.TestValidator.Validator;

/** Tests for issue #861: Cannot use emit function in the Initialize handler.
 * 
 * <p>See: https://github.com/sarl/sarl/issues/861
 * 
 * @author $Author: sgalland$
 * @version $FullVersion$
 * @mavengroupid $GroupId$
 * @mavenartifactid $ArtifactId$
 * @see "https://github.com/sarl/sarl/issues/861"
 * @since 0.11
 */
@DisplayName("Bug #861")
@Tag("core")
public class Bug861Test extends AbstractSarlTest {

	private static final String SNIPSET01 = multilineString(
		"package io.sarl.lang.tests.bug861",
		"import io.sarl.core.DefaultContextInteractions", "import io.sarl.core.Initialize",
		"import io.sarl.core.Lifecycle", "import io.sarl.core.Logging", "", "event Initialized", "event CommitSuicide",
		"", "agent EmptyAgent {", "	uses Lifecycle, DefaultContextInteractions, Logging", "	",
		"	on Initialize {", "		info(\"Empty-Init\")",
		"		emit(new Initialized)[it.UUID == occurrence.spawner]", "	}", "	", "	on CommitSuicide {",
		"		info(\"Empty-Suicide\")", "		killMe", "	}", "}", "", "agent BootAgent {",
		"    uses Lifecycle, DefaultContextInteractions, Logging", "    on Initialize {", "    	info('Boot-Init')",
		"		spawn(EmptyAgent)", "    }", "   ", "	on Initialized {", "		info('Boot-Reception')",
		"		emit(new CommitSuicide)", "	}", "", "	on CommitSuicide {", "		info('Boot-Suicide')",
		"		killMe", "	}", "}");

	private static final String EXPECTED_BOOTAGENT_01 = multilineString(
		"package io.sarl.lang.tests.bug861;",
		"",
		"import io.sarl.core.DefaultContextInteractions;",
		"import io.sarl.core.Initialize;",
		"import io.sarl.core.Lifecycle;",
		"import io.sarl.core.Logging;",
		"import io.sarl.lang.annotation.ImportedCapacityFeature;",
		"import io.sarl.lang.annotation.PerceptGuardEvaluator;",
		"import io.sarl.lang.annotation.SarlElementType;",
		"import io.sarl.lang.annotation.SarlSpecification;",
		"import io.sarl.lang.annotation.SyntheticMember;",
		"import io.sarl.lang.core.Agent;",
		"import io.sarl.lang.core.AtomicSkillReference;",
		"import io.sarl.lang.core.BuiltinCapacitiesProvider;",
		"import io.sarl.lang.core.DynamicSkillProvider;",
		"import io.sarl.lang.tests.bug861.CommitSuicide;",
		"import io.sarl.lang.tests.bug861.EmptyAgent;",
		"import io.sarl.lang.tests.bug861.Initialized;",
		"import java.util.Collection;",
		"import java.util.UUID;", "import javax.inject.Inject;",
		"import org.eclipse.xtext.xbase.lib.Extension;",
		"import org.eclipse.xtext.xbase.lib.Pure;", "",
		"@SarlSpecification(\"" + SARLVersion.SPECIFICATION_RELEASE_VERSION_STRING + "\")",
		"@SarlElementType(" + SarlPackage.SARL_AGENT + ")",
		"@SuppressWarnings(\"all\")",
		"public class BootAgent extends Agent {",
		"  private void $behaviorUnit$Initialize$0(final Initialize occurrence) {",
		"    Logging _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER = this.$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER();",
		"    _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER.info(\"Boot-Init\");",
		"    Lifecycle _$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE$CALLER = this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE$CALLER();",
		"    _$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE$CALLER.spawn(EmptyAgent.class);",
		"  }",
		"  ",
		"  private void $behaviorUnit$Initialized$1(final Initialized occurrence) {",
		"    Logging _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER = this.$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER();",
		"    _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER.info(\"Boot-Reception\");",
		"    DefaultContextInteractions _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER = this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER();",
		"    CommitSuicide _commitSuicide = new CommitSuicide();",
		"    _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER.emit(_commitSuicide);",
		"  }",
		"  ",
		"  private void $behaviorUnit$CommitSuicide$2(final CommitSuicide occurrence) {",
		"    Logging _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER = this.$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER();",
		"    _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER.info(\"Boot-Suicide\");",
		"    Lifecycle _$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE$CALLER = this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE$CALLER();",
		"    _$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE$CALLER.killMe();",
		"  }",
		"  ",
		"  @Extension",
		"  @ImportedCapacityFeature(Lifecycle.class)",
		"  @SyntheticMember",
		"  private transient AtomicSkillReference $CAPACITY_USE$IO_SARL_CORE_LIFECYCLE;",
		"  ",
		"  @SyntheticMember",
		"  @Pure",
		"  private Lifecycle $CAPACITY_USE$IO_SARL_CORE_LIFECYCLE$CALLER() {",
		"    if (this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE == null || this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE.get() == null) {",
		"      this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE = $getSkill(Lifecycle.class);", "    }",
		"    return $castSkill(Lifecycle.class, this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE);",
		"  }",
		"  ",
		"  @Extension",
		"  @ImportedCapacityFeature(DefaultContextInteractions.class)",
		"  @SyntheticMember",
		"  private transient AtomicSkillReference $CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS;",
		"  ",
		"  @SyntheticMember",
		"  @Pure",
		"  private DefaultContextInteractions $CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER() {",
		"    if (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS == null || this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS.get() == null) {",
		"      this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS = $getSkill(DefaultContextInteractions.class);",
		"    }",
		"    return $castSkill(DefaultContextInteractions.class, this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS);",
		"  }",
		"  ",
		"  @Extension",
		"  @ImportedCapacityFeature(Logging.class)",
		"  @SyntheticMember",
		"  private transient AtomicSkillReference $CAPACITY_USE$IO_SARL_CORE_LOGGING;",
		"  ",
		"  @SyntheticMember",
		"  @Pure",
		"  private Logging $CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER() {",
		"    if (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || this.$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) {",
		"      this.$CAPACITY_USE$IO_SARL_CORE_LOGGING = $getSkill(Logging.class);",
		"    }",
		"    return $castSkill(Logging.class, this.$CAPACITY_USE$IO_SARL_CORE_LOGGING);",
		"  }",
		"  ",
		"  @SyntheticMember",
		"  @PerceptGuardEvaluator",
		"  private void $guardEvaluator$Initialize(final Initialize occurrence, final Collection<Runnable> ___SARLlocal_runnableCollection) {",
		"    assert occurrence != null;",
		"    assert ___SARLlocal_runnableCollection != null;",
		"    ___SARLlocal_runnableCollection.add(() -> $behaviorUnit$Initialize$0(occurrence));",
		"  }",
		"  ",
		"  @SyntheticMember",
		"  @PerceptGuardEvaluator",
		"  private void $guardEvaluator$CommitSuicide(final CommitSuicide occurrence, final Collection<Runnable> ___SARLlocal_runnableCollection) {",
		"    assert occurrence != null;",
		"    assert ___SARLlocal_runnableCollection != null;",
		"    ___SARLlocal_runnableCollection.add(() -> $behaviorUnit$CommitSuicide$2(occurrence));",
		"  }",
		"  ",
		"  @SyntheticMember",
		"  @PerceptGuardEvaluator",
		"  private void $guardEvaluator$Initialized(final Initialized occurrence, final Collection<Runnable> ___SARLlocal_runnableCollection) {",
		"    assert occurrence != null;",
		"    assert ___SARLlocal_runnableCollection != null;",
		"    ___SARLlocal_runnableCollection.add(() -> $behaviorUnit$Initialized$1(occurrence));",
		"  }",
		"  ",
		"  @SyntheticMember",
		"  public BootAgent(final UUID arg0, final UUID arg1) {",
		"    super(arg0, arg1);",
		"  }",
		"  ",
		"  @SyntheticMember",
		"  @Deprecated",
		"  @Inject",
		"  public BootAgent(final BuiltinCapacitiesProvider arg0, final UUID arg1, final UUID arg2) {",
		"    super(arg0, arg1, arg2);",
		"  }",
		"  ",
		"  @SyntheticMember",
		"  @Inject",
		"  public BootAgent(final UUID arg0, final UUID arg1, final DynamicSkillProvider arg2) {",
		"    super(arg0, arg1, arg2);",
		"  }",
		"}",
		"");

	private static final String EXPECTED_EMPTYAGENT_01 = multilineString(
		"package io.sarl.lang.tests.bug861;",
		"",
		"import com.google.common.base.Objects;",
		"import io.sarl.core.DefaultContextInteractions;",
		"import io.sarl.core.Initialize;",
		"import io.sarl.core.Lifecycle;",
		"import io.sarl.core.Logging;",
		"import io.sarl.lang.annotation.ImportedCapacityFeature;",
		"import io.sarl.lang.annotation.PerceptGuardEvaluator;",
		"import io.sarl.lang.annotation.SarlElementType;",
		"import io.sarl.lang.annotation.SarlSpecification;",
		"import io.sarl.lang.annotation.SyntheticMember;",
		"import io.sarl.lang.core.Address;",
		"import io.sarl.lang.core.Agent;",
		"import io.sarl.lang.core.AtomicSkillReference;",
		"import io.sarl.lang.core.BuiltinCapacitiesProvider;",
		"import io.sarl.lang.core.DynamicSkillProvider;",
		"import io.sarl.lang.core.Scope;",
		"import io.sarl.lang.tests.bug861.CommitSuicide;",
		"import io.sarl.lang.tests.bug861.Initialized;",
		"import io.sarl.lang.util.SerializableProxy;",
		"import java.io.ObjectStreamException;",
		"import java.util.Collection;",
		"import java.util.UUID;",
		"import javax.inject.Inject;",
		"import org.eclipse.xtext.xbase.lib.Extension;",
		"import org.eclipse.xtext.xbase.lib.Pure;", "",
		"@SarlSpecification(\"" + SARLVersion.SPECIFICATION_RELEASE_VERSION_STRING + "\")",
		"@SarlElementType(" + SarlPackage.SARL_AGENT + ")",
		"@SuppressWarnings(\"all\")",
		"public class EmptyAgent extends Agent {",
		"  private void $behaviorUnit$Initialize$0(final Initialize occurrence) {",
		"    Logging _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER = this.$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER();",
		"    _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER.info(\"Empty-Init\");",
		"    DefaultContextInteractions _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER = this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER();",
		"    Initialized _initialized = new Initialized();",
		"    class $SerializableClosureProxy implements Scope<Address> {",
		"      ",
		"      private final UUID $_spawner;",
		"      ",
		"      public $SerializableClosureProxy(final UUID $_spawner) {",
		"        this.$_spawner = $_spawner;",
		"      }",
		"      ",
		"      @Override",
		"      public boolean matches(final Address it) {",
		"        UUID _uUID = it.getUUID();",
		"        return Objects.equal(_uUID, $_spawner);",
		"      }",
		"    }",
		"    final Scope<Address> _function = new Scope<Address>() {",
		"      @Override",
		"      public boolean matches(final Address it) {",
		"        UUID _uUID = it.getUUID();",
		"        return Objects.equal(_uUID, occurrence.spawner);",
		"      }",
		"      private Object writeReplace() throws ObjectStreamException {",
		"        return new SerializableProxy($SerializableClosureProxy.class, occurrence.spawner);",
		"      }",
		"    };",
		"    _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER.emit(_initialized, _function);",
		"  }",
		"  ",
		"  private void $behaviorUnit$CommitSuicide$1(final CommitSuicide occurrence) {",
		"    Logging _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER = this.$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER();",
		"    _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER.info(\"Empty-Suicide\");",
		"    Lifecycle _$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE$CALLER = this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE$CALLER();",
		"    _$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE$CALLER.killMe();",
		"  }",
		"  ",
		"  @Extension",
		"  @ImportedCapacityFeature(Lifecycle.class)",
		"  @SyntheticMember",
		"  private transient AtomicSkillReference $CAPACITY_USE$IO_SARL_CORE_LIFECYCLE;",
		"  ",
		"  @SyntheticMember",
		"  @Pure",
		"  private Lifecycle $CAPACITY_USE$IO_SARL_CORE_LIFECYCLE$CALLER() {",
		"    if (this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE == null || this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE.get() == null) {",
		"      this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE = $getSkill(Lifecycle.class);",
		"    }",
		"    return $castSkill(Lifecycle.class, this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE);",
		"  }",
		"  ",
		"  @Extension",
		"  @ImportedCapacityFeature(DefaultContextInteractions.class)",
		"  @SyntheticMember",
		"  private transient AtomicSkillReference $CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS;",
		"  ",
		"  @SyntheticMember",
		"  @Pure",
		"  private DefaultContextInteractions $CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER() {",
		"    if (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS == null || this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS.get() == null) {",
		"      this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS = $getSkill(DefaultContextInteractions.class);",
		"    }",
		"    return $castSkill(DefaultContextInteractions.class, this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS);",
		"  }",
		"  ",
		"  @Extension",
		"  @ImportedCapacityFeature(Logging.class)",
		"  @SyntheticMember",
		"  private transient AtomicSkillReference $CAPACITY_USE$IO_SARL_CORE_LOGGING;",
		"  ",
		"  @SyntheticMember",
		"  @Pure",
		"  private Logging $CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER() {",
		"    if (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || this.$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) {",
		"      this.$CAPACITY_USE$IO_SARL_CORE_LOGGING = $getSkill(Logging.class);",
		"    }",
		"    return $castSkill(Logging.class, this.$CAPACITY_USE$IO_SARL_CORE_LOGGING);",
		"  }",
		"  ",
		"  @SyntheticMember",
		"  @PerceptGuardEvaluator",
		"  private void $guardEvaluator$Initialize(final Initialize occurrence, final Collection<Runnable> ___SARLlocal_runnableCollection) {",
		"    assert occurrence != null;",
		"    assert ___SARLlocal_runnableCollection != null;",
		"    ___SARLlocal_runnableCollection.add(() -> $behaviorUnit$Initialize$0(occurrence));",
		"  }",
		"  ",
		"  @SyntheticMember",
		"  @PerceptGuardEvaluator",
		"  private void $guardEvaluator$CommitSuicide(final CommitSuicide occurrence, final Collection<Runnable> ___SARLlocal_runnableCollection) {",
		"    assert occurrence != null;",
		"    assert ___SARLlocal_runnableCollection != null;",
		"    ___SARLlocal_runnableCollection.add(() -> $behaviorUnit$CommitSuicide$1(occurrence));",
		"  }",
		"  ",
		"  @SyntheticMember",
		"  public EmptyAgent(final UUID arg0, final UUID arg1) {",
		"    super(arg0, arg1);",
		"  }",
		"  ",
		"  @SyntheticMember",
		"  @Deprecated",
		"  @Inject",
		"  public EmptyAgent(final BuiltinCapacitiesProvider arg0, final UUID arg1, final UUID arg2) {",
		"    super(arg0, arg1, arg2);",
		"  }",
		"  ",
		"  @SyntheticMember",
		"  @Inject",
		"  public EmptyAgent(final UUID arg0, final UUID arg1, final DynamicSkillProvider arg2) {",
		"    super(arg0, arg1, arg2);",
		"  }",
		"}",
		"");

	@Test
	@Tag("sarlValidation")
	public void parsing_01() throws Exception {
		SarlScript mas = file(getParseHelper(), SNIPSET01);
		Validator validator = validate(getValidationHelper(), getInjector(), mas);
		validator.assertNoErrors();
	}

	@Test
	@Tag("compileToJava")
	public void compiling_01() throws Exception {
		getCompileHelper().compile(SNIPSET01, it -> {
			assertEquals(EXPECTED_BOOTAGENT_01, it.getGeneratedCode("io.sarl.lang.tests.bug861.BootAgent"));
			assertEquals(EXPECTED_EMPTYAGENT_01, it.getGeneratedCode("io.sarl.lang.tests.bug861.EmptyAgent"));
		});
	}

}
