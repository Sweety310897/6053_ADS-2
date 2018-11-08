
public class SeamCarver {
	// create a seam carver object based on the given picture
	Picture p;
	private int width;
	private int height;
	int[][] energymat;
	public SeamCarver(Picture picture) {
		this.p = picture;
		this.width = p.width();
		this.height = p.height();
	}
	// current picture
	public Picture picture() {
		return p;
	}
	// width of current picture
	public int width() {
		return width;
	}

	// height of current picture
	public int height() {
		return height;
	}

	// energy of pixel at column x and row y
	public double energy(int x, int y) {
		System.out.println("xval" + x + " " + "yval" + y);
		if(x == 0 || y == 0 || x == height()-1 || y == width()-1) {
			energymat[x][y] = 1000;
		}
		else {

		}
		return energymat[x][y];
	}

	// sequence of indices for horizontal seam
	public int[] findHorizontalSeam() {
		return new int[0];
	}

	// sequence of indices for vertical seam
	public int[] findVerticalSeam() {
		return new int[0];
	}

	// remove horizontal seam from current picture
	public void removeHorizontalSeam(int[] seam) {

	}

	// remove vertical seam from current picture
	public void removeVerticalSeam(int[] seam) {

	}
}