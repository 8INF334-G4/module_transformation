package org.groupe4.mock;

public class MockABC {
    public MockABC() {

    }

    public String GenerateReport(int idProduct) {
        return "{\"nom\" : \"Super colle\" , \"volume_ml\" : 20 , \"temps_sechage_sec\" : 30 , \"resistant_eau\" : true , \"prix\" : 4.99}";
    }
}
