package org.groupe4;

import org.groupe4.mock.MockABC;
import org.groupe4.mock.MockDDD;

public class Main {
    public static void main(String[] args) {
        Core core = new Core();
        core.addReader(new ABCReader(new MockABC()));
        core.addWriter(new DDDWriter(new MockDDD()));
        while (true) {
            core.loop();
        }
    }
}
