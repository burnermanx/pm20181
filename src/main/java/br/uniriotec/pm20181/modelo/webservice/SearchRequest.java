package br.uniriotec.pm20181.modelo.webservice;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.core.Persister;

import java.io.ByteArrayOutputStream;

@Root(name = "search-request")
public class SearchRequest {
    private SearchRequest(){}
    private SearchRequest(Builder builder) {
        this.commonName = builder.commonName;
        this.manufacturer = builder.manufacturer;
    }

    @Element(name = "common-name") private String commonName;
    @Element(name = "manufacturer") private String manufacturer;

    public String toXml() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            new Persister().write(this, os);
            return new String(os.toByteArray(),"ISO-8859-1");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    public static class Builder {
        private String commonName = "";
        private String manufacturer = "";

        public Builder withCommonName(String commonName) {
            this.commonName = commonName;
            return this;
        }

        public Builder withManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
            return this;
        }

        public SearchRequest build() {
            return new SearchRequest(this);
        }
    }
}
