package chap08;

import java.util.Arrays;
import java.util.Comparator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor

public abstract class Data {
	Integer[] data;
	
	public void setData(Integer...  data) {
		this.data = data;
	}
	
	public String toString() {
		return Arrays.toString(data);
	}
	
	public abstract void sort();
	
	
}

class AscData extends Data{
	
	@Override
	public void sort() {
		Arrays.sort(data);
	}
}

class DescData extends Data{
	
	@Override
	public void sort() {
		Arrays.sort(data, Comparator.reverseOrder());
	}
}