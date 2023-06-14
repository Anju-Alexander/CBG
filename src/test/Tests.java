package org.beginsecure.domain.primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Log4jTest {

    @Test
    void checkDisp() {

        Log4j obj=new Log4j();
        assertEquals(0,obj.checkDisp());
    }
}
