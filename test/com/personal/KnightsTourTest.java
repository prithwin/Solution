package com.personal;

import org.testng.annotations.Test;
import static org.testng.Assert.*;


/**
 * Created by pr250155 on 5/10/17.
 */
public class KnightsTourTest {
    @Test public void starTour5() {
        KnightsTour.setBoardSize(5);
        new KnightsTour().beginTour();
    }

    @Test(enabled = true) public void starTour6() {
        KnightsTour.setBoardSize(6);
        new KnightsTour().beginTour();
    }
}
