/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.Serializable;
import java.net.SocketTimeoutException;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import model.Endereco;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


@ManagedBean
@ApplicationScoped
public class CepBean implements Serializable {

    private static final Long serialVersionUID = 1L;
    private String bairro;
    private String uf;
    private String cidade;
    private String cep;
    private String endereco;
    private Document doc;
    
    public static CepBean instance;
    public static CepBean getInstance(){
        return instance ==null? instance= new CepBean():instance;
    }

    public void buscarEndereco(String cep) {

        //***************************************************
        try {
            doc = (Document) Jsoup.connect("http://www.qualocep.com/busca-cep/" + cep.replace(".", "").replace("-", "")).timeout(120000).get();
        } catch (SocketTimeoutException | HttpStatusException e) {
            System.err.println(e);
        } catch (IOException ex) {
            System.err.println(ex);
        }

    }

    public void preencherCep(String numeroObjeto, Endereco endereco) {

        //***************************************************
        try {
            doc = (Document) Jsoup.connect("http://websro.correios.com.br/sro_bin/txect01$.QueryList?P_LINGUA=001&P_TIPO=001&P_COD_UNI=" + numeroObjeto).timeout(120000).get();
           
            System.out.println(getEndereco());
            preencher(endereco);
        } catch (SocketTimeoutException | HttpStatusException e) {
            System.err.println(e);
        } catch (IOException ex) {
            System.err.println(ex);
        }

    }

    /**
     * Retorna o endereço da pesquisa
     *
     * @return
     */
    private void preencher(Endereco e) {
        e.setBairro(getBairro());
        //e.setCep(getCep());
        e.setCidade(getCidade());        
        e.setLogradouro(getEndereco());
        System.out.println(getEndereco());
    }

    /**
     * Retorna o endereço da pesquisa
     *
     * @return
     */
    public String getEndereco() {
        Elements urlPesquisa = doc.select("span[itemprop=streetAddress]");
        endereco = urlPesquisa.text();
        return endereco.toUpperCase();
    }

    /**
     * Retorna o bairro da pesquisa
     *
     * @return
     */
    public String getBairro() {
        Elements urlPesquisa = doc.select("td:gt(1)");
        bairro = urlPesquisa.text().replace(getCidade(), "");//remove o nome da cidade da variavel 
        bairro = bairro.replace(getCidade(), "").replace(getUf(), "");//remove o estado da variavel bairro
        return bairro.toUpperCase().replace(getCidade(), "");
    }

    /**
     * Retorna o uf da pesquisa
     *
     * @return
     */
    public String getUf() {
        Elements urlPesquisa = doc.select("span[itemprop=addressRegion]");
        uf = urlPesquisa.text();
        return uf.toUpperCase();
    }

    /**
     * Retorna a cidade da pesquisa
     *
     * @return
     */
    public String getCidade() {
        Elements urlPesquisa = doc.select("span[itemprop=addressLocality]");
        cidade = urlPesquisa.text();
        return cidade.toUpperCase();
    }

    /**
     * Retorna o cep
     *
     * @return
     */
    public String getCep() {
        Elements urlPesquisa = doc.select("span[itemprop=postalCode]");
        cep = urlPesquisa.text();
        return cep.toUpperCase();
    }

    /**
     * Retorna o html da página de onde foi retirado os dados
     *
     * @return
     */
    public Document getDoc() {
        return doc;
    }

    public static void main(String args[]) {
        CepBean bc = new CepBean();
        bc.buscarEndereco("13.221-300".replace(".", "").replace("-", ""));
        System.err.println(bc.getEndereco());// imprime o endereco
        System.err.println(bc.getBairro());// imprime o bairro
        System.err.println(bc.getCidade());// imprime a cidade
        System.err.println(bc.getUf());// imprime o uf
        System.err.println(bc.getCep());// imprime o cep
         System.err.println(bc.getDoc());//imprime o html da pagina
    }

}
