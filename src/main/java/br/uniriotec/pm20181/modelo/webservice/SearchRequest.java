package br.uniriotec.pm20181.modelo.webservice;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.core.Persister;

import java.io.ByteArrayOutputStream;

/**
 * Classe que representa um request de search no ThrustCurve
 */
@Root(name = "search-request")
public class SearchRequest extends AbstractRequest {
    private SearchRequest(){}
    private SearchRequest(Builder builder) {
        this.commonName = builder.commonName;
        this.manufacturer = builder.manufacturer;
    }

    @Element(name = "common-name") private String commonName;
    @Element(name = "manufacturer") private String manufacturer;

    public static class Builder {
        private String commonName = "";
        private String manufacturer = "";

        /**
         * Nome comum do motor para a busca, ex: L600
         */
        public Builder withCommonName(String commonName) {
            this.commonName = commonName;
            return this;
        }

        /**
         * Nome do fabricante para a busca, ex: Ellis
         */
        public Builder withManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
            return this;
        }

        /**
         * Gera o objeto SearchRequest
         */
        public SearchRequest build() {
            return new SearchRequest(this);
        }
    }
}
