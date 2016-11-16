package br.com.cwi;

import br.com.cwi.importacao.ImportCSV;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ImportCSV importCSV = new ImportCSV();
        importCSV.run();
        
        System.out.println(importCSV.listTaxas.get("USD"));
        System.out.println(importCSV.listTaxas.get("EUR"));        
        
    }
}
