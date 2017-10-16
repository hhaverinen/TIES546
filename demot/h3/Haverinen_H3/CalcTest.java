// A sample simple calculator
// Copyright © 2017 Antti-Juhani Kaijanaho

//     Licensed under the Apache License, Version 2.0 (the "License");
//     you may not use this file except in compliance with the License.
//     You may obtain a copy of the License at

//         http://www.apache.org/licenses/LICENSE-2.0

//     Unless required by applicable law or agreed to in writing,
//     software distributed under the License is distributed on an "AS
//     IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
//     express or implied.  See the License for the specific language
//     governing permissions and limitations under the License.

package fi.jyu.antkaij.calc;

import org.junit.*;
import static org.junit.Assert.*;

public class CalcTest {

    /**
     * Kattaa mallista + -operaattorin (ja positiivisen luvun)
     */
    @Test
    public void testPlus() {
        assertEquals(9, Calc.compute("4+5"));
    }

    /**
     * Kattaa mallista - -operaattorin (ja positiivisen luvun)
     */
    @Test
    public void testMinus() {
        assertEquals(1, Calc.compute("5-4"));
    }

    /**
     * Kattaa mallista * -operaattorin (ja positiivisen luvun)
     */
    @Test
    public void testMultiple() {
        assertEquals(12, Calc.compute("3*4"));
    }

    /**
     * Kattaa mallista / -operaattorin (ja positiivisen luvun)
     */
    @Test
    public void testDivide() {
        assertEquals(3, Calc.compute("9/3"));
    }

    /**
     * Kattaa mallista () -lausekkeen (ja positiivisen luvun)
     */
    @Test
    public void testParens() {
        assertEquals(20, Calc.compute("(2+3)*4"));
    }

    /**
     * Kattaa mallista () -lausekkeen toisen sulun uupumisen
     */
    @Test(expected=ParseException.class)
    public void testParensError() {
        Calc.compute("1)");
    }

    /**
     * Kattaa mallista nolla -luvun
     */
    @Test(expected=ArithmeticException.class)
    public void testDivideByZero() {
        Calc.compute("1/0");
    }

    /**
     * Kattaa mallista negatiivisen luvun
     */
    @Test(expected=ParseException.class)
    public void testNegativeNumber() {
        Calc.compute("-5 + 6");
    }

}
