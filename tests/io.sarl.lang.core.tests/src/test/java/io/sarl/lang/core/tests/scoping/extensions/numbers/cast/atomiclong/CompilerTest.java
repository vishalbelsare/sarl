/*
 * $Id$
 *
 * SARL is an general-purpose agent programming language.
 * More details on http://www.sarl.io
 *
 * Copyright (C) 2014-2020 the original authors or authors.
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

package io.sarl.lang.core.tests.scoping.extensions.numbers.cast.atomiclong;

import static io.sarl.tests.api.tools.TestEObjects.file;
import static io.sarl.tests.api.tools.TestUtils.multilineString;
import static io.sarl.tests.api.tools.TestValidator.validate;

import org.eclipse.xtext.common.types.TypesPackage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import io.sarl.lang.SARLVersion;
import io.sarl.lang.sarl.SarlPackage;
import io.sarl.lang.sarl.SarlScript;
import io.sarl.lang.validation.IssueCodes;
import io.sarl.tests.api.AbstractSarlTest;
import io.sarl.tests.api.globalcompilation.GlobalCompilationSuite;
import io.sarl.tests.api.globalcompilation.GlobalCompilationTestContribution;
import io.sarl.tests.api.globalcompilation.ResourceSetGlobalCompilationContext;

/**
 * @author $Author: sgalland$
 * @version $FullVersion$
 * @mavengroupid $GroupId$
 * @mavenartifactid $ArtifactId$
 * @see "https://github.com/eclipse/xtext-extras/issues/186"
 */
@GlobalCompilationSuite
@SuppressWarnings("all")
@DisplayName("Compiling atomic long cast operator")
@Tag("core")
@Tag("compileToJava")
public class CompilerTest extends AbstractSarlTest {

	private static final String AS_BYTE_SARL = multilineString(
			"import java.util.concurrent.atomic.AtomicLong",
			"class A {",
			"  def fct(left : AtomicLong) : byte {",
			"    left as byte",
			"  }",
			"}");

	private static final String AS_BYTE_JAVA = multilineString(
			"import io.sarl.lang.annotation.SarlElementType;",
			"import io.sarl.lang.annotation.SarlSpecification;",
			"import io.sarl.lang.annotation.SyntheticMember;",
			"import java.util.concurrent.atomic.AtomicLong;",
			"import org.eclipse.xtext.xbase.lib.Pure;",
			"",
			"@SarlSpecification(\"" + SARLVersion.SPECIFICATION_RELEASE_VERSION_STRING + "\")",
			"@SarlElementType(" + SarlPackage.SARL_CLASS + ")",
			"@SuppressWarnings(\"all\")",
			"public class A {",
			"  @Pure",
			"  public byte fct(final AtomicLong left) {",
			"    return (left == null ? 0 : left.byteValue());",
			"  }",
			"  ",
			"  @SyntheticMember",
			"  public A() {",
			"    super();",
			"  }",
			"}",
			"");

	@Test
	public void as_byte_issues() throws Exception {
		validate(getValidationHelper(), getInjector(), file(getParseHelper(), AS_BYTE_SARL))
		.assertNoErrors(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				org.eclipse.xtext.xbase.validation.IssueCodes.INVALID_CAST)
		.assertNoWarnings(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				org.eclipse.xtext.xbase.validation.IssueCodes.OBSOLETE_CAST)
		.assertWarning(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				IssueCodes.POTENTIAL_INEFFICIENT_VALUE_CONVERSION,
				"'byteValue'");
	}

	@GlobalCompilationTestContribution
	public static void as_byte(ResourceSetGlobalCompilationContext ctx) throws Exception {
		ctx.compileTo(AS_BYTE_SARL, AS_BYTE_JAVA);
	}

	private static final String AS_SHORT_SARL = multilineString(
			"import java.util.concurrent.atomic.AtomicLong",
			"class A {",
			"  def fct(left : AtomicLong) : short {",
			"    left as short",
			"  }",
			"}");

	private static final String AS_SHORT_JAVA = multilineString(
			"import io.sarl.lang.annotation.SarlElementType;",
			"import io.sarl.lang.annotation.SarlSpecification;",
			"import io.sarl.lang.annotation.SyntheticMember;",
			"import java.util.concurrent.atomic.AtomicLong;",
			"import org.eclipse.xtext.xbase.lib.Pure;",
			"",
			"@SarlSpecification(\"" + SARLVersion.SPECIFICATION_RELEASE_VERSION_STRING + "\")",
			"@SarlElementType(" + SarlPackage.SARL_CLASS + ")",
			"@SuppressWarnings(\"all\")",
			"public class A {",
			"  @Pure",
			"  public short fct(final AtomicLong left) {",
			"    return (left == null ? 0 : left.shortValue());",
			"  }",
			"  ",
			"  @SyntheticMember",
			"  public A() {",
			"    super();",
			"  }",
			"}",
			"");

	@Test
	public void as_short_issues() throws Exception {
		validate(getValidationHelper(), getInjector(), file(getParseHelper(), AS_SHORT_SARL))
		.assertNoErrors(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				org.eclipse.xtext.xbase.validation.IssueCodes.INVALID_CAST)
		.assertNoWarnings(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				org.eclipse.xtext.xbase.validation.IssueCodes.OBSOLETE_CAST)
		.assertWarning(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				IssueCodes.POTENTIAL_INEFFICIENT_VALUE_CONVERSION,
				"'shortValue'");
	}

