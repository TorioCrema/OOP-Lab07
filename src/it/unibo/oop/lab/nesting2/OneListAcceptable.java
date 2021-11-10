package it.unibo.oop.lab.nesting2;

import java.util.Iterator;
import java.util.List;

import it.unibo.oop.lab.nesting2.Acceptor.ElementNotAcceptedException;
import it.unibo.oop.lab.nesting2.Acceptor.EndNotAcceptedException;

public class OneListAcceptable<T> implements Acceptable<T> {

	private final List<T> list;
	
	public OneListAcceptable(final List<T> list) {
		this.list = list;
	}

	@Override
	public Acceptor<T> acceptor() {
		final Acceptor<T> acceptor = new Acceptor<T>() {
			private final Iterator<T> iterator = OneListAcceptable.this.list.iterator();

			@Override
			public void accept(T newElement) throws ElementNotAcceptedException {
				if (!(this.iterator.hasNext() && this.iterator.next() ==  newElement)) {
					final ElementNotAcceptedException e = new ElementNotAcceptedException(newElement);
					throw e;
				}
			}

			@Override
			public void end() throws EndNotAcceptedException {
				if (this.iterator.hasNext()) {
					final EndNotAcceptedException e = new EndNotAcceptedException();
					throw e;
				}
			}		
		};
		return acceptor;
	}
}
