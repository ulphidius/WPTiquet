package ovh.workparadise.classedb;

import java.sql.Date;

public class Parameter<T> {
	private T _value;
	
	public Parameter(T value) {
		this._value = value;
	}
	
	public T get() {
		return this._value;
	}
	
	public String getType() {
		if (this._value instanceof Integer) {
			return "int";
		
		}else if(this._value instanceof String) {
			return "String";
			
		}else if(this._value instanceof Double) {
			return "double";
			
		}else if(this._value instanceof Float) {
			return "float";
			
		}else if(this._value instanceof Long) {
			return "long";
			
		}else if(this._value instanceof Date) {
			return "Date";
			
		}else if(this._value instanceof Boolean){
			return "boolean";
			
		}else {
			return null;
		
		}
	}
}