	@GlobalCompilationTestContribution
	public static void as_short(ResourceSetGlobalCompilationContext ctx) throws Exception {
		ctx.compileTo(AS_SHORT_SARL, AS_SHORT_JAVA);
	}

	private static final String AS_INT_SARL = multilineString(
			"import java.util.concurrent.atomic.AtomicLong",
			"class A {",
			"  def fct(left : AtomicLong) : int {",
			"    left as int",
			"  }",
			"}");

	private static final String AS_INT_JAVA = multilineString(
			"import io.sarl.lang.annotation.SarlElementType;",
			"import io.sarl.lang.annotation.SarlSpecification;",
			"import io.sarl.lang.annotation.SyntheticMember;",
			"import java.util.concurrent.atomic.AtomicLong;",
			"import org.eclipse.xtext.xbase.lib.Pure;",
			"",
			"@SarlSpecification(\"" + SARLVersion.SPECIFICATION_RELEASE_VERSION_STRING + "\")",
			"@SarlElementType(" + SarlPackage.SARL_CLASS + ")",
			"@SuppressWarnings(\"all\")",
			"public class A {",
			"  @Pure",
			"  public int fct(final AtomicLong left) {",
			"    return (left == null ? 0 : left.intValue());",
			"  }",
			"  ",
			"  @SyntheticMember",
			"  public A() {",
			"    super();",
			"  }",
			"}",
			"");

	@Test
	public void as_int_issues() throws Exception {
		validate(getValidationHelper(), getInjector(), file(getParseHelper(), AS_INT_SARL))
		.assertNoErrors(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				org.eclipse.xtext.xbase.validation.IssueCodes.INVALID_CAST)
		.assertNoWarnings(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				org.eclipse.xtext.xbase.validation.IssueCodes.OBSOLETE_CAST)
		.assertWarning(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				IssueCodes.POTENTIAL_INEFFICIENT_VALUE_CONVERSION,
				"'intValue'");
	}

	@GlobalCompilationTestContribution
	public static void as_int(ResourceSetGlobalCompilationContext ctx) throws Exception {
		ctx.compileTo(AS_INT_SARL, AS_INT_JAVA);
	}

	private static final String AS_LONG_SARL = multilineString(
			"import java.util.concurrent.atomic.AtomicLong",
			"class A {",
			"  def fct(left : AtomicLong) : long {",
			"    left as long",
			"  }",
			"}");

	private static final String AS_LONG_JAVA = multilineString(
			"import io.sarl.lang.annotation.SarlElementType;",
			"import io.sarl.lang.annotation.SarlSpecification;",
			"import io.sarl.lang.annotation.SyntheticMember;",
			"import java.util.concurrent.atomic.AtomicLong;",
			"import org.eclipse.xtext.xbase.lib.Pure;",
			"",
			"@SarlSpecification(\"" + SARLVersion.SPECIFICATION_RELEASE_VERSION_STRING + "\")",
			"@SarlElementType(" + SarlPackage.SARL_CLASS + ")",
			"@SuppressWarnings(\"all\")",
			"public class A {",
			"  @Pure",
			"  public long fct(final AtomicLong left) {",
			"    return (left == null ? 0 : left.longValue());",
			"  }",
			"  ",
			"  @SyntheticMember",
			"  public A() {",
			"    super();",
			"  }",
			"}",
			"");

	@Test
	public void as_long_issues() throws Exception {
		validate(getValidationHelper(), getInjector(), file(getParseHelper(), AS_LONG_SARL))
		.assertNoErrors(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				org.eclipse.xtext.xbase.validation.IssueCodes.INVALID_CAST)
		.assertNoWarnings(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				org.eclipse.xtext.xbase.validation.IssueCodes.OBSOLETE_CAST)
		.assertWarning(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				IssueCodes.POTENTIAL_INEFFICIENT_VALUE_CONVERSION,
				"'longValue'");
	}

	@GlobalCompilationTestContribution
	public static void as_long(ResourceSetGlobalCompilationContext ctx) throws Exception {
		ctx.compileTo(AS_LONG_SARL, AS_LONG_JAVA);
	}

	private static final String AS_FLOAT_SARL = multilineString(
			"import java.util.concurrent.atomic.AtomicLong",
			"class A {",
			"  def fct(left : AtomicLong) : float {",
			"    left as float",
			"  }",
			"}");

	private static final String AS_FLOAT_JAVA = multilineString(
			"import io.sarl.lang.annotation.SarlElementType;",
			"import io.sarl.lang.annotation.SarlSpecification;",
			"import io.sarl.lang.annotation.SyntheticMember;",
			"import java.util.concurrent.atomic.AtomicLong;",
			"import org.eclipse.xtext.xbase.lib.Pure;",
			"",
			"@SarlSpecification(\"" + SARLVersion.SPECIFICATION_RELEASE_VERSION_STRING + "\")",
			"@SarlElementType(" + SarlPackage.SARL_CLASS + ")",
			"@SuppressWarnings(\"all\")",
			"public class A {",
			"  @Pure",
			"  public float fct(final AtomicLong left) {",
			"    return (left == null ? 0 : left.floatValue());",
			"  }",
			"  ",
			"  @SyntheticMember",
			"  public A() {",
			"    super();",
			"  }",
			"}",
			"");

