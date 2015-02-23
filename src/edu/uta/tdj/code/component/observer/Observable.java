package edu.uta.tdj.code.component.observer;
/**
 * 2015 2015��2��22��
 * @author Fuqiang Zhang
 */
public interface Observable {
	public void add(Observer observer);
	public void remove(Observer observer);
	public void notifyObservers();
}
