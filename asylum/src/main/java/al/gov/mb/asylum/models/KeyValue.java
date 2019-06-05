package al.gov.mb.asylum.models;

import java.util.Date;

import al.gov.mb.asylum.utils.DateUtil;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class KeyValue {
	
	
	String key;
	Object value;
	
	public KeyValue(){}
	
	public KeyValue(Date key, Long value)
	{
		this.key = DateUtil.formatDateToString(key);
		this.value = value;
	}
	
	public KeyValue(String key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}
	
	public KeyValue(Character key, Object value) {
		super();
		this.key = String.valueOf(key);
		this.value = value;
	}
	
	

}