	@Test
	public void as_float_issues() throws Exception {
		validate(getValidationHelper(), getInjector(), file(getParseHelper(), AS_FLOAT_SARL))
		.assertNoErrors(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				org.eclipse.xtext.xbase.validation.IssueCodes.INVALID_CAST)
		.assertNoWarnings(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				org.eclipse.xtext.xbase.validation.IssueCodes.OBSOLETE_CAST)
		.assertWarning(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				IssueCodes.POTENTIAL_INEFFICIENT_VALUE_CONVERSION,
				"'floatValue'");
	}

	@GlobalCompilationTestContribution
	public static void as_float(ResourceSetGlobalCompilationContext ctx) throws Exception {
		ctx.compileTo(AS_FLOAT_SARL, AS_FLOAT_JAVA);
	}

	private static final String AS_DOUBLE_SARL = multilineString(
			"import java.util.concurrent.atomic.AtomicLong",
			"class A {",
			"  def fct(left : AtomicLong) : double {",
			"    left as double",
			"  }",
			"}");

	private static final String AS_DOUBLE_JAVA = multilineString(
			"import io.sarl.lang.annotation.SarlElementType;",
			"import io.sarl.lang.annotation.SarlSpecification;",
			"import io.sarl.lang.annotation.SyntheticMember;",
			"import java.util.concurrent.atomic.AtomicLong;",
			"import org.eclipse.xtext.xbase.lib.Pure;",
			"",
			"@SarlSpecification(\"" + SARLVersion.SPECIFICATION_RELEASE_VERSION_STRING + "\")",
			"@SarlElementType(" + SarlPackage.SARL_CLASS + ")",
			"@SuppressWarnings(\"all\")",
			"public class A {",
			"  @Pure",
			"  public double fct(final AtomicLong left) {",
			"    return (left == null ? 0 : left.doubleValue());",
			"  }",
			"  ",
			"  @SyntheticMember",
			"  public A() {",
			"    super();",
			"  }",
			"}",
			"");

	@Test
	public void as_double_issues() throws Exception {
		validate(getValidationHelper(), getInjector(), file(getParseHelper(), AS_DOUBLE_SARL))
		.assertNoErrors(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				org.eclipse.xtext.xbase.validation.IssueCodes.INVALID_CAST)
		.assertNoWarnings(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				org.eclipse.xtext.xbase.validation.IssueCodes.OBSOLETE_CAST)
		.assertWarning(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				IssueCodes.POTENTIAL_INEFFICIENT_VALUE_CONVERSION);
	}

	@GlobalCompilationTestContribution
	public static void as_double(ResourceSetGlobalCompilationContext ctx) throws Exception {
		ctx.compileTo(AS_DOUBLE_SARL, AS_DOUBLE_JAVA);
	}

	private static final String AS_BYTE_OBJECT_SARL = multilineString(
			"import java.util.concurrent.atomic.AtomicLong",
			"class A {",
			"  def fct(left : AtomicLong) : Byte {",
			"    left as Byte",
			"  }",
			"}");

	private static final String AS_BYTE_OBJECT_JAVA = multilineString(
			"import io.sarl.lang.annotation.SarlElementType;",
			"import io.sarl.lang.annotation.SarlSpecification;",
			"import io.sarl.lang.annotation.SyntheticMember;",
			"import java.util.concurrent.atomic.AtomicLong;",
			"import org.eclipse.xtext.xbase.lib.Pure;",
			"",
			"@SarlSpecification(\"" + SARLVersion.SPECIFICATION_RELEASE_VERSION_STRING + "\")",
			"@SarlElementType(" + SarlPackage.SARL_CLASS + ")",
			"@SuppressWarnings(\"all\")",
			"public class A {",
			"  @Pure",
			"  public Byte fct(final AtomicLong left) {",
			"    return (left == null ? null : Byte.valueOf(left.byteValue()));",
			"  }",
			"  ",
			"  @SyntheticMember",
			"  public A() {",
			"    super();",
			"  }",
			"}",
			"");

	@Test
	public void as_Byte_issues() throws Exception {
		validate(getValidationHelper(), getInjector(), file(getParseHelper(), AS_BYTE_OBJECT_SARL))
		.assertNoErrors(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				org.eclipse.xtext.xbase.validation.IssueCodes.INVALID_CAST)
		.assertNoWarnings(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				org.eclipse.xtext.xbase.validation.IssueCodes.OBSOLETE_CAST)
		.assertWarning(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				IssueCodes.POTENTIAL_INEFFICIENT_VALUE_CONVERSION,
				"'toByte'");
	}

	@GlobalCompilationTestContribution
	public static void as_Byte(ResourceSetGlobalCompilationContext ctx) throws Exception {
		ctx.compileTo(AS_BYTE_OBJECT_SARL, AS_BYTE_OBJECT_JAVA);
	}

	private static final String AS_SHORT_OBJECT_SARL = multilineString(
			"import java.util.concurrent.atomic.AtomicLong",
			"class A {",
			"  def fct(left : AtomicLong) : Short {",
			"    left as Short",
			"  }",
			"}");

