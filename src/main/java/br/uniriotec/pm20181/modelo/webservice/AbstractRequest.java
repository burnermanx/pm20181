package br.uniriotec.pm20181.modelo.webservice;

import org.simpleframework.xml.core.Persister;

import java.io.ByteArrayOutputStream;

abstract class AbstractRequest {
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
}
