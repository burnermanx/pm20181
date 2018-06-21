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
        @Getter @Element(name = "motor-id", required = false) long motorId;
        @Getter @Element(name = "common-name", required = false) String commonName;
        @Getter @Element(name = "manufacturer", required = false) String manufacturer;
        @Getter @Element(name = "manufacturer-abbrev", required = false) String manufacturerAbbrev;
        @Getter @Element(name = "designation", required = false) String designation;
        @Getter @Element(name = "brand-name", required = false) String brandName;
        @Getter @Element(name = "impulse-class", required = false) String impulseClass;
        @Getter @Element(name = "cert-org", required = false) String certOrg;
        @Getter @Element(name = "data-files", required = false) int dataFiles;
        @Getter @Element(name = "info-url", required = false) String infoUrl;
        @Getter @Element(name = "case-info", required = false) int caseInfo;
        @Getter @Element(name = "updated-on", required = false) String updatedOn;
        @Getter @Element(name = "availability", required = false) String availability;
        @Getter @Element(name = "diameter", required = false) double diameter;
        @Getter @Element(name = "length", required = false) double length;
        @Getter @Element(name = "type", required = false) String type;
        @Getter @Element(name = "total-weight-g", required = false) double totalWeight;
        @Getter @Element(name = "prop-weight-g", required = false) double propWeight;
        @Getter @Element(name = "burn-time-s", required = false) double burnTimeSecs;
        @Getter @Element(name = "avg-thrust-n", required = false) double avgThrust;
        @Getter @Element(name = "max-thrust-n", required = false) double maxThrust;
        @Getter @Element(name = "tot-impulse-ns", required = false) double totalImpulseNs;
        @Getter @Element(name = "error", required = false) String error;
    }
}
