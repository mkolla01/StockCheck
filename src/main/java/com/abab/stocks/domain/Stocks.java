package com.abab.stocks.domain;

import java.util.Date;

public class Stocks {	
	
	private String symbol; 
	private Date trddate ;
	private Double openprc;
	private Double highprc;
	private Double lowprc;
	private Double closeprc;
	private Integer volume;
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public Date getTrddate() {
		return trddate;
	}
	public void setTrddate(Date trddate) {
		this.trddate = trddate;
	}
	public Double getOpenprc() {
		return openprc;
	}
	public void setOpenprc(Double openprc) {
		this.openprc = openprc;
	}
	public Double getHighprc() {
		return highprc;
	}
	public void setHighprc(Double highprc) {
		this.highprc = highprc;
	}
	public Double getLowprc() {
		return lowprc;
	}
	public void setLowprc(Double lowprc) {
		this.lowprc = lowprc;
	}
	public Double getCloseprc() {
		return closeprc;
	}
	public void setCloseprc(Double closeprc) {
		this.closeprc = closeprc;
	}
	public Integer getVolume() {
		return volume;
	}
	public void setVolume(Integer volume) {
		this.volume = volume;
	}

public String toString(){
	StringBuilder sb = new StringBuilder();
	sb.append("Symbol:"+this.getSymbol());
	sb.append("Tradedate:"+this.getTrddate());
	sb.append("Open Price:"+this.getOpenprc());
	sb.append("High Price:"+this.getHighprc());
	sb.append("Low Price:"+this.getLowprc());
	sb.append("Close Price:"+this.getCloseprc());
	sb.append("Volume:"+this.getVolume());
	return sb.toString();
}

}
