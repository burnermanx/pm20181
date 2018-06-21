package br.uniriotec.pm20181.modelo.webservice;

import org.simpleframework.xml.core.Persister;

import java.io.ByteArrayOutputStream;

/**
 * Classe abstrata para os requests
 */
abstract class AbstractRequest {
    /**
     * Serializa o objeto para XML
     */
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
