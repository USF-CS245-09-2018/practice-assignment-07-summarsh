
public class ArrayList implements List {
	protected int size;
	protected Object[] arr;

	public ArrayList() {
		int size = 0;
		arr = new Object[100000];

	}

	public void add(Object obj) {
		if(size == arr.length) {
			grow_array();
		}
		arr[size] = obj;
		++size;
	}

	public void add(int pos, Object obj) {
		if(pos>size || pos<0) {
			throw new IllegalArgumentException("empty");
		} else if(size == arr.length) {
			grow_array();
		}
		for(int i=size; i > pos; i--) {
			arr[i] = arr[i+1];
		}
		arr[pos] = obj;
		size++;
	}

	public Object get(int pos) { 
		if(pos>size || pos<0){
			throw new IllegalArgumentException("empty");
		}
		return arr[pos];
	}

	public Object remove(int pos) {
		if(pos>=size || pos < 0) {
			throw new IllegalArgumentException("empty");
		}
		Object temp = arr[pos];
		for(int i=pos; i<size-1; i++) {
			arr[i] = arr[i+1];
		}
		size--;
		return temp;
	}

	public int size() {
		return size;
	}

	public void grow_array() {
		Object[] newArray = new Object[arr.length*2];
		for(int i=0; i<=size; i++) {
			newArray[i] = arr[i+1];
		}
		arr = newArray;
	}
}