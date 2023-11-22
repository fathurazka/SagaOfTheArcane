package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Health extends SuperObject {
	public OBJ_Health(){
		
		name = "Health";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/object/sprite_7.png"));
			image1 = ImageIO.read(getClass().getResourceAsStream("/object/sprite_6.png"));
			image2 = ImageIO.read(getClass().getResourceAsStream("/object/sprite_5.png"));
			image3 = ImageIO.read(getClass().getResourceAsStream("/object/sprite_4.png"));
			image4 = ImageIO.read(getClass().getResourceAsStream("/object/sprite_3.png"));
			image5 = ImageIO.read(getClass().getResourceAsStream("/object/sprite_2.png"));
			image6 = ImageIO.read(getClass().getResourceAsStream("/object/sprite_1.png"));
			image7 = ImageIO.read(getClass().getResourceAsStream("/object/sprite0.png"));
		} catch (IOException  e) {
			e.printStackTrace();
		}
				
	}
}
