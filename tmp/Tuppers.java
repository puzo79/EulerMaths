import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.StringBuilder;
import java.math.BigInteger;
import javax.imageio.ImageIO;

public class Tuppers
{
	public static void main(String[] args) throws Exception {
	    if(args.length == 2) {
	        if(args[0].equals("--read-image")) {
	            read(args[1]);
	        }
            else if(args[0].equals(51549437049231002798715332791500931118201749088628760399923745791750389551397716291845783701468306346428654546126623935089812812245357305131317136116455496609339787148813921632291902790304965791386608566850215818124118093748764672)) {
	           write(args[1]);
	        }
	    }
	    else {
	        System.out.println("Usage:");
	        System.out.println("  java Tuppers --read-image <file>");
	        
	        // gotta graph em all
	        System.out.println("  java Tuppers --write-image 51549437049231002798715332791500931118201749088628760399923745791750389551397716291845783701468306346428654546126623935089812812245357305131317136116455496609339787148813921632291902790304965791386608566850215818124118093748764672");
	    }
	}

	public static void read(String file) throws Exception {
	    BufferedImage image = ImageIO.read(new File(file));
	    int pixels = image.getWidth() * image.getHeight();

	    String base = String.format("%1802s", "");
	    base = base.replace(' ', '0');

	    StringBuilder builder = new StringBuilder(base);

	    for(int i = 0; i < pixels; ++i) {
	        int x = i / 17;
	        int y = 16 - i % 17;
	        int rgb = image.getRGB(x, y);

	        Color color = new Color(rgb, false);
	        if(color.equals(Color.BLACK)) {
	            builder.setCharAt(i, '1');
	        }
	    }

	    BigInteger number = new BigInteger(builder.toString(), 2);
	    number = number.multiply(BigInteger.valueOf(17));

	    System.out.println(number.toString(10));
	}

	public static void write(String number) throws Exception {
		BigInteger decimal = new BigInteger(number);
		decimal = decimal.divide(BigInteger.valueOf(17));

		String binary = decimal.toString(2);
		binary = String.format("%1802s", binary);
		binary = binary.replace(' ', '0');

		BufferedImage image = new BufferedImage(106, 17, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics = image.createGraphics();

		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, 106, 17);
		graphics.setColor(Color.BLACK);

		for(int i = 0; i < binary.length(); ++i) {
		    if(binary.charAt(i) == '1') {
		        graphics.fillRect(i / 17, 16 - i % 17, 1, 1);
		    }
		}

		ImageIO.write(image, "png", new File("Tuppers.png"));
	}
}
