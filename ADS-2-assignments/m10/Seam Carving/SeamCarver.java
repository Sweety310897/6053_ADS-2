
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
		// System.out.println("xval" + x + " " + "yval" + y);
		if(x == 0 || y == 0 || x == height()-1 || y == width()-1) {
			return 1000;
		}
		double tempx;
		double tempy;
		double xtemp1red = p.get(x - 1,y).getRed();
		double xtemp1blue = p.get(x - 1,y).getBlue();
		double xtemp1green = p.get(x - 1,y).getGreen();
		double xtemp2red = p.get(x + 1,y).getRed();
		double xtemp2blue = p.get(x + 1,y).getBlue();
		double xtemp2green = p.get(x + 1,y).getGreen();
		double ytemp1red = p.get(x ,y-1).getRed();
		double ytemp1blue = p.get(x ,y-1).getBlue();
		double ytemp1green = p.get(x ,y-1).getGreen();
		double ytemp2red = p.get(x , y+1).getRed();
		double ytemp2blue = p.get(x ,y+1).getBlue();
		double ytemp2green = p.get(x ,y+1).getGreen();
		tempx = Math.pow(xtemp1red - xtemp2red, 2) + Math.pow(xtemp1blue - xtemp2blue, 2) +Math.pow(xtemp1green - xtemp2green , 2);
		tempy = Math.pow(ytemp1red - ytemp2red, 2) + Math.pow(ytemp1blue - ytemp2blue, 2) +Math.pow(ytemp1green - ytemp2green , 2);
		double energysum = Math.sqrt(tempx + tempy);
		System.out.println(energysum);
		return energysum;
		//return 0;
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