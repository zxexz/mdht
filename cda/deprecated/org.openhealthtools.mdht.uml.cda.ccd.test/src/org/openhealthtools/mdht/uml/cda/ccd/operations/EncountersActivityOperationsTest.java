/*******************************************************************************
 * Copyright (c) 2010, 2011 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.openhealthtools.mdht.uml.cda.ccd.operations;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.junit.Test;
import org.openhealthtools.mdht.uml.cda.ccd.CCDFactory;
import org.openhealthtools.mdht.uml.cda.ccd.EncountersActivity;

/**
 * This class is a JUnit4 test case.
 */
@SuppressWarnings("nls")
public class EncountersActivityOperationsTest extends CCDValidationTest {

	protected static final String ENCOUNTERS_ACTIVITY_TEMPLATE_ID = "2.16.840.1.113883.10.20.1.21";

	protected static final String CODE = "completed";

	protected static final String CODE_SYSTEM = "2.16.840.1.113883.1.11.13955";

	/**
	 * Not a real test, needed for EMMA to report 100% method coverage.
	 */
	@SuppressWarnings("unused")
	@Test
	public final void testConstructor() {
		EncountersActivityOperations obj = new EncountersActivityOperations();
		assertTrue(true);
	} // testConstructor

	private static final CDATestCase TEST_CASE_ARRAY[] = {
			// Template ID
			// -------------------------------------------------------------
			new TemplateIDValidationTest(ENCOUNTERS_ACTIVITY_TEMPLATE_ID) {

				@Override
				protected boolean validate(final EObject objectToTest, final BasicDiagnostic diagnostician,
						final Map<Object, Object> map) {
					return EncountersActivityOperations.validateEncountersActivityTemplateId(
						(EncountersActivity) objectToTest, diagnostician, map);
				}

			},

			// ID
			// -------------------------------------------------------------
			new IDCCDValidationTest() {
				@Override
				protected boolean validate(final EObject objectToTest, final BasicDiagnostic diagnostician,
						final Map<Object, Object> map) {
					return EncountersActivityOperations.validateEncountersActivityId(
						(EncountersActivity) objectToTest, diagnostician, map);
				}
			},

			// EffectiveTime
			// -------------------------------------------------------------
			new EffectiveTimeCCDValidationTest() {
				@Override
				protected boolean validate(final EObject objectToTest, final BasicDiagnostic diagnostician,
						final Map<Object, Object> map) {
					return EncountersActivityOperations.validateEncountersActivityEffectiveTime(
						(EncountersActivity) objectToTest, diagnostician, map);
				}
			}

	}; // TEST_CASE_ARRAY

	@Override
	protected List<CDATestCase> getTestCases() {
		// Return a new List because the one returned by Arrays.asList is
		// unmodifiable so a sub-class can't append their test cases.
		final List<CDATestCase> retValue = super.getTestCases();
		retValue.addAll(Arrays.asList(TEST_CASE_ARRAY));
		return retValue;
	}

	/**
	 * 
	 */
	@Test
	public void testValidateEncountersActivityClassCode() {
		// This is not fully implemented.
		final EncountersActivity ea = (EncountersActivity) getObjectToTest();
		final BasicDiagnostic diagnostician = Diagnostician.INSTANCE.createDefaultDiagnostic(ea);

		boolean isValid = EncountersActivityOperations.validateEncountersActivityClassCode(ea, diagnostician, map);
		assertTrue(createAssertionFailureMessage(diagnostician), !isValid);
	}

	/**
	 * 
	 */
	@Test
	public void testValidateEncountersActivityMoodCode() {
		// This is not fully implemented.
		final EncountersActivity ea = (EncountersActivity) getObjectToTest();
		final BasicDiagnostic diagnostician = Diagnostician.INSTANCE.createDefaultDiagnostic(ea);

		boolean isValid = EncountersActivityOperations.validateEncountersActivityMoodCode(ea, diagnostician, map);
		assertTrue(createAssertionFailureMessage(diagnostician), !isValid);
	}

	@Override
	protected EObject getObjectToTest() {
		return CCDFactory.eINSTANCE.createEncountersActivity();
	}

	@Override
	protected EObject getObjectInitToTest() {
		return CCDFactory.eINSTANCE.createEncountersActivity().init();
	}

} // EncountersActivityOperationsTest
