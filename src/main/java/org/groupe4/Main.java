package org.groupe4;

import org.groupe4.mock.MockABC;
import org.groupe4.mock.MockDDD;

public class Main {
    private static ABCReader reader;
    private static DDDWriter writer;

    private static void loop() {
        try {
            Product product = reader.readNext();
            writer.writeNext(product);
        } catch (Exception e) {
            ExceptionManager.handleException(e);
            return;
        }
    }

    public static void main(String[] args) {
        reader = new ABCReader(new MockABC());
        writer = new DDDWriter(new MockDDD());

        while (true) {
            loop();
        }
    }
}
