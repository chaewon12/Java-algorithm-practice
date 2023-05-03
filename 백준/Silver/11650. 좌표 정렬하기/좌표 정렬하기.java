import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Point> points=new ArrayList<>();

		int count = Integer.parseInt(br.readLine());

		for (int i = 0; i < count; i++) {
			String[] point=br.readLine().split(" ");
			points.add(new Point(Integer.parseInt(point[0]),Integer.parseInt(point[1])));
		}

		points.stream()
			  .sorted(Comparator.comparing(Point::getX).thenComparing(Point::getY))
			  .forEach(System.out::println);
	}
}

class Point {
	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return x + " " + y;
	}
}