	private static final String AS_SHORT_OBJECT_JAVA = multilineString(
			"import io.sarl.lang.annotation.SarlElementType;",
			"import io.sarl.lang.annotation.SarlSpecification;",
			"import io.sarl.lang.annotation.SyntheticMember;",
			"import java.util.concurrent.atomic.AtomicLong;",
			"import org.eclipse.xtext.xbase.lib.Pure;",
			"",
			"@SarlSpecification(\"" + SARLVersion.SPECIFICATION_RELEASE_VERSION_STRING + "\")",
			"@SarlElementType(" + SarlPackage.SARL_CLASS + ")",
			"@SuppressWarnings(\"all\")",
			"public class A {",
			"  @Pure",
			"  public Short fct(final AtomicLong left) {",
			"    return (left == null ? null : Short.valueOf(left.shortValue()));",
			"  }",
			"  ",
			"  @SyntheticMember",
			"  public A() {",
			"    super();",
			"  }",
			"}",
			"");

	@Test
	public void as_Short_issues() throws Exception {
		validate(getValidationHelper(), getInjector(), file(getParseHelper(), AS_SHORT_OBJECT_SARL))
		.assertNoErrors(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				org.eclipse.xtext.xbase.validation.IssueCodes.INVALID_CAST)
		.assertNoWarnings(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				org.eclipse.xtext.xbase.validation.IssueCodes.OBSOLETE_CAST)
		.assertWarning(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				IssueCodes.POTENTIAL_INEFFICIENT_VALUE_CONVERSION,
				"'toShort'");
	}

	@GlobalCompilationTestContribution
	public static void as_Short(ResourceSetGlobalCompilationContext ctx) throws Exception {
		ctx.compileTo(AS_SHORT_OBJECT_SARL, AS_SHORT_OBJECT_JAVA);
	}

	private static final String AS_INTEGER_OBJECT_SARL = multilineString(
			"import java.util.concurrent.atomic.AtomicLong",
			"class A {",
			"  def fct(left : AtomicLong) : Integer {",
			"    left as Integer",
			"  }",
			"}");

	private static final String AS_INTEGER_OBJECT_JAVA = multilineString(
			"import io.sarl.lang.annotation.SarlElementType;",
			"import io.sarl.lang.annotation.SarlSpecification;",
			"import io.sarl.lang.annotation.SyntheticMember;",
			"import java.util.concurrent.atomic.AtomicLong;",
			"import org.eclipse.xtext.xbase.lib.Pure;",
			"",
			"@SarlSpecification(\"" + SARLVersion.SPECIFICATION_RELEASE_VERSION_STRING + "\")",
			"@SarlElementType(" + SarlPackage.SARL_CLASS + ")",
			"@SuppressWarnings(\"all\")",
			"public class A {",
			"  @Pure",
			"  public Integer fct(final AtomicLong left) {",
			"    return (left == null ? null : Integer.valueOf(left.intValue()));",
			"  }",
			"  ",
			"  @SyntheticMember",
			"  public A() {",
			"    super();",
			"  }",
			"}",
			"");

	@Test
	public void as_Integer_issues() throws Exception {
		validate(getValidationHelper(), getInjector(), file(getParseHelper(), AS_INTEGER_OBJECT_SARL))
		.assertNoErrors(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				org.eclipse.xtext.xbase.validation.IssueCodes.INVALID_CAST)
		.assertNoWarnings(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				org.eclipse.xtext.xbase.validation.IssueCodes.OBSOLETE_CAST)
		.assertWarning(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				IssueCodes.POTENTIAL_INEFFICIENT_VALUE_CONVERSION,
				"'toInteger'");
	}

	@GlobalCompilationTestContribution
	public static void as_Integer(ResourceSetGlobalCompilationContext ctx) throws Exception {
		ctx.compileTo(AS_INTEGER_OBJECT_SARL, AS_INTEGER_OBJECT_JAVA);
	}

	private static final String AS_LONG_OBJECT_SARL = multilineString(
			"import java.util.concurrent.atomic.AtomicLong",
			"class A {",
			"  def fct(left : AtomicLong) : Long {",
			"    left as Long",
			"  }",
			"}");

	private static final String AS_LONG_OBJECT_JAVA = multilineString(
			"import io.sarl.lang.annotation.SarlElementType;",
			"import io.sarl.lang.annotation.SarlSpecification;",
			"import io.sarl.lang.annotation.SyntheticMember;",
			"import java.util.concurrent.atomic.AtomicLong;",
			"import org.eclipse.xtext.xbase.lib.Pure;",
			"",
			"@SarlSpecification(\"" + SARLVersion.SPECIFICATION_RELEASE_VERSION_STRING + "\")",
			"@SarlElementType(" + SarlPackage.SARL_CLASS + ")",
			"@SuppressWarnings(\"all\")",
			"public class A {",
			"  @Pure",
			"  public Long fct(final AtomicLong left) {",
			"    return (left == null ? null : Long.valueOf(left.longValue()));",
			"  }",
			"  ",
			"  @SyntheticMember",
			"  public A() {",
			"    super();",
			"  }",
			"}",
			"");

