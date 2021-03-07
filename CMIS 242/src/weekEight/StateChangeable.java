package weekEight;
//////////////////////////////////////////////////////////
//File Name: StateChangeable.java
//Author: Eddy Owings
//Date: 12/11/2020
//Description: An interface that has a bounded generic type
// parameter that is of the enum type contains one abstract
// method.
//////////////////////////////////////////////////////////
public interface StateChangeable<T extends Enum<T>> {
    abstract void changeState(T t);
}// End StateChangeable