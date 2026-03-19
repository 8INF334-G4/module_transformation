package org.groupe4;

import java.util.Vector;

public class Core {
    Vector<InputReader> readers = new Vector<>();
    Vector<OutputWriter> writers = new Vector<>();

    public Core() {}

    public void addReader(InputReader reader) {
        this.readers.add(reader);
    }

    public void addWriter(OutputWriter writer) {
        this.writers.add(writer);
    }

    public void loop() {
        for (InputReader reader : readers) {
            try {
                Product product = reader.readNext();
                for (OutputWriter writer : writers) {
                    writer.writeNext(product);
                }
            } catch (Exception e) {
                ExceptionManager.handleException(e);
            }
        }
    }
}
