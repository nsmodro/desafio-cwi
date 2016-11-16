package br.com.cwi;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.cwi.importacao.ImportCSV;

public class Testes {

	@Test
	public void validaExtensaoArquivo() {
		ImportCSV importCSV = new ImportCSV();
		assertTrue(importCSV.isCSVFile("file.csv"));
		assertTrue(importCSV.isCSVFile("file.file-.csv"));
		assertFalse(importCSV.isCSVFile("file.txt"));
	}

}
