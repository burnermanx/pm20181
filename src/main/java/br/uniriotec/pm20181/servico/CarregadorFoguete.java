package br.uniriotec.pm20181.servico;

import br.uniriotec.pm20181.modelo.foguete.*;
import br.uniriotec.pm20181.util.XmlUtils;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Classe auxiliar para leitura do XML do Foguete
 */
public class CarregadorFoguete {


    /**
     * Método responsável pelo carregamento do XML que define a construção do foguete
     * @param xml String do XML do foguete
     * @param servicoMotores Serviço de motores para a consulta de dados adicionais sobre o Motor
     * @return instância do Foguete
     */
    public Foguete carrega(String xml, ServicoMotores servicoMotores) {
        Element root = XmlUtils.getRootElementFromXmlFile(xml);
        if (root != null) {
            Foguete foguete = new Foguete();

            double cd = XmlUtils.getDoubleAttribute(root, "cd");
            foguete.setCd(cd);

            Element controle = XmlUtils.getSingleElement(root, "controle");
            foguete.setControle(criarControle(controle));

            Element paraquedas = XmlUtils.getSingleElement(root, "paraquedas");
            if (paraquedas != null) {
                foguete.setParaquedas(criarParaquedas(paraquedas));
            }

            List<Element> elementosComponente = XmlUtils.getElements(root, "componente");
            Map<String, Componente> componenteMap = new HashMap<>();
            for (Element element : elementosComponente) {
                Componente componente = null;
                String tipo = XmlUtils.getStringAttribute(element, "tipo");
                if (tipo != null) {
                    switch (tipo) {
                        case TiposComponente.COMPONENTE_CARGA:
                            componente = criarCarga(element);
                            break;

                        case TiposComponente.COMPONENTE_MOTOR:
                            componente = criarMotor(element, servicoMotores);
                            break;
                    }
                }

                if (componente != null) {
                    componenteMap.put(componente.getNome(), componente);
                }
            }

            List<Element> elementosConexoes = XmlUtils.getElements(root, "conexao");
            for (Element element : elementosConexoes) {
                String base = XmlUtils.getStringAttribute(element, "base");
                String nomeComponente = XmlUtils.getStringAttribute(element, "componente");
                String direcao = XmlUtils.getStringAttribute(element, "direcao");

                Componente componenteAnexar = componenteMap.get(nomeComponente);
                Direcao direcaoAnexar = getDirecao(direcao);

                efetuaConexao(foguete, base, componenteAnexar, direcaoAnexar);
                componenteMap.remove(nomeComponente);
            }

            return foguete;
        }

        return null;
    }

    /**
     * Cria uma classe de Controle dado um Element XML
     * @param element XML
     * @return classe Controle
     */
    private Controle criarControle(Element element) {
        Controle compControle = new Controle();
        compControle.setNome(XmlUtils.getStringAttribute(element, "nome"));
        compControle.setPeso(XmlUtils.getDoubleNode(element, "peso"));
        compControle.setDiametro(XmlUtils.getDoubleNode(element, "diametro"));

        return compControle;
    }

    /**
     * Cria uma classe de Paraquedas dado um Element XML
     * @param element XML
     * @return classe Paraquedas
     */
    private Paraquedas criarParaquedas(Element element) {
        Paraquedas compParaquedas = new Paraquedas();
        compParaquedas.setNome(XmlUtils.getStringAttribute(element, "nome"));
        compParaquedas.setCd(XmlUtils.getDoubleNode(element, "cd"));
        compParaquedas.setDiametro(XmlUtils.getDoubleNode(element, "diametro"));
        compParaquedas.setPeso(XmlUtils.getDoubleNode(element, "peso"));

        return compParaquedas;
    }

    /**
     * Cria uma classe de Motor dado um Element XML
     * @param element XML
     * @return classe Motor
     */
    private Motor criarMotor(Element element, ServicoMotores servicoMotores) {
        Element elementMotor = XmlUtils.getSingleElement(element, "motor");

        Motor motor = null;

        if (elementMotor != null) {
            String fabricante = XmlUtils.getStringAttribute(elementMotor, "fabricante");
            String modelo = XmlUtils.getStringAttribute(elementMotor, "nome");

            motor = servicoMotores.pegaMotor(fabricante, modelo);

            if (motor != null) {
                motor.setNome(XmlUtils.getStringAttribute(element, "nome"));
                motor.setDiametro(XmlUtils.getDoubleNode(element, "diametro"));
                motor.setPeso(XmlUtils.getDoubleNode(element, "peso"));
            }
        }

        return motor;
    }

    /**
     * Cria uma classe de Carga dado um Element XML
     * @param element XML
     * @return classe Carga
     */
    private Carga criarCarga(Element element) {
        Carga carga = new Carga();
        carga.setNome(XmlUtils.getStringAttribute(element, "nome"));
        carga.setDiametro(XmlUtils.getDoubleNode(element, "diametro"));
        carga.setPeso(XmlUtils.getDoubleNode(element, "peso"));
        carga.setPesoCarga(XmlUtils.getDoubleNode(element, "pesoCarga"));

        return carga;
    }

    /**
     * Efetua a conexão do componente ao foguete
     * @param foguete Objeto do Foguete
     * @param base Nome do compoente onde o novo componente deve ser anexado
     * @param componenteAnexar componente a ser anexado
     * @param direcao direção do componente a ser anexado
     */
    private void efetuaConexao(Foguete foguete, String base, Componente componenteAnexar, Direcao direcao) {
        Componente componente = foguete.getControle().pegaComponenteNome(base);
        if (componente != null) {
            componente.adicionaComponenteConectado(direcao, componenteAnexar);
        }
    }

    /**
     * Pega um enum de Direcao dado a direção em String
     * @param direcao string de direcão
     * @return enum Direcao
     */
    private Direcao getDirecao(String direcao) {
        if (direcao.equals("abaixo")) {
            return Direcao.ABAIXO;
        }

        if (direcao.equals("norte")) {
            return Direcao.NORTE;
        }

        if (direcao.equals("sul")) {
            return Direcao.SUL;
        }

        if (direcao.equals("leste")) {
            return Direcao.LESTE;
        }

        if (direcao.equals("oeste")) {
            return Direcao.OESTE;
        }

        return null;
    }


}
