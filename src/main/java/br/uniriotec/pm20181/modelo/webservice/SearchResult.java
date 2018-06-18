package br.uniriotec.pm20181.modelo.webservice;

import lombok.Getter;
import org.simpleframework.xml.Element;

public class SearchResult {
    @Getter @Element(name = "common-name") String commonName;
    @Getter @Element(name = "manufacturer-abbrev") String manufacturer;
    @Getter @Element(name = "diameter") double diameter;
    @Getter @Element(name = "length") double length;
    @Getter @Element(name = "type") String type;
    @Getter @Element(name = "total-weight-g") double totalWeight;
    @Getter @Element(name = "prop-weight-g") double propWeight;
    @Getter @Element(name = "burn-time-s") double burnTimeSecs;
    @Getter @Element(name = "avg-thrust-n") double avgThrust;
    @Getter @Element(name = "max-thrust-n") double maxThrust;
    @Getter @Element(name = "tot-impulse-ns") double totalImpulseNs;
}
