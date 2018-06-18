package br.uniriotec.pm20181.modelo.webservice;

import lombok.Getter;
import org.simpleframework.xml.*;
import org.simpleframework.xml.core.Persister;

import java.util.List;

@Root(name = "search-response")
@NamespaceList({
        @Namespace(reference = "http://www.thrustcurve.org/2015/SearchResponse"),
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema-instance", prefix = "xsi"),
        @Namespace(reference = "http://www.thrustcurve.org/2015/SearchResponse http://www.thrustcurve.org/2015/search-response.xsd", prefix = "schemaLocation")
})
public class SearchResponse {
    @Attribute(name = "schemaLocation") String schemaLocation;
    @Getter @ElementList(name = "results") List<SearchResult> results;
    @Getter @Element(name = "criteria") SearchCriteria criteria;
    @Getter @Element(name = "error", required = false) String error;

    public static SearchResponse fromXml(String xml) {
        try {
            return new Persister().read(SearchResponse.class, xml);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Root(name = "criteria")
    public static class SearchCriteria {
        @Getter @ElementList(inline = true, type = SearchCriteriaData.class) List<SearchCriteriaData> dataList;
        @Getter @Element(name = "matches") int matches;
        @Getter @Element(name = "error", required = false) String error;
    }

    @Root(name = "criterion")
    public static class SearchCriteriaData {
        @Getter @Element(name = "name") String name;
        @Getter @Element(name = "value") String value;
        @Getter @Element(name = "matches") int matches;
        @Getter @Element(name = "error", required = false) String error;
    }

    @Root(name = "result")
    public static class SearchResult {
        @Getter @Element(name = "motor-id") long motorId;
        @Getter @Element(name = "common-name") String commonName;
        @Getter @Element(name = "manufacturer") String manufacturerName;
        @Getter @Element(name = "manufacturer-abbrev") String manufacturer;
        @Getter @Element(name = "designation") String designation;
        @Getter @Element(name = "brand-name") String brandName;
        @Getter @Element(name = "impulse-class") String impulseClass;
        @Getter @Element(name = "cert-org") String certOrg;
        @Getter @Element(name = "data-files") int dataFiles;
        @Getter @Element(name = "info-url") String infoUrl;
        @Getter @Element(name = "case-info") int caseInfo;
        @Getter @Element(name = "updated-on") String updatedOn;
        @Getter @Element(name = "availability") String availability;
        @Getter @Element(name = "diameter") double diameter;
        @Getter @Element(name = "length") double length;
        @Getter @Element(name = "type") String type;
        @Getter @Element(name = "total-weight-g") double totalWeight;
        @Getter @Element(name = "prop-weight-g") double propWeight;
        @Getter @Element(name = "burn-time-s") double burnTimeSecs;
        @Getter @Element(name = "avg-thrust-n") double avgThrust;
        @Getter @Element(name = "max-thrust-n") double maxThrust;
        @Getter @Element(name = "tot-impulse-ns") double totalImpulseNs;
        @Getter @Element(name = "error", required = false) String error;
    }
}
