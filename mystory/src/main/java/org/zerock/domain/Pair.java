package org.zerock.domain;

public class Pair<F, S> {
	public final F first;
	public final S second;
	
	public Pair(F first, S second) {
		this.first = first;
		this.second = second;
	}
	
	public F getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }
}