	@Test
	public void as_Long_issues() throws Exception {
		SarlScript script = file(getParseHelper(), AS_LONG_OBJECT_SARL);
		validate(getValidationHelper(), getInjector(), script)
		.assertNoErrors(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				org.eclipse.xtext.xbase.validation.IssueCodes.INVALID_CAST)
		.assertNoWarnings(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				org.eclipse.xtext.xbase.validation.IssueCodes.OBSOLETE_CAST)
		.assertWarning(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				IssueCodes.POTENTIAL_INEFFICIENT_VALUE_CONVERSION,
				"'toLong'");
	}

	@GlobalCompilationTestContribution
	public static void as_Long(ResourceSetGlobalCompilationContext ctx) throws Exception {
		ctx.compileTo(AS_LONG_OBJECT_SARL, AS_LONG_OBJECT_JAVA);
	}

	private static final String AS_FLOAT_OBJECT_SARL = multilineString(
			"import java.util.concurrent.atomic.AtomicLong",
			"class A {",
			"  def fct(left : AtomicLong) : Float {",
			"    left as Float",
			"  }",
			"}");

	private static final String AS_FLOAT_OBJECT_JAVA = multilineString(
			"import io.sarl.lang.annotation.SarlElementType;",
			"import io.sarl.lang.annotation.SarlSpecification;",
			"import io.sarl.lang.annotation.SyntheticMember;",
			"import java.util.concurrent.atomic.AtomicLong;",
			"import org.eclipse.xtext.xbase.lib.Pure;",
			"",
			"@SarlSpecification(\"" + SARLVersion.SPECIFICATION_RELEASE_VERSION_STRING + "\")",
			"@SarlElementType(" + SarlPackage.SARL_CLASS + ")",
			"@SuppressWarnings(\"all\")",
			"public class A {",
			"  @Pure",
			"  public Float fct(final AtomicLong left) {",
			"    return (left == null ? null : Float.valueOf(left.floatValue()));",
			"  }",
			"  ",
			"  @SyntheticMember",
			"  public A() {",
			"    super();",
			"  }",
			"}",
			"");

	@Test
	public void as_Float_issues() throws Exception {
		validate(getValidationHelper(), getInjector(), file(getParseHelper(), AS_FLOAT_OBJECT_SARL))
		.assertNoErrors(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				org.eclipse.xtext.xbase.validation.IssueCodes.INVALID_CAST)
		.assertNoWarnings(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				org.eclipse.xtext.xbase.validation.IssueCodes.OBSOLETE_CAST)
		.assertWarning(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				IssueCodes.POTENTIAL_INEFFICIENT_VALUE_CONVERSION,
				"'toFloat'");
	}

	@GlobalCompilationTestContribution
	public static void as_Float(ResourceSetGlobalCompilationContext ctx) throws Exception {
		ctx.compileTo(AS_FLOAT_OBJECT_SARL, AS_FLOAT_OBJECT_JAVA);
	}

	private static final String AS_DOUBLE_OBJECT_SARL = multilineString(
			"import java.util.concurrent.atomic.AtomicLong",
			"class A {",
			"  def fct(left : AtomicLong) : Double {",
			"    left as Double",
			"  }",
			"}");

	private static final String AS_DOUBLE_OBJECT_JAVA = multilineString(
			"import io.sarl.lang.annotation.SarlElementType;",
			"import io.sarl.lang.annotation.SarlSpecification;",
			"import io.sarl.lang.annotation.SyntheticMember;",
			"import java.util.concurrent.atomic.AtomicLong;",
			"import org.eclipse.xtext.xbase.lib.Pure;",
			"",
			"@SarlSpecification(\"" + SARLVersion.SPECIFICATION_RELEASE_VERSION_STRING + "\")",
			"@SarlElementType(" + SarlPackage.SARL_CLASS + ")",
			"@SuppressWarnings(\"all\")",
			"public class A {",
			"  @Pure",
			"  public Double fct(final AtomicLong left) {",
			"    return (left == null ? null : Double.valueOf(left.doubleValue()));",
			"  }",
			"  ",
			"  @SyntheticMember",
			"  public A() {",
			"    super();",
			"  }",
			"}",
			"");

	@Test
	public void as_Double_issues() throws Exception {
		validate(getValidationHelper(), getInjector(), file(getParseHelper(), AS_DOUBLE_OBJECT_SARL))
		.assertNoErrors(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				org.eclipse.xtext.xbase.validation.IssueCodes.INVALID_CAST)
		.assertNoWarnings(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				org.eclipse.xtext.xbase.validation.IssueCodes.OBSOLETE_CAST)
		.assertWarning(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				IssueCodes.POTENTIAL_INEFFICIENT_VALUE_CONVERSION,
				"'toDouble'");
	}

	@GlobalCompilationTestContribution
	public static void as_Double(ResourceSetGlobalCompilationContext ctx) throws Exception {
		ctx.compileTo(AS_DOUBLE_OBJECT_SARL, AS_DOUBLE_OBJECT_JAVA);
	}

	private static final String AS_ATOMICINTEGER_OBJECT_SARL = multilineString(
			"import java.util.concurrent.atomic.AtomicInteger",
			"import java.util.concurrent.atomic.AtomicLong",
			"class A {",
			"  def fct(left : AtomicLong) : AtomicInteger {",
			"    left as AtomicInteger",
			"  }",
			"}");

