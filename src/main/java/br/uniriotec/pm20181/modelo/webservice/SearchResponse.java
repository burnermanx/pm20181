package br.uniriotec.pm20181.modelo.webservice;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.core.Persister;

import java.util.List;

@Root(name = "search-response")
public class SearchResponse {
    @Element(name = "results") List<SearchResult> results;

    public static SearchResponse fromXml(String xml) {
        try {
            return new Persister().read(SearchResponse.class, xml);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    class SearchResult {
        @Element(name = "common-name") String commonName;
        @Element(name = "manufacturer-abbrev") String manufacturer;
        @Element(name = "diameter") double diameter;
        @Element(name = "length") double length;
        @Element(name = "type") String type;
        @Element(name = "total-weight-g") double totalWeight;
        @Element(name = "prop-weight-g") double propWeight;
        @Element(name = "burn-time-s") double burnTimeSecs;
        @Element(name = "avg-thrust-n") double avgThrust;
        @Element(name = "max-thrust-n") double maxThrust;
        @Element(name = "tot-impulse-ns") double totalImpulseNs;
    }
}
