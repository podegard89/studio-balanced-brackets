import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.BeforeAllCallback;

import static org.junit.jupiter.api.Assertions.*;

public class BalancedBracketsTests {

    @Test
    public void testBasicBrackets() {
        assertTrue(BalancedBrackets.hasBalancedBrackets("[]"));
    }

    @Test
    public void testEmptyStringReturnsTrue() {
        assertTrue(BalancedBrackets.hasBalancedBrackets(""));
    }

    //"[L]au[n]ch[C]od[]e"
    @Test
    public void testInterspersedBracketPairs() {
        assertTrue(BalancedBrackets.hasBalancedBrackets("[L]au[n]ch[C]od[]e"));
    }

    @Test
    public void testOneOpenBracketIsFalse() {
        assertFalse(BalancedBrackets.hasBalancedBrackets("[LaunchCode"));
    }

    // "[[[[a]a][]]][]"
    @Test
    public void testRandomNestedBracketPairs() {
        assertTrue(BalancedBrackets.hasBalancedBrackets("[[[[[a]a][]]][]]"));
    }

    // "]as[df]jo[ajsd]fj[]"
    @Test
    public void testLoneClosingBracketIsFalse() {
        assertFalse(BalancedBrackets.hasBalancedBrackets("]as[df]jo[ajsd]fj[]"));
    }

    // "]"
    @Test
    public void testSingleClosingBracket() {
        assertFalse(BalancedBrackets.hasBalancedBrackets("]"));
    }

    // "]["
    @Test
    public void testClosingThenOpeningBracket() {
        assertFalse(BalancedBrackets.hasBalancedBrackets("]["));
    }

    @Test
    public void testClosingBeforeOpeningAmongCharacters() {
        assertFalse(BalancedBrackets.hasBalancedBrackets("Launch]Code["));
    }

    @Test
    public void testLotsOfPairsWithExtraOpenBracket() {
        assertFalse(BalancedBrackets.hasBalancedBrackets("[[][][][][][][][][][][]"));
    }

    @Test
    public void testLotsOfPairsWithExtraCloseBracket() {
        assertFalse(BalancedBrackets.hasBalancedBrackets("[[][][][][][][][][][][]]]"));
    }

}