	private static final String AS_ATOMICINTEGER_OBJECT_JAVA = multilineString(
			"import io.sarl.lang.annotation.SarlElementType;",
			"import io.sarl.lang.annotation.SarlSpecification;",
			"import io.sarl.lang.annotation.SyntheticMember;",
			"import java.util.concurrent.atomic.AtomicInteger;",
			"import java.util.concurrent.atomic.AtomicLong;",
			"import org.eclipse.xtext.xbase.lib.Pure;",
			"",
			"@SarlSpecification(\"" + SARLVersion.SPECIFICATION_RELEASE_VERSION_STRING + "\")",
			"@SarlElementType(" + SarlPackage.SARL_CLASS + ")",
			"@SuppressWarnings(\"all\")",
			"public class A {",
			"  @Pure",
			"  public AtomicInteger fct(final AtomicLong left) {",
			"    return (left == null ? null : new AtomicInteger(left.intValue()));",
			"  }",
			"  ",
			"  @SyntheticMember",
			"  public A() {",
			"    super();",
			"  }",
			"}",
			"");

	@Test
	public void as_AtomicInteger_issues() throws Exception {
		validate(getValidationHelper(), getInjector(), file(getParseHelper(), AS_ATOMICINTEGER_OBJECT_SARL))
		.assertNoErrors(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				org.eclipse.xtext.xbase.validation.IssueCodes.INVALID_CAST)
		.assertNoWarnings(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				org.eclipse.xtext.xbase.validation.IssueCodes.OBSOLETE_CAST)
		.assertWarning(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				IssueCodes.POTENTIAL_INEFFICIENT_VALUE_CONVERSION);
	}

	@GlobalCompilationTestContribution
	public static void as_AtomicInteger(ResourceSetGlobalCompilationContext ctx) throws Exception {
		ctx.compileTo(AS_ATOMICINTEGER_OBJECT_SARL, AS_ATOMICINTEGER_OBJECT_JAVA);
	}

	private static final String AS_ATOMICLONG_OBJECT_SARL = multilineString(
			"import java.util.concurrent.atomic.AtomicLong",
			"class A {",
			"  def fct(left : AtomicLong) : AtomicLong {",
			"    left as AtomicLong",
			"  }",
			"}");

	private static final String AS_ATOMICLONG_OBJECT_JAVA = multilineString(
			"import io.sarl.lang.annotation.SarlElementType;",
			"import io.sarl.lang.annotation.SarlSpecification;",
			"import io.sarl.lang.annotation.SyntheticMember;",
			"import java.util.concurrent.atomic.AtomicLong;",
			"import org.eclipse.xtext.xbase.lib.Pure;",
			"",
			"@SarlSpecification(\"" + SARLVersion.SPECIFICATION_RELEASE_VERSION_STRING + "\")",
			"@SarlElementType(" + SarlPackage.SARL_CLASS + ")",
			"@SuppressWarnings(\"all\")",
			"public class A {",
			"  @Pure",
			"  public AtomicLong fct(final AtomicLong left) {",
			"    return left;",
			"  }",
			"  ",
			"  @SyntheticMember",
			"  public A() {",
			"    super();",
			"  }",
			"}",
			"");

	@Test
	public void as_AtomicLong_issues() throws Exception {
		validate(getValidationHelper(), getInjector(), file(getParseHelper(), AS_ATOMICLONG_OBJECT_SARL))
		.assertNoErrors(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				org.eclipse.xtext.xbase.validation.IssueCodes.INVALID_CAST)
		.assertWarning(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				org.eclipse.xtext.xbase.validation.IssueCodes.OBSOLETE_CAST)
		.assertNoWarnings(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				IssueCodes.POTENTIAL_INEFFICIENT_VALUE_CONVERSION);
	}

	@GlobalCompilationTestContribution
	public static void as_AtomicLong(ResourceSetGlobalCompilationContext ctx) throws Exception {
		ctx.compileTo(AS_ATOMICLONG_OBJECT_SARL, AS_ATOMICLONG_OBJECT_JAVA);
	}

	private static final String AS_ATOMICDOUBLE_OBJECT_SARL = multilineString(
			"import java.util.concurrent.atomic.AtomicLong",
			"import com.google.common.util.concurrent.AtomicDouble",
			"class A {",
			"  def fct(left : AtomicLong) : AtomicDouble {",
			"    left as AtomicDouble",
			"  }",
			"}");

	private static final String AS_ATOMICDOUBLE_OBJECT_JAVA = multilineString(
			"import com.google.common.util.concurrent.AtomicDouble;",
			"import io.sarl.lang.annotation.SarlElementType;",
			"import io.sarl.lang.annotation.SarlSpecification;",
			"import io.sarl.lang.annotation.SyntheticMember;",
			"import java.util.concurrent.atomic.AtomicLong;",
			"import org.eclipse.xtext.xbase.lib.Pure;",
			"",
			"@SarlSpecification(\"" + SARLVersion.SPECIFICATION_RELEASE_VERSION_STRING + "\")",
			"@SarlElementType(" + SarlPackage.SARL_CLASS + ")",
			"@SuppressWarnings(\"all\")",
			"public class A {",
			"  @Pure",
			"  public AtomicDouble fct(final AtomicLong left) {",
			"    return (left == null ? null : new AtomicDouble(left.doubleValue()));",
			"  }",
			"  ",
			"  @SyntheticMember",
			"  public A() {",
			"    super();",
			"  }",
			"}",
			"");

