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
     * Testaa + operaattorin
     */
    @Test
    public void testPlus() {
        assertEquals(2, Calc.compute("1+1"));
    }

    /**
     * Testaa - operaattorin
     */
    @Test
    public void testMinus() { assertEquals(-1, Calc.compute("2-3")); }

    /**
     * Testaa * operaattorin
     */
    @Test
    public void testMultiple() { assertEquals(6, Calc.compute("2*3")); }

    /**
     * Testaa / operaattorin
     */
    @Test
    public void testDivision() { assertEquals(2, Calc.compute("4/2")); }

    /**
     * Testaa väliyöntien parsimisen
     */
    @Test
    public void testWhiteSpace() { assertEquals(2, Calc.compute("4  /   2")); }

    /**
     * Testaa moninumeroisia lukuja
     */
    @Test
    public void testBigNumber() { assertEquals(220, Calc.compute("22 * 10")); }

    /**
     * Testaa sulkeiden parsimisen
     */
    @Test
    public void testParenthesis() { assertEquals(3, Calc.compute("(1 + 2)")); }

    /**
     * Testaa laskusääntöjen noudattamisen
     */
    @Test
    public void testCalcOrder() { assertEquals(8, Calc.compute("2 + 2 * 3")); }

    /**
     * Testaa laskusääntöjen noudattamisen kun käytetään sulkeita
     */
    @Test
    public void testCalcOrderWithParenthesis() { assertEquals(12, Calc.compute("(2 + 2) * 3")); }

    /**
     * Testaa ennenaikaista lausekkeen loppumista
     */
    @Test(expected=ParseException.class)
    public void testUnexpectedEnd() { Calc.compute("1+"); }

    /**
     * Testaa virheellistä lauseketta
     */
    @Test(expected=ParseException.class)
    public void testError() {
        Calc.compute("1!");
    }
}
