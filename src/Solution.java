import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Solution {

	public List<ExceptionProxy> transformException(List<Supplier<?>> functions) {
		List<ExceptionProxy> exceptionProxyList = new ArrayList<>();
		if (functions.size() > 0) {
			for (int i = 0; i < functions.size(); i++) {
				ExceptionProxy exceptionProxy = new ExceptionProxy();
				Supplier<?> result = functions.get(i);
				try {
					result.get();
				}catch (Exception e) {
					exceptionProxy.setMsg(e.getMessage());
				}
				if (exceptionProxy.getMsg() == null) {
					exceptionProxy.setMsg("OK!");
				}
				exceptionProxy.setFunction(result);
				exceptionProxyList.add(exceptionProxy);
			}
		}
		return exceptionProxyList;
	}

	public static class ExceptionProxy {
		private String msg;
		private Supplier<?> function;

		public void setMsg(String msg) {
			this.msg = msg;
		}
		public String getMsg() {
			return msg;
		}

		public void setFunction(Supplier<?> function) {
			this.function = function;
		}
		public Supplier<?> getFunction() {
			return function;
		}
	}
	
	public static void main(String[] args) {
		List<Supplier<?>> functions = Arrays.asList(new Devider(1,0), new Devider(1,1));
		
		Solution solution = new Solution();
		List<ExceptionProxy> result = solution.transformException(functions);
		for(ExceptionProxy exceptionProxy: result) {
			System.out.println("msg: " + exceptionProxy.getMsg());
			System.out.println("function: " + exceptionProxy.getFunction());
		}
	}
	
	public static class Devider implements Supplier<Integer> {
		int x, y;
		public Devider(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public Integer get() {
			return x / y;
		}
		@Override
		public String toString() {
			return "Devide[" + x + "/" + y + "]";
		}
	}
}