	@Test
	public void as_AtomicDouble_issues() throws Exception {
		validate(getValidationHelper(), getInjector(), file(getParseHelper(), AS_ATOMICDOUBLE_OBJECT_SARL))
		.assertNoErrors(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				org.eclipse.xtext.xbase.validation.IssueCodes.INVALID_CAST)
		.assertNoWarnings(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				org.eclipse.xtext.xbase.validation.IssueCodes.OBSOLETE_CAST)
		.assertWarning(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				IssueCodes.POTENTIAL_INEFFICIENT_VALUE_CONVERSION);
	}

	@GlobalCompilationTestContribution
	public static void as_AtomicDouble(ResourceSetGlobalCompilationContext ctx) throws Exception {
		ctx.compileTo(AS_ATOMICDOUBLE_OBJECT_SARL, AS_ATOMICDOUBLE_OBJECT_JAVA);
	}

	private static final String AS_BIGINTEGER_OBJECT_SARL = multilineString(
			"import java.math.BigInteger",
			"import java.util.concurrent.atomic.AtomicLong",
			"class A {",
			"  def fct(left : AtomicLong) : BigInteger {",
			"    left as BigInteger",
			"  }",
			"}");

	private static final String AS_BIGINTEGER_OBJECT_JAVA = multilineString(
			"import io.sarl.lang.annotation.SarlElementType;",
			"import io.sarl.lang.annotation.SarlSpecification;",
			"import io.sarl.lang.annotation.SyntheticMember;",
			"import java.math.BigInteger;",
			"import java.util.concurrent.atomic.AtomicLong;",
			"import org.eclipse.xtext.xbase.lib.Pure;",
			"",
			"@SarlSpecification(\"" + SARLVersion.SPECIFICATION_RELEASE_VERSION_STRING + "\")",
			"@SarlElementType(" + SarlPackage.SARL_CLASS + ")",
			"@SuppressWarnings(\"all\")",
			"public class A {",
			"  @Pure",
			"  public BigInteger fct(final AtomicLong left) {",
			"    return (left == null ? null : BigInteger.valueOf(left.longValue()));",
			"  }",
			"  ",
			"  @SyntheticMember",
			"  public A() {",
			"    super();",
			"  }",
			"}",
			"");

	@Test
	public void as_BigInteger_issues() throws Exception {
		validate(getValidationHelper(), getInjector(), file(getParseHelper(), AS_BIGINTEGER_OBJECT_SARL))
		.assertNoErrors(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				org.eclipse.xtext.xbase.validation.IssueCodes.INVALID_CAST)
		.assertNoWarnings(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				org.eclipse.xtext.xbase.validation.IssueCodes.OBSOLETE_CAST)
		.assertWarning(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				IssueCodes.POTENTIAL_INEFFICIENT_VALUE_CONVERSION);
	}

	@GlobalCompilationTestContribution
	public static void as_BigInteger(ResourceSetGlobalCompilationContext ctx) throws Exception {
		ctx.compileTo(AS_BIGINTEGER_OBJECT_SARL, AS_BIGINTEGER_OBJECT_JAVA);
	}

	private static final String AS_BIGDECIMAL_OBJECT_SARL = multilineString(
			"import java.math.BigDecimal",
			"import java.util.concurrent.atomic.AtomicLong",
			"class A {",
			"  def fct(left : AtomicLong) : BigDecimal {",
			"    left as BigDecimal",
			"  }",
			"}");

	private static final String AS_BIGDECIMAL_OBJECT_JAVA = multilineString(
			"import io.sarl.lang.annotation.SarlElementType;",
			"import io.sarl.lang.annotation.SarlSpecification;",
			"import io.sarl.lang.annotation.SyntheticMember;",
			"import java.math.BigDecimal;",
			"import java.util.concurrent.atomic.AtomicLong;",
			"import org.eclipse.xtext.xbase.lib.Pure;",
			"",
			"@SarlSpecification(\"" + SARLVersion.SPECIFICATION_RELEASE_VERSION_STRING + "\")",
			"@SarlElementType(" + SarlPackage.SARL_CLASS + ")",
			"@SuppressWarnings(\"all\")",
			"public class A {",
			"  @Pure",
			"  public BigDecimal fct(final AtomicLong left) {",
			"    return (left == null ? null : BigDecimal.valueOf(left.doubleValue()));",
			"  }",
			"  ",
			"  @SyntheticMember",
			"  public A() {",
			"    super();",
			"  }",
			"}",
			"");

	@Test
	public void as_BigDecimal_issues() throws Exception {
		validate(getValidationHelper(), getInjector(), file(getParseHelper(), AS_BIGDECIMAL_OBJECT_SARL))
		.assertNoErrors(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				org.eclipse.xtext.xbase.validation.IssueCodes.INVALID_CAST)
		.assertNoWarnings(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				org.eclipse.xtext.xbase.validation.IssueCodes.OBSOLETE_CAST)
		.assertWarning(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				IssueCodes.POTENTIAL_INEFFICIENT_VALUE_CONVERSION);
	}

