package com.springincation.springidol;

import org.springframework.beans.factory.annotation.Autowired;

public class PoeticJuggler extends Juggler {

	@Autowired(required=true)
	private Poem poem;
	
	public PoeticJuggler(Poem poem) {
		super();
		this.poem = poem;
	}

	public PoeticJuggler(int beanBags,Poem poem) {
		super(beanBags);
		this.poem=poem;
	}
	
	public void perform (){
		super.perform();
		System.out.println("while reciting....");
		poem.recite();
	}
	
}
