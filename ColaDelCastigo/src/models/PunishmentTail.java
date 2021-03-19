package models;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PunishmentTail<E> extends PriorityQueue<E> {
	
	private static final long serialVersionUID = -2742437942072678931L;
	
	public PunishmentTail(Comparator<E> comparator) {
		super(comparator);
	}
	
}
