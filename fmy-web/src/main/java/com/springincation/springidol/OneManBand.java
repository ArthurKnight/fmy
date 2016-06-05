package com.springincation.springidol;

import java.util.Collection;

public class OneManBand implements Performer {

	private Collection<Instrument>instruments;
	

	@Override
	public void perform() {
		for (Instrument ins : instruments) {
			ins.play();
		}

	}

	public Collection<Instrument> getInstruments() {
		return instruments;
	}

	public void setInstruments(Collection<Instrument> instruments) {
		this.instruments = instruments;
	}
	
	
}
