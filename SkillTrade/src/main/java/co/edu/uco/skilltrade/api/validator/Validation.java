package co.edu.uco.skilltrade.api.validator;

public interface Validation<T> {
	
	Result execute(T data);

}