	@GlobalCompilationTestContribution
	public static void as_BigDecimal(ResourceSetGlobalCompilationContext ctx) throws Exception {
		ctx.compileTo(AS_BIGDECIMAL_OBJECT_SARL, AS_BIGDECIMAL_OBJECT_JAVA);
	}

	private static final String AS_NUMBER_OBJECT_SARL = multilineString(
			"import java.util.concurrent.atomic.AtomicLong",
			"class A {",
			"  def fct(left : AtomicLong) : Number {",
			"    left as Number",
			"  }",
			"}");

	private static final String AS_NUMBER_OBJECT_JAVA = multilineString(
			"import io.sarl.lang.annotation.SarlElementType;",
			"import io.sarl.lang.annotation.SarlSpecification;",
			"import io.sarl.lang.annotation.SyntheticMember;",
			"import java.util.concurrent.atomic.AtomicLong;",
			"import org.eclipse.xtext.xbase.lib.Pure;",
			"",
			"@SarlSpecification(\"" + SARLVersion.SPECIFICATION_RELEASE_VERSION_STRING + "\")",
			"@SarlElementType(" + SarlPackage.SARL_CLASS + ")",
			"@SuppressWarnings(\"all\")",
			"public class A {",
			"  @Pure",
			"  public Number fct(final AtomicLong left) {",
			"    return left;",
			"  }",
			"  ",
			"  @SyntheticMember",
			"  public A() {",
			"    super();",
			"  }",
			"}",
			"");

	@Test
	public void as_Number_issues() throws Exception {
		validate(getValidationHelper(), getInjector(), file(getParseHelper(), AS_NUMBER_OBJECT_SARL))
		.assertNoErrors(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				org.eclipse.xtext.xbase.validation.IssueCodes.INVALID_CAST)
		.assertWarning(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				org.eclipse.xtext.xbase.validation.IssueCodes.OBSOLETE_CAST,
				"AtomicLong to Number")
		.assertNoWarnings(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				IssueCodes.POTENTIAL_INEFFICIENT_VALUE_CONVERSION);
	}

	@GlobalCompilationTestContribution
	public static void as_Number(ResourceSetGlobalCompilationContext ctx) throws Exception {
		ctx.compileTo(AS_NUMBER_OBJECT_SARL, AS_NUMBER_OBJECT_JAVA);
	}

	private static final String AS_STRING_OBJECT_SARL = multilineString(
			"import java.util.concurrent.atomic.AtomicLong",
			"class A {",
			"  def fct(left : AtomicLong) : String {",
			"    left as String",
			"  }",
			"}");

	private static final String AS_STRING_OBJECT_JAVA = multilineString(
			"import io.sarl.lang.annotation.SarlElementType;",
			"import io.sarl.lang.annotation.SarlSpecification;",
			"import io.sarl.lang.annotation.SyntheticMember;",
			"import java.util.concurrent.atomic.AtomicLong;",
			"import org.eclipse.xtext.xbase.lib.Pure;",
			"",
			"@SarlSpecification(\"" + SARLVersion.SPECIFICATION_RELEASE_VERSION_STRING + "\")",
			"@SarlElementType(" + SarlPackage.SARL_CLASS + ")",
			"@SuppressWarnings(\"all\")",
			"public class A {",
			"  @Pure",
			"  public String fct(final AtomicLong left) {",
			"    return (left == null ? null : left.toString());",
			"  }",
			"  ",
			"  @SyntheticMember",
			"  public A() {",
			"    super();",
			"  }",
			"}",
			"");

	@Test
	public void as_String_issues() throws Exception {
		validate(getValidationHelper(), getInjector(), file(getParseHelper(), AS_STRING_OBJECT_SARL))
		.assertNoErrors(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				org.eclipse.xtext.xbase.validation.IssueCodes.INVALID_CAST)
		.assertNoWarnings(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				org.eclipse.xtext.xbase.validation.IssueCodes.OBSOLETE_CAST)
		.assertWarning(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				IssueCodes.POTENTIAL_INEFFICIENT_VALUE_CONVERSION,
				"'toString'");
	}

	@GlobalCompilationTestContribution
	public static void as_String(ResourceSetGlobalCompilationContext ctx) throws Exception {
		ctx.compileTo(AS_STRING_OBJECT_SARL, AS_STRING_OBJECT_JAVA);
	}

	private static final String AS_UUID_OBJECT_SARL = multilineString(
			"import java.util.concurrent.atomic.AtomicLong",
			"import java.util.UUID",
			"class A {",
			"  def fct(left : AtomicLong) : UUID {",
			"    left as UUID",
			"  }",
			"}");

	@Test
	public void as_UUID_issues() throws Exception {
		validate(getValidationHelper(), getInjector(), file(getParseHelper(), AS_UUID_OBJECT_SARL))
		.assertError(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				org.eclipse.xtext.xbase.validation.IssueCodes.INVALID_CAST,
				"AtomicLong to UUID")
		.assertNoWarnings(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				org.eclipse.xtext.xbase.validation.IssueCodes.OBSOLETE_CAST)
		.assertNoWarnings(
				TypesPackage.eINSTANCE.getJvmParameterizedTypeReference(),
				IssueCodes.POTENTIAL_INEFFICIENT_VALUE_CONVERSION);
	}

}
