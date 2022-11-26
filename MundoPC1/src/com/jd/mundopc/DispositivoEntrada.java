package com.jd.mundopc;

public class DispositivoEntrada {
	private String tipoEntradara;
	private String marca; 
	
	public DispositivoEntrada(String tipoEntrada, String marca) {
		this.tipoEntradara = tipoEntrada; 
		this.marca = marca; 
	}

	public String getTipoEntradara() {
		return tipoEntradara;
	}

	public void setTipoEntradara(String tipoEntradara) {
		this.tipoEntradara = tipoEntradara;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "DispositivoEntrada [tipoEntradara=" + tipoEntradara + ", marca=" + marca + "]";
	}
	
	
}
