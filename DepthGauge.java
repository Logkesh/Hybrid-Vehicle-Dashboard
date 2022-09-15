package hybrid;

public class DepthGauge {
	private int depth;

	public void setdepth(int depth) {
		this.depth = depth;
	}

	public int getdepth() {
		return this.depth;
	}

	public void incrementdepth(int depth) {
		this.depth += depth;
	}

	public void decrementdepth(int depth) {
		if (this.depth > 0)
			this.depth -= depth;
		this.depth = 0;
	}

	public void displayDepth() {
		System.out.println("Depth: " + depth + " m");
	}

}