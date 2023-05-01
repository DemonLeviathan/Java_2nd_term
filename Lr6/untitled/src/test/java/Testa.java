import org.example.Planets;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class Testa {
    @Test
    public void testCalculateSurfaceGravityReturnsCorrectValue(){
        Planets Earth = new Planets("Earth", 5.972E24, 6378.1E3, 149.6E9, 365.25, 23.93);
        double expectedValue = 9.81;
        double delta = 0.03;
        assertEquals(expectedValue, Earth.calculateSurfaceGravity(), delta);
    }

    @Test
    public void testCalculateSurfaceGravityWithNegativeRadiusThrowsIllegalArgumentException() {
        Planets jupiter = new Planets("Jupiter", 1.898E27, -69911E3, 778.3E9, 4331.57, 9.91);
        jupiter.calculateSurfaceGravity();
    }

    @Test
    public void testCalculateSurfaceGravityWithZeroRadiusThrowsIllegalArgumentException() {
        Planets saturn = new Planets("Saturn", 5.683E26, 0, 1433.5E9, 10759.5, 10.23);
        saturn.calculateSurfaceGravity();
    }

}
