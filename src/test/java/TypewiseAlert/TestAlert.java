package TypewiseAlert;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestAlert 
{
    @Test
    public void infersBreachAsPerLimits()
    {
      assertTrue(BreachAnalyzer.inferBreach(12, 20, 30) == EnumBreachType.TOO_LOW);
      assertTrue(BreachAnalyzer.inferBreach(35, 10, 35) == EnumBreachType.NORMAL);
      assertTrue(BreachAnalyzer.inferBreach(45, 10, 40) == EnumBreachType.TOO_HIGH);
      assertTrue(BreachAnalyzer.inferBreach(10, 10, 30) == EnumBreachType.NORMAL);
      assertFalse(BreachAnalyzer.inferBreach(45, 10, 30) == EnumBreachType.NORMAL);
      assertFalse(BreachAnalyzer.inferBreach(12, 20, 30) == EnumBreachType.NORMAL);
    }
}
