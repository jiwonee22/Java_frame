package ajax.dto;

public class ResultData {
	
	private String data1;
	private int data2;
	private boolean data3;
	
	public ResultData() {}
	
	public ResultData(String data1, int data2, boolean data3) {
		this.data1 = data1;
		this.data2 = data2;
		this.data3 = data3;
	}
	
	@Override
	public String toString() {
		return "ResultData [data1=" + data1 + ", data2=" + data2 + ", data3=" + data3 + "]";
	}

	public String getData1() {
		return data1;
	}

	public void setData1(String data1) {
		this.data1 = data1;
	}

	public int getData2() {
		return data2;
	}

	public void setData2(int data2) {
		this.data2 = data2;
	}

	public boolean isData3() {
		return data3;
	}

	public void setData3(boolean data3) {
		this.data3 = data3;
	}
	
	
	
	

}
