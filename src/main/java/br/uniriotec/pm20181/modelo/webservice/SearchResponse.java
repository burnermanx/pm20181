package br.uniriotec.pm20181.modelo.webservice;

import lombok.Getter;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.core.Persister;

import java.util.List;

@Root(name = "search-response")
public class SearchResponse {
    @Getter @Element(name = "results") List<SearchResult> results;

    public static SearchResponse fromXml(String xml) {
        try {
            return new Persister().read(SearchResponse.class, xml);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
