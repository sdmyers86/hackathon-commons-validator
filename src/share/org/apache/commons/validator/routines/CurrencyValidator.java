/*
 * $Id$
 * $Revision$
 * $Date$
 *
 * ====================================================================
 * Copyright 2006 The Apache Software Foundation
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
package org.apache.commons.validator.routines;

import java.text.Format;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * <p><b>Currency Validation</b> and Conversion routines (<code>java.math.BigDecimal</code>).</p>
 * 
 * <p>This validator is a variation of the <code>BigDecimal</code> Validator
 *    that uses the <i>currency</i> format when validating using
 *    a <code>Locale</code>.</p>
 * 
 * <p>Otherwise it provides the same functionality as the <code>BigDecimal</code>
 *    with converted values being returned as a  <code>BigDecimal</code>.</p>
 *
 * @version $Revision$ $Date$
 * @since Validator 1.2.1
 */
public class CurrencyValidator extends BigDecimalValidator {

    private static final CurrencyValidator VALIDATOR = new CurrencyValidator();

    /**
     * Return a singleton instance of this validator.
     * @return A singleton instance of the CurrencyValidator.
     */
    public static BigDecimalValidator getInstance() {
        return VALIDATOR;
    }

    /**
     * Construct a <i>strict</i> instance.
     */
    public CurrencyValidator() {
        this(true);
    }

    /**
     * Construct an instance with the specified strict setting.
     * 
     * @param strict <code>true</code> if strict 
     *        <code>Format</code> parsing should be used.
     */
    public CurrencyValidator(boolean strict) {
        super(strict);
    }

    /**
     * <p>Returns a currency <code>NumberFormat</code> for the specified Locale.</p>
     * 
     * @param locale The locale a currency <code>NumberFormat</code> is required
     *        for, defaults to the default.
     * @return The currency <code>NumberFormat</code> to created.
     */
    public Format getFormat(Locale locale) {

        if (locale == null) {
            locale = Locale.getDefault();
        }

        return NumberFormat.getCurrencyInstance(locale);

    }

}