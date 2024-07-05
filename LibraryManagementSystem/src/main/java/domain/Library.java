package main.java.domain;

import main.java.service.IDGenerator;

public class Library {

	private Rack[] racks;

	public Library(int n) {
		super();
		initializeRacks(n);
	}

	private void initializeRacks(int n) {
		racks=new Rack[n];
		for(int i=0;i<n;i++) {
			racks[i]=new Rack(IDGenerator.getNextID(), i+1);
		}
	}

	public Rack[] getRacks() {
		return racks;
	}

	public void setRacks(Rack[] racks) {
		this.racks = racks;
	}
	
}
