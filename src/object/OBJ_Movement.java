package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Movement extends SuperObject{

	public OBJ_Movement(){
		
		name = "Movement";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/object/movement.png"));
		} catch (IOException  e) {
			e.printStackTrace();
		}
				
	}
}